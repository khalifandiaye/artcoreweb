package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the fournisseur database table.
 * 
 */
@Entity
@Table(name = "fournisseur")
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fournisseur")
	private int idFournisseur;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin_activite")
	private Date dateFinActivite;

	@Column(name="mail_fournisseur")
	private String mailFournisseur;

	@Column(name="nom_fournisseur")
	private String nomFournisseur;

	@Column(name="tel_fournisseur")
	private String telFournisseur;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private Adresse adresse;

	//bi-directional many-to-one association to Civilite
	@ManyToOne
	@JoinColumn(name="id_civilite")
	private Civilite civilite;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public Fournisseur() {
	}

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

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Civilite getCivilite() {
		return this.civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	

}