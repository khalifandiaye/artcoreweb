package fr.afcepf.al22.artcore.entities;


/**
 * The primary key class for the produit_theme database table.
 * 
 */
/*
@Embeddable
public class ProduitThemePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_produit")
	private int idProduit;

	@Column(name="id_theme")
	private int idTheme;

	public ProduitThemePK() {
	}
	public int getIdProduit() {
		return this.idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getIdTheme() {
		return this.idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProduitThemePK)) {
			return false;
		}
		ProduitThemePK castOther = (ProduitThemePK)other;
		return 
			(this.idProduit == castOther.idProduit)
			&& (this.idTheme == castOther.idTheme);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idProduit;
		hash = hash * prime + this.idTheme;
		
		return hash;
	}
}*/