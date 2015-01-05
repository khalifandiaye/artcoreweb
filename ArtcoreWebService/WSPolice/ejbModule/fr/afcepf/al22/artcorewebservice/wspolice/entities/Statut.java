package fr.afcepf.al22.artcorewebservice.wspolice.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the statut database table.
 * 
 */
@Entity
@NamedQuery(name="Statut.findAll", query="SELECT s FROM Statut s")
public class Statut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String libelle;

	//bi-directional many-to-one association to Suspect
	@OneToMany(mappedBy="statut")
	private List<Suspect> suspects;

	public Statut() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Suspect> getSuspects() {
		return this.suspects;
	}

	public void setSuspects(List<Suspect> suspects) {
		this.suspects = suspects;
	}

	public Suspect addSuspect(Suspect suspect) {
		getSuspects().add(suspect);
		suspect.setStatut(this);

		return suspect;
	}

	public Suspect removeSuspect(Suspect suspect) {
		getSuspects().remove(suspect);
		suspect.setStatut(null);

		return suspect;
	}

}