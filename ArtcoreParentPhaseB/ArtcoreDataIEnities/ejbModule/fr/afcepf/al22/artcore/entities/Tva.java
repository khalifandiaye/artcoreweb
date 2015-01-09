package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tva database table.
 * 
 */
@Entity
@NamedQuery(name="Tva.findAll", query="SELECT t FROM Tva t")
public class Tva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tva")
	private int idTva;

	@Column(name="taux_tva")
	private BigDecimal tauxTva;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="tva")
	private List<Produit> produits;

	public Tva() {
	}

	public int getIdTva() {
		return this.idTva;
	}

	public void setIdTva(int idTva) {
		this.idTva = idTva;
	}

	public BigDecimal getTauxTva() {
		return this.tauxTva;
	}

	public void setTauxTva(BigDecimal tauxTva) {
		this.tauxTva = tauxTva;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setTva(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setTva(null);

		return produit;
	}

}