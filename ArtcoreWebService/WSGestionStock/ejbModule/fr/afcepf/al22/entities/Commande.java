package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int idCommande;

	@Column(name="adresse_client")
	private String adresseClient;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_commande")
	private Date dateCommande;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_livraison")
	private Date dateLivraison;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_reception")
	private Date dateReception;

	@Column(name="frais_envoi")
	private BigDecimal fraisEnvoi;

	@Column(name="nom_client")
	private String nomClient;

	@Column(name="prix_total")
	private BigDecimal prixTotal;

	@Column(name="ville_client")
	private int villeClient;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to ModeDePaiement
	@ManyToOne
	@JoinColumn(name="id_mode_paiement")
	private ModeDePaiement modeDePaiement;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="commande")
	private List<Facture> factures;

	//bi-directional many-to-one association to LigneDeCommande
	@OneToMany(mappedBy="commande")
	private List<LigneDeCommande> ligneDeCommandes;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getAdresseClient() {
		return this.adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Date getDateReception() {
		return this.dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

	public BigDecimal getFraisEnvoi() {
		return this.fraisEnvoi;
	}

	public void setFraisEnvoi(BigDecimal fraisEnvoi) {
		this.fraisEnvoi = fraisEnvoi;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public BigDecimal getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getVilleClient() {
		return this.villeClient;
	}

	public void setVilleClient(int villeClient) {
		this.villeClient = villeClient;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ModeDePaiement getModeDePaiement() {
		return this.modeDePaiement;
	}

	public void setModeDePaiement(ModeDePaiement modeDePaiement) {
		this.modeDePaiement = modeDePaiement;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setCommande(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setCommande(null);

		return facture;
	}

	public List<LigneDeCommande> getLigneDeCommandes() {
		return this.ligneDeCommandes;
	}

	public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}

	public LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) {
		getLigneDeCommandes().add(ligneDeCommande);
		ligneDeCommande.setCommande(this);

		return ligneDeCommande;
	}

	public LigneDeCommande removeLigneDeCommande(LigneDeCommande ligneDeCommande) {
		getLigneDeCommandes().remove(ligneDeCommande);
		ligneDeCommande.setCommande(null);

		return ligneDeCommande;
	}

}