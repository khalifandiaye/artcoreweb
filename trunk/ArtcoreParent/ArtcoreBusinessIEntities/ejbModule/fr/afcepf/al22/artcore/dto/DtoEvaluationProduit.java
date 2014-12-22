package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import fr.afcepf.al22.artcore.entities.EvaluationProduit;


/**
 * Classe de simples objets correspondant � l'entit� {@link EvaluationProduit}.
 * 
 */
public class DtoEvaluationProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributs
	private int idEvaluation;
	private String commentaireProduit;
	private int noteProduit;
	private DtoClient client;
	private DtoProduit produit;

	//constructeurs
	public DtoEvaluationProduit() {
	}
	public DtoEvaluationProduit(int idEvaluation, String commentaireProduit,
			DtoClient client, DtoProduit produit, int noteProduit) {
		super();
		this.idEvaluation = idEvaluation;
		this.commentaireProduit = commentaireProduit;
		this.client = client;
		this.produit = produit;
		this.noteProduit = noteProduit;
	}

	//getter setter
	public int getIdEvaluation() {
		return this.idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getCommentaireProduit() {
		return this.commentaireProduit;
	}

	public void setCommentaireProduit(String commentaireProduit) {
		this.commentaireProduit = commentaireProduit;
	}

	public int getNoteProduit() {
		return this.noteProduit;
	}

	public void setNoteProduit(int noteProduit) {
		this.noteProduit = noteProduit;
	}
	public DtoClient getClient() {
		return client;
	}
	public void setClient(DtoClient client) {
		this.client = client;
	}
	public DtoProduit getProduit() {
		return produit;
	}
	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
	

}