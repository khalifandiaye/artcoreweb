package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Utilisateur;


/**
 * Classe de simples objets correspondant à l'entité {@link Utilisateur}.
 * 
 */
public class DtoVille implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idVille;
	private String codePostal;

	private String commune;

	private String departement;

	private String insee;

	private List<Adresse> adresses;


	//constructeurs
	public DtoVille() {
	}

	public int getIdVille() {
		return this.idVille;
	}
	public DtoVille(int idVille, String codePostal, String commune,
			String departement, String insee) {
		super();
		this.idVille = idVille;
		this.codePostal = codePostal;
		this.commune = commune;
		this.departement = departement;
		this.insee = insee;
	}

	//getter setter
	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return this.commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getInsee() {
		return this.insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	

}