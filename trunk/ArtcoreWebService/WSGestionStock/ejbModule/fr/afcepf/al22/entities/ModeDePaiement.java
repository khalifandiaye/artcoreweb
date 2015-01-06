package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mode_de_paiement database table.
 * 
 */
@Entity
@Table(name="mode_de_paiement")
@NamedQuery(name="ModeDePaiement.findAll", query="SELECT m FROM ModeDePaiement m")
public class ModeDePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mode_paiement")
	private int idModePaiement;

	@Column(name="libelle_mode_paiement")
	private String libelleModePaiement;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="modeDePaiement")
	private List<Commande> commandes;

	public ModeDePaiement() {
	}

	public int getIdModePaiement() {
		return this.idModePaiement;
	}

	public void setIdModePaiement(int idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getLibelleModePaiement() {
		return this.libelleModePaiement;
	}

	public void setLibelleModePaiement(String libelleModePaiement) {
		this.libelleModePaiement = libelleModePaiement;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setModeDePaiement(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setModeDePaiement(null);

		return commande;
	}

}