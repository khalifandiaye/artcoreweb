package fr.afcepf.al22.antivol.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the etatcarte database table.
 * 
 */
@Entity
@NamedQuery(name="Etatcarte.findAll", query="SELECT e FROM Etatcarte e")
public class Etatcarte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String libelleEtatCarte;

	//bi-directional many-to-one association to Cartebleue
	@OneToMany(mappedBy="etatcarte")
	private List<Cartebleue> cartebleues;

	public Etatcarte() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleEtatCarte() {
		return this.libelleEtatCarte;
	}

	public void setLibelleEtatCarte(String libelleEtatCarte) {
		this.libelleEtatCarte = libelleEtatCarte;
	}

	public List<Cartebleue> getCartebleues() {
		return this.cartebleues;
	}

	public void setCartebleues(List<Cartebleue> cartebleues) {
		this.cartebleues = cartebleues;
	}

	public Cartebleue addCartebleue(Cartebleue cartebleue) {
		getCartebleues().add(cartebleue);
		cartebleue.setEtatcarte(this);

		return cartebleue;
	}

	public Cartebleue removeCartebleue(Cartebleue cartebleue) {
		getCartebleues().remove(cartebleue);
		cartebleue.setEtatcarte(null);

		return cartebleue;
	}

}