package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the commande_ligne_commande database table.
 * 
 */
/*@Embeddable
public class CommandeLigneCommandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_ligne_commande")
	private int idLigneCommande;

	@Column(name="id_commande")
	private int idCommande;

	public CommandeLigneCommandePK() {
	}
	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}
	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public int getIdCommande() {
		return this.idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CommandeLigneCommandePK)) {
			return false;
		}
		CommandeLigneCommandePK castOther = (CommandeLigneCommandePK)other;
		return 
			(this.idLigneCommande == castOther.idLigneCommande)
			&& (this.idCommande == castOther.idCommande);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLigneCommande;
		hash = hash * prime + this.idCommande;
		
		return hash;
	}
}*/