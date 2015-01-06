package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_theme")
	private int idTheme;

	@Column(name="libelle_theme")
	private String libelleTheme;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="themes")
	private List<Produit> produits;

	public Theme() {
	}

	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getLibelleTheme() {
		return this.libelleTheme;
	}

	public void setLibelleTheme(String libelleTheme) {
		this.libelleTheme = libelleTheme;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}