package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private int idUtilisateur;

	private String login;

	@Column(name="mot_de_passe")
	private String motDePasse;

	//bi-directional many-to-one association to Client
	@OneToMany(mappedBy="utilisateur")
	private List<Client> clients;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Client> getClients() {
		return this.clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client addClient(Client client) {
		getClients().add(client);
		client.setUtilisateur(this);

		return client;
	}

	public Client removeClient(Client client) {
		getClients().remove(client);
		client.setUtilisateur(null);

		return client;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}