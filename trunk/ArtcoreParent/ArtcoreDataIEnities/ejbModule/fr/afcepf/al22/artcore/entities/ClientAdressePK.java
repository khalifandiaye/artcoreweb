package fr.afcepf.al22.artcore.entities;
/*
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the client_adresse database table.
 * 
 */
/*
@Embeddable
public class ClientAdressePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_client")
	private int idClient;

	@Column(name="id_adresse")
	private int idAdresse;

	public ClientAdressePK() {
	}
	public int getIdClient() {
		return this.idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public int getIdAdresse() {
		return this.idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClientAdressePK)) {
			return false;
		}
		ClientAdressePK castOther = (ClientAdressePK)other;
		return 
			(this.idClient == castOther.idClient)
			&& (this.idAdresse == castOther.idAdresse);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idClient;
		hash = hash * prime + this.idAdresse;
		
		return hash;
	}
}*/