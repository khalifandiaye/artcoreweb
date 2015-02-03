package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ville database table.
 * 
 */
@Entity
@Table(name = "ville")
@NamedQuery(name="Ville.findAll", query="SELECT v FROM Ville v")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ville")
	private int idVille;

	@Column(name="code_postal")
	private String codePostal;

	private String commune;

	private String departement;

	private String insee;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="ville")
	private List<Adresse> adresses;

	public Ville() {
	}

	public int getIdVille() {
		return this.idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommune() {
		return this.commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDepartement() {
		return this.departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getInsee() {
		return this.insee;
	}

	public void setInsee(String insee) {
		this.insee = insee;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdress(Adresse adress) {
		getAdresses().add(adress);
		adress.setVille(this);

		return adress;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setVille(null);

		return adress;
	}

}