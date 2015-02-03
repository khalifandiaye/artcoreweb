package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the adresse database table.
 * 
 */
@Entity
@Table(name = "adresse")
@NamedQuery(name="Adresse.findAll", query="SELECT a FROM Adresse a")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int idAdresse;

	@Column(name="libelle_adresse")
	private String libelleAdresse;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;

	//bi-directional many-to-one association to Admin
	@OneToMany(mappedBy="adresse") 
	private List<Admin> admins;

	//bi-directional many-to-one association to Pay
	@ManyToOne
	@JoinColumn(name="id_pays")
	private Pays pays;

	//bi-directional many-to-one association to Ville
	@ManyToOne
	@JoinColumn(name="id_ville")
	private Ville ville;

	//bi-directional many-to-many association to Client
	@ManyToMany(mappedBy="adresses")
	private List<Client> clients = new ArrayList<>();

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="adresse")
	private List<Fournisseur> fournisseurs;

	public Adresse() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getLibelleAdresse() {
		return this.libelleAdresse;
	}

	public void setLibelleAdresse(String libelleAdresse) {
		this.libelleAdresse = libelleAdresse;
	}

	public List<Admin> getAdmins() {
		return this.admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Admin addAdmin(Admin admin) {
		getAdmins().add(admin);
		admin.setAdresse(this);

		return admin;
	}

	public Admin removeAdmin(Admin admin) {
		getAdmins().remove(admin);
		admin.setAdresse(null);

		return admin;
	}

	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Ville getVille() {
		return this.ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		getFournisseurs().add(fournisseur);
		fournisseur.setAdresse(this);

		return fournisseur;
	}

	public Fournisseur removeFournisseur(Fournisseur fournisseur) {
		getFournisseurs().remove(fournisseur);
		fournisseur.setAdresse(null);

		return fournisseur;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}