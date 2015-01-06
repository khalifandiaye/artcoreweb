package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ligne_de_commande database table.
 * 
 */
@Entity
@Table(name="ligne_de_commande")
@NamedQuery(name="LigneDeCommande.findAll", query="SELECT l FROM LigneDeCommande l")
public class LigneDeCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ligne_commande")
	private int idLigneCommande;

	@Column(name="numero_ligne")
	private int numeroLigne;

	@Column(name="quantite_produit")
	private int quantiteProduit;

	private BigDecimal tva;

	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="id_commande")
	private Commande commande;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public LigneDeCommande() {
	}

	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getNumeroLigne() {
		return this.numeroLigne;
	}

	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

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

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}