package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import fr.afcepf.al22.artcore.entities.Civilite;


/**
 * Classe de simples objets correspondant � l'entit� {@link Civilite}.
 * 
 */
public class DtoCivilite implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributes
	private int idCivilite;
	private String libelleCivilite;
	private List<DtoAdmin> admins;
	private List<DtoClient> clients;
	private List<DtoFournisseur> fournisseurs;


	//constructeurs
	public DtoCivilite() {
	}
	public DtoCivilite(int idCivilite, String libelleCivilite) {
		super();
		this.idCivilite = idCivilite;
		this.libelleCivilite = libelleCivilite;
	}


	//getter setter
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
	public List<DtoFournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<DtoFournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	

}