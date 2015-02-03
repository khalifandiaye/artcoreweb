package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.Produit;


/**
 * Classe de simples objets correspondant � l'entit� {@link Categorie}.
 * 
 */
public class DtoCategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCategorie;
	private String libelleCategorie;
	private List<DtoProduit> produits;

	//constructeurs
	public DtoCategorie() {
	}
	public DtoCategorie(int idCategorie, String libelleCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.libelleCategorie = libelleCategorie;
	}


	//getter setter
	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelleCategorie() {
		return this.libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	public List<DtoProduit> getProduits() {
		return produits;
	}
	public void setProduits(List<DtoProduit> produits) {
		this.produits = produits;
	}
	

}