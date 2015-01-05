package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cartebleue database table.
 * 
 */
@Entity
@NamedQuery(name="Cartebleue.findAll", query="SELECT c FROM Cartebleue c")
public class Cartebleue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cryptogramme;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiration;

	private String numero;

	//bi-directional many-to-one association to Etatcarte
	@ManyToOne
	@JoinColumn(name="IDEtatCarte")
	private Etatcarte etatcarte;

	public Cartebleue() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCryptogramme() {
		return this.cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Etatcarte getEtatcarte() {
		return this.etatcarte;
	}

	public void setEtatcarte(Etatcarte etatcarte) {
		this.etatcarte = etatcarte;
	}

}