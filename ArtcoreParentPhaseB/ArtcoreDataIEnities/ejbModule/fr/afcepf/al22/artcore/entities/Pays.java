package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pays database table.
 * 
 */
@Entity
@Table(name="pays")
@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pays p")
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pays")
	private int idPays;

	@Column(name="libelle_pays")
	private String libellePays;

	//bi-directional many-to-one association to Adresse
	@OneToMany(mappedBy="pays")
	private List<Adresse> adresses;

	public Pays() {
	}

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
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Adresse addAdresse(Adresse adresse) {
		getAdresses().add(adresse);
		adresse.setPays(this);

		return adresse;
	}

	public Adresse removeAdress(Adresse adress) {
		getAdresses().remove(adress);
		adress.setPays(null);

		return adress;
	}

}