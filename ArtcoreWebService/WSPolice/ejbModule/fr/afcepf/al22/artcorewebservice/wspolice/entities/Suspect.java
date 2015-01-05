package fr.afcepf.al22.artcorewebservice.wspolice.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the suspect database table.
 * 
 */
@Entity
@NamedQuery(name="Suspect.findAll", query="SELECT s FROM Suspect s")
public class Suspect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_naissance")
	private Date dateNaissance;

	private String nom;

	private String prenom;

	//bi-directional many-to-one association to Statut
	@ManyToOne
	@JoinColumn(name="id_statut")
	private Statut statut;

	public Suspect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

}