package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professionnel database table.
 * 
 */
@Entity
@NamedQuery(name="Professionnel.findAll", query="SELECT p FROM Professionnel p")
public class Professionnel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_professionnel")
	private int idProfessionnel;

	@Column(name="num_siret")
	private String numSiret;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="professionnel")
	private List<Client> clients;

	public Professionnel() {
	}

	public int getIdProfessionnel() {
		return this.idProfessionnel;
	}

	public void setIdProfessionnel(int idProfessionnel) {
		this.idProfessionnel = idProfessionnel;
	}

	public String getNumSiret() {
		return this.numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setProfessionnel(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setProfessionnel(null);

		return client;
	}

}