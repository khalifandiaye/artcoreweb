package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import fr.afcepf.al22.artcore.entities.Utilisateur;


/**
 * Classe de simples objets correspondant à l'entité {@link Utilisateur}.
 * 
 */
public class DtoUtilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idUtilisateur;
	private String login;
	private String motDePasse;
	private List<DtoAdmin> admins;
	private List<DtoClient> clients;
	private DtoRole role;

	//constructeur
	public DtoUtilisateur() {
	}
	public DtoUtilisateur(int idUtilisateur, DtoRole role, String login,
			String motDePasse) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.role = role;
		this.login = login;
		this.motDePasse = motDePasse;
	}

	//getter setter
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
	public List<DtoAdmin> getAdmins() {
		return admins;
	}
	public void setAdmins(List<DtoAdmin> admins) {
		this.admins = admins;
	}
	public List<DtoClient> getClients() {
		return clients;
	}
	public void setClients(List<DtoClient> clients) {
		this.clients = clients;
	}
	public DtoRole getRole() {
		return role;
	}
	public void setRole(DtoRole role) {
		this.role = role;
	}

	
}