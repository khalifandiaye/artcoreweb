package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client_adresse database table.
 * 
 */
@Entity
@Table(name="client_adresse")
@NamedQuery(name="ClientAdresse.findAll", query="SELECT c FROM ClientAdresse c")
public class ClientAdresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientAdressePK id;

	//bi-directional many-to-one association to Adresse
	@ManyToOne
	@JoinColumn(name="id_adresse", insertable=false, updatable=false)
	private Adresse adresse;

	public ClientAdresse() {
	}

	public ClientAdressePK getId() {
		return this.id;
	}

	public void setId(ClientAdressePK id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}