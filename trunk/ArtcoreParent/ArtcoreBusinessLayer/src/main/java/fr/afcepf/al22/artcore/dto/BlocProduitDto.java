package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BlocProduitDto implements Serializable {
	/**
	 * Cet objet permet de gerer plus facilemennt les lignes de commandes .il est utilisé par  l interface IBusinessPanier
	 */
	private static final long serialVersionUID = 1L;
	private DtoProduit produit;
	private int quantite;
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public DtoProduit getProduit() {
		return produit;
	}

	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}

	public BlocProduitDto(DtoProduit produit) {
		this.produit = produit;
		this.quantite=1;
	}

	public BigDecimal getPrixTotalParPdt(){
		return this.produit.getPrixProduit().multiply(new BigDecimal(quantite));
	}
}
