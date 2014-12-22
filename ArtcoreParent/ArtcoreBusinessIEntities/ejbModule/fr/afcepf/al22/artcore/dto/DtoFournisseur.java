package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Fournisseur;
import fr.afcepf.al22.artcore.entities.Produit;

import java.util.Date;


/**
 * Classe de simples objets correspondant � l'entit� {@link Fournisseur}.
 * 
 */
public class DtoFournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs

	private int idFournisseur;
	private Date dateFinActivite;
	private String mailFournisseur;

	private String nomFournisseur;
	private String telFournisseur;
	private DtoAdresse adresse;

	private DtoCivilite civilite;

	private DtoProduit produit;


	//constructeurs
	public DtoFournisseur() {
	}
	public DtoFournisseur(int idFournisseur, Date dateFinActivite,
			DtoAdresse adresse, DtoCivilite civilite, DtoProduit produit,
			String mailFournisseur, String nomFournisseur, String telFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.dateFinActivite = dateFinActivite;
		this.adresse = adresse;
		this.civilite = civilite;
		this.produit = produit;
		this.mailFournisseur = mailFournisseur;
		this.nomFournisseur = nomFournisseur;
		this.telFournisseur = telFournisseur;
	}

	//getter setter
	public int getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public Date getDateFinActivite() {
		return this.dateFinActivite;
	}

	public void setDateFinActivite(Date dateFinActivite) {
		this.dateFinActivite = dateFinActivite;
	}

	public String getMailFournisseur() {
		return this.mailFournisseur;
	}

	public void setMailFournisseur(String mailFournisseur) {
		this.mailFournisseur = mailFournisseur;
	}

	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getTelFournisseur() {
		return this.telFournisseur;
	}

	public void setTelFournisseur(String telFournisseur) {
		this.telFournisseur = telFournisseur;
	}
	public DtoAdresse getAdresse() {
		return adresse;
	}
	public void setAdresse(DtoAdresse adresse) {
		this.adresse = adresse;
	}
	public DtoCivilite getCivilite() {
		return civilite;
	}
	public void setCivilite(DtoCivilite civilite) {
		this.civilite = civilite;
	}
	public DtoProduit getProduit() {
		return produit;
	}
	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
	

}