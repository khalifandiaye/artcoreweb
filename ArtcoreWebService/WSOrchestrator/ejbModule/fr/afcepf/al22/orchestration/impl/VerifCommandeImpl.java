package fr.afcepf.al22.orchestration.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al22.antivol.AntivolCBImplService;
import fr.afcepf.al22.artcorewebservice.wspolice.VerifCasierImplService;
import fr.afcepf.al22.orchestration.entities.CheckResultProduitCommande;
import fr.afcepf.al22.orchestration.entities.ProduitCommande;
import fr.afcepf.al22.orchestration.interfaces.IVerifCommande;
import fr.afcepf.al22.wsartcore.GestionStockImplService;

@Stateless
@WebService
/**
 * implementation de l'interface IverfiCommande
 * @author gf
 *
 */
public class VerifCommandeImpl implements IVerifCommande  {

	/**
	 * @see fr.afcepf.al22.orchestration.interfaces.IVerifCommande#verifCommande(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public CheckResultProduitCommande verifCommande(@WebParam(name="nom")String nomUser,
			@WebParam(name="prenom")String prenomUser, @WebParam(name="birthday")String dateNaissance,@WebParam(name="cbNumber") String cbNumber,@WebParam(name="listeProduit")
			List<ProduitCommande> lProduit) {
		/**
		 * initialisation de CheckResultProduitCommande pour notre retour de méthode
		 */
		CheckResultProduitCommande CRPC = new CheckResultProduitCommande();
		/**
		 * generation des proxy pour les trois webservices WSPolice, WSAntivolCB, WsGestionStock
		 */
		VerifCasierImplService verifC = new VerifCasierImplService() ;
		AntivolCBImplService antiVolCb = new AntivolCBImplService();
		GestionStockImplService gestionStock = new GestionStockImplService();
		
		/**
		 * attribution des valeurs du retour en appellant les méthodes des webservices
		 */
		CRPC.setAlertePolice(verifC.getVerifCasierImplPort().verifCasier(nomUser, prenomUser, dateNaissance));
		CRPC.setAlerteCB(antiVolCb.getAntivolCBImplPort().rechercheCBVoleeParNumero(cbNumber)); 
		
		for (ProduitCommande p:lProduit){
			p.setQuantiteCommande(gestionStock.getGestionStockImplPort().rechercherNbProduitDisponible(p.getIdProduit())-p.getQuantiteCommande());
		}
		CRPC.setListeProduits(lProduit);
		
		return CRPC;
	}

	
	
}
