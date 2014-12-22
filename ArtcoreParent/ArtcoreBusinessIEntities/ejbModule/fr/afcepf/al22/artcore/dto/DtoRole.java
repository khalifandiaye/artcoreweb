package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.afcepf.al22.artcore.entities.Role;
import fr.afcepf.al22.artcore.entities.Utilisateur;


/**
 * Classe de simples objets correspondant � l'entit� {@link Role}.
 * 
 */
public class DtoRole implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idRole;
	private String libelleRole;
	private int niveauRole;

	private List<Utilisateur> utilisateurs;
	//constructeurs
	public DtoRole() {
	}
	public DtoRole(int idRole, String libelleRole, int niveauRole) {
		super();
		this.idRole = idRole;
		this.libelleRole = libelleRole;
		this.niveauRole = niveauRole;
	}

	//getter setter
	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return this.libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	public int getNiveauRole() {
		return this.niveauRole;
	}

	public void setNiveauRole(int niveauRole) {
		this.niveauRole = niveauRole;
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	

}