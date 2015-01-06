/**
 * 
 */
package fr.afcepf.al22.orchestration.entities;

/**
 * @author Stagiaire
 *
 */
public class ProduitCommande {

	/**
	 * Identifiant en base du produit commandee.
	 */
	private int idProduit;
	
	/**
	 * Quantite commande et normalement en stock.
	 */
	private int quantiteCommande;

	/**
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the quantiteCommande
	 */
	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	/**
	 * @param quantiteCommande the quantiteCommande to set
	 */
	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}
	
}
