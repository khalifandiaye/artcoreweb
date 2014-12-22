package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import fr.afcepf.al22.artcore.entities.LigneDeCommande;


/**
 * Classe de simples objets correspondant � l'entit� {@link LigneDeCommande}.
 * 
 */
public class DtoLigneDeCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idLigneCommande;
	private int numeroLigne;

	private int quantiteProduit;

	private BigDecimal tva;
	private DtoCommande commande;
	private DtoProduit produit;

	//constructeurs
	public DtoLigneDeCommande() {
	}
	public DtoLigneDeCommande(Integer idLigneCommande, DtoProduit produit,
			int quantiteProduit,
			BigDecimal tva) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.produit = produit;
		this.commande = commande;
		this.quantiteProduit = quantiteProduit;
		this.tva = tva;
		//this.commande=commande;
	}

	//getter setter

	public int getQuantiteProduit() {
		return this.quantiteProduit;
	}

	public void setQuantiteProduit(int quantiteProduit) {
		this.quantiteProduit = quantiteProduit;
	}

	public BigDecimal getTva() {
		return this.tva;
	}

	public void setTva(BigDecimal tva) {
		this.tva = tva;
	}
	public DtoCommande getCommande() {
		return commande;
	}
	public void setCommande(DtoCommande commande) {
		this.commande = commande;
	}
	public int getNumeroLigne() {
		return numeroLigne;
	}
	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}
	public DtoProduit getProduit() {
		return produit;
	}
	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	
	public int getIdLigneCommande() {
		return idLigneCommande;
	}
	@Override
	public String toString() {
		return "DtoLigneDeCommande [idLigneCommande=" + idLigneCommande
				+ ", numeroLigne=" + numeroLigne + ", quantiteProduit="
				+ quantiteProduit + ", tva=" + tva + ", commande=" + commande
				+ ", produit=" + produit + "]";
	}
	
	
	

}