package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evaluation_produit database table.
 * 
 */
@Entity
@Table(name="evaluation_produit")
@NamedQuery(name="EvaluationProduit.findAll", query="SELECT e FROM EvaluationProduit e")
public class EvaluationProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evaluation")
	private int idEvaluation;

	@Column(name="commentaire_produit")
	private String commentaireProduit;

	@Column(name="note_produit")
	private int noteProduit;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Produit produit;

	public EvaluationProduit() {
	}

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

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}