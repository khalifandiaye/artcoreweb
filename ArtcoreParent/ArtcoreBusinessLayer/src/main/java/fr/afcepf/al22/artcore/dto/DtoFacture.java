package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.EvaluationProduit;
import fr.afcepf.al22.artcore.entities.Facture;


/**
 * Classe de simples objets correspondant � l'entit� {@link Facture}.
 * 
 */
public class DtoFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idFacture;
	private DtoCommande commande;

	//constructeurs
	public DtoFacture() {
	}
	public DtoFacture(int idFacture, DtoCommande commande) {
		super();
		this.idFacture = idFacture;
		this.commande = commande;
	}

	//getter setter
	public int getIdFacture() {
		return this.idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public DtoCommande getCommande() {
		return commande;
	}
	public void setCommande(DtoCommande commande) {
		this.commande = commande;
	}
	

	
}