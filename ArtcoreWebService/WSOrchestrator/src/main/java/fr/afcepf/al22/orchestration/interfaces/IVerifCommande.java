/**
 * 
 */
package fr.afcepf.al22.orchestration.interfaces;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al22.orchestration.entities.CheckResultProduitCommande;
import fr.afcepf.al22.orchestration.entities.ProduitCommande;

/**
 * @author Stagiaire
 *
 */
@Remote
@WebService
public interface IVerifCommande {
	
	
	/** Verification d'une commande.
	 * Verif nom prenom date de naissance dans proccess police
	 * verif CB
	 * Verif Produit en stock.
	 * @param nomUser Nom de l'utilisateur a verifier
	 * @param prenomUser prenom de l'utilisateur a verifier, not null
	 * @param dateNaissance
	 * @param cbNumber
	 * @param lProduit
	 * @return
	 */
	public CheckResultProduitCommande verifCommande(@WebParam(name="nom")String nomUser,@WebParam(name="prenom")String prenomUser,@WebParam(name="birthday")String dateNaissance,@WebParam(name="cbNumber")String cbNumber,@WebParam(name="listeProduit") List<ProduitCommande> lProduit);
	

}
