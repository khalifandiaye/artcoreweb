package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.EvaluationProduit;
import fr.afcepf.al22.artcore.entities.Produit;


/**
 * Classe de simples objets correspondant � l'entit� {@link Format}.
 * 
 */
public class DtoFormat implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idFormat;
	private String libelleFormat;
	private List<Produit> produits;


	//constructeurs
	public DtoFormat() {
	}
	public DtoFormat(int idFormat, String libelleFormat) {
		super();
		this.idFormat = idFormat;
		this.libelleFormat = libelleFormat;
	}

	//getter setter
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
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

}