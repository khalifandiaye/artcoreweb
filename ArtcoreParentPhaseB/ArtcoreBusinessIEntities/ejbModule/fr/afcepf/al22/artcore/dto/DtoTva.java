package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Tva;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Classe de simples objets correspondant à l'entité {@link Tva}.
 * 
 */
public class DtoTva implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs

	private int idTva;
	private BigDecimal tauxTva;
	private List<Produit> produits;

	//constructeurs
	public DtoTva() {
	}
	public DtoTva(int idTva, BigDecimal tauxTva) {
		super();
		this.idTva = idTva;
		this.tauxTva = tauxTva;
	}

	//getter setter
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
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	

}