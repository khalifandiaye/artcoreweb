package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the civilite database table.
 * 
 */
@Entity
@NamedQuery(name="Civilite.findAll", query="SELECT c FROM Civilite c")
public class Civilite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_civilite")
	private int idCivilite;

	@Column(name="libelle_civilite")
	private String libelleCivilite;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="civilite")
	private List<Client> clients;

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="civilite")
	private List<Fournisseur> fournisseurs;

	public Civilite() {
	}

	public int getIdCivilite() {
		return this.idCivilite;
	}

	public void setIdCivilite(int idCivilite) {
		this.idCivilite = idCivilite;
	}

	public String getLibelleCivilite() {
		return this.libelleCivilite;
	}

	public void setLibelleCivilite(String libelleCivilite) {
		this.libelleCivilite = libelleCivilite;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setCivilite(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setCivilite(null);

		return client;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		getFournisseurs().add(fournisseur);
		fournisseur.setCivilite(this);

		return fournisseur;
	}

	public Fournisseur removeFournisseur(Fournisseur fournisseur) {
		getFournisseurs().remove(fournisseur);
		fournisseur.setCivilite(null);

		return fournisseur;
	}

}