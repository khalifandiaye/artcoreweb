package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Theme;


/**
 * Classe de simples objets correspondant � l'entit� {@link Theme}.
 * 
 */
public class DtoTheme implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idTheme;
	private String libelleTheme;
	private List<DtoProduit> produits;

	//constructeurs
	public DtoTheme() {
	}
	public DtoTheme(int idTheme, String libelleTheme) {
		super();
		this.idTheme = idTheme;
		this.libelleTheme = libelleTheme;
	}

	//getter setter
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
	public List<DtoProduit> getProduits() {
		return produits;
	}
	public void setProduits(List<DtoProduit> produits) {
		this.produits = produits;
	}
	
	
	

}