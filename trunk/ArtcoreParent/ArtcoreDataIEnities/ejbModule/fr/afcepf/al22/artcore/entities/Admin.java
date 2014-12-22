package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_admin")
	private int idAdmin;

	@Column(name="mail_admin")
	private String mailAdmin;

	@Column(name="nom_admin")
	private String nomAdmin;

	@Column(name="prenom_admin")
	private String prenomAdmin;

	@Column(name="tel_admin")
	private String telAdmin;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private Adresse adresse;

	//bi-directional many-to-one association to Civilite
	@ManyToOne
	@JoinColumn(name="id_civilite")
	private Civilite civilite;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Admin() {
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getMailAdmin() {
		return this.mailAdmin;
	}

	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}

	public String getNomAdmin() {
		return this.nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getPrenomAdmin() {
		return this.prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}

	public String getTelAdmin() {
		return this.telAdmin;
	}

	public void setTelAdmin(String telAdmin) {
		this.telAdmin = telAdmin;
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

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}