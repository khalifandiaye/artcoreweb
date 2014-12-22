package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.afcepf.al22.artcore.entities.Adresse;



/**
 * Classe de simples objets correspondant � l'entit� {@link Format}.
 * 
 */
public class DtoPays implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs

	private int idPays;
	private String libellePays;
	private List<Adresse> adresses;

	//constructeurs
	public DtoPays() {
	}
	public DtoPays(int idPays, String libellePays) {
		super();
		this.idPays = idPays;
		this.libellePays = libellePays;
	}

	//getter setter
	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getLibellePays() {
		return this.libellePays;
	}

	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	

}