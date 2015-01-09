package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.afcepf.al22.artcore.entities.Commande;



/**
 * Classe de simples objets correspondant � l'entit� {@link DtoModeDePaiement}.
 * 
 */
public class DtoModeDePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idModePaiement;
	private String libelleModePaiement;
	private List<Commande> commandes;

	//constructeurs
	public DtoModeDePaiement() {
	}
	public DtoModeDePaiement(int idModePaiement, String libelleModePaiement) {
		super();
		this.idModePaiement = idModePaiement;
		this.libelleModePaiement = libelleModePaiement;
	}

	//getter setter
	public int getIdModePaiement() {
		return this.idModePaiement;
	}

	public void setIdModePaiement(int idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getLibelleModePaiement() {
		return this.libelleModePaiement;
	}

	public void setLibelleModePaiement(String libelleModePaiement) {
		this.libelleModePaiement = libelleModePaiement;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	@Override
	public String toString() {
		return "DtoModeDePaiement [idModePaiement=" + idModePaiement
				+ ", libelleModePaiement=" + libelleModePaiement
				+ ", commandes=" + commandes + "]";
	}
	
	

}