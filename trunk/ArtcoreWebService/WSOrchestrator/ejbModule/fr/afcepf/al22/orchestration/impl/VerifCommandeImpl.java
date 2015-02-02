package fr.afcepf.al22.orchestration.impl;

import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;

import fr.afcepf.al22.antivol.AntivolCBImplService;
import fr.afcepf.al22.antivol.IAntivolCB;
import fr.afcepf.al22.artcorewebservice.wspolice.IVerifCasier;
import fr.afcepf.al22.artcorewebservice.wspolice.VerifCasierImplService;
import fr.afcepf.al22.orchestration.entities.CheckResultProduitCommande;
import fr.afcepf.al22.orchestration.entities.ProduitCommande;
import fr.afcepf.al22.orchestration.interfaces.IVerifCommande;
import fr.afcepf.al22.wsartcore.GestionStockImplService;
import fr.afcepf.al22.wsartcore.IGestionStock;


/**
 * implementation de l'interface IverfiCommande
 * @author gf
 *
 */
@Stateless
@WebService(endpointInterface="IVerifCommande")
public class VerifCommandeImpl implements IVerifCommande  {

	/**
	 * @see fr.afcepf.al22.orchestration.interfaces.IVerifCommande#verifCommande(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public CheckResultProduitCommande verifCommande(@WebParam(name="nom")String nomUser,
			@WebParam(name="prenom")String prenomUser, @WebParam(name="birthday")String dateNaissance,@WebParam(name="cbNumber") String cbNumber,@WebParam(name="listeProduit")
			List<ProduitCommande> lProduit) {
	    	//Recuperation des url pour atteindre les WebService's
	    	ResourceBundle rb = ResourceBundle.getBundle("db");
		String urlWSPolice = rb.getString("urlPolice");
		String urlWSGestionStock = rb.getString("urlGestionStock");
		String urlWSAntivolCB = rb.getString("urlAntivolCB");
		
//		VerifCommandeImplService verifWS = new VerifCommandeImplService();
//		IVerifCommande port = verifWS.getVerifCommandeImplPort();
//
//		BindingProvider bindingProvider = (BindingProvider) port;
//		log.debug("WS bind adresse : "+"http://"+url+"/WSOrchestrator/VerifCommandeImpl");
//		bindingProvider.getRequestContext().put(
//			BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//			"http://"+url+"/WSOrchestrator/VerifCommandeImpl");
//	//192.168.100.129
//		CheckResultProduitCommande validation = port.verifCommande(mbCnx
//			.getDtoClient().getNomClient(), mbCnx.getDtoClient()
//			.getPrenomClient(), dateNaissance, numeroCarteDuClient,
//			listeProduit);
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
		/** HAL 28/01/2015 on passe par un bindingPort pour modifier l'adresse ip d'acces.*/
		IVerifCasier portCasier = verifC.getVerifCasierImplPort();
		IAntivolCB portAntivol = antiVolCb.getAntivolCBImplPort();
		IGestionStock portGestionStock = gestionStock.getGestionStockImplPort();
		
		/** HaL et on rajoute le portBinding*/
		BindingProvider bindingProviderCasier = (BindingProvider) portCasier;
		BindingProvider bindingProviderAntivol = (BindingProvider) portAntivol;
		BindingProvider bindingProviderStock = (BindingProvider) portGestionStock;
		/** on put le Biding endpoint */
		bindingProviderCasier.getRequestContext().put(
			BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
			"http://"+urlWSPolice+"/WSPolice/VerifCasierImpl");
		
		bindingProviderAntivol.getRequestContext().put(
			BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
			"http://"+urlWSAntivolCB+"/WSAntivolCB/AntivolCBImpl");
		
		bindingProviderStock.getRequestContext().put(
			BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
			"http://"+urlWSGestionStock+"/WSGestionStock/GestionStockImpl");
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
