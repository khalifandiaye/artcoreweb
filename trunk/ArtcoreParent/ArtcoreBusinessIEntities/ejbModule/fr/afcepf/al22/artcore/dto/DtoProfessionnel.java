package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.Client;


/**
 * Classe de simples objets correspondant � l'entit� {@link Professionnel}.
 * 
 */
public class DtoProfessionnel implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idProfessionnel;
	private String numSiret;
	private List<Client> clients;

	//constructeurs
	public DtoProfessionnel() {
	}
	public DtoProfessionnel(int idProfessionnel, String numSiret) {
		super();
		this.idProfessionnel = idProfessionnel;
		this.numSiret = numSiret;
	}

	//getter setter
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
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	

}