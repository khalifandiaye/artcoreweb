package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the format database table.
 * 
 */
@Entity
@Table(name = "format")
@NamedQuery(name="Format.findAll", query="SELECT f FROM Format f")
public class Format implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_format")
	private int idFormat;

	@Column(name="libelle_format")
	private String libelleFormat;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="format")
	private List<Produit> produits;

	public Format() {
	}

	public int getIdFormat() {
		return this.idFormat;
	}

	public void setIdFormat(int idFormat) {
		this.idFormat = idFormat;
	}

	public String getLibelleFormat() {
		return this.libelleFormat;
	}

	public void setLibelleFormat(String libelleFormat) {
		this.libelleFormat = libelleFormat;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setFormat(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setFormat(null);

		return produit;
	}

}