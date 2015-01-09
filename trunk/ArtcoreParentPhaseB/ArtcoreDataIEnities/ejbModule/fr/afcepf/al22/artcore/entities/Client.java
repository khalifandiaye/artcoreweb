package fr.afcepf.al22.artcore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private int idClient;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin_activite")
	private Date dateFinActivite;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_naissance")
	private Date dateNaissance;

	@Column(name="mail_client")
	private String mailClient;

	@Column(name="nom_client")
	private String nomClient;

	@Column(name="prenom_client")
	private String prenomClient;

	@Column(name="tel_client")
	private String telClient;

	//bi-directional many-to-many association to Adresse
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="client_adresse"
		, joinColumns={
			@JoinColumn(name="id_client")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_adresse")
			}
		)
	private List<Adresse> adresses;

	//bi-directional many-to-one association to Civilite
	@ManyToOne
	@JoinColumn(name="id_civilite")
	private Civilite civilite;

	//bi-directional many-to-one association to Professionnel
	@ManyToOne
	@JoinColumn(name="id_professionnel")
	private Professionnel professionnel;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="client")
	private List<Commande> commandes;

	//bi-directional many-to-one association to EvaluationProduit
	@OneToMany(mappedBy="client")
	private List<EvaluationProduit> evaluationProduits;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateFinActivite() {
		return this.dateFinActivite;
	}

	public void setDateFinActivite(Date dateFinActivite) {
		this.dateFinActivite = dateFinActivite;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getTelClient() {
		return this.telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}

	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Civilite getCivilite() {
		return this.civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Professionnel getProfessionnel() {
		return this.professionnel;
	}

	public void setProfessionnel(Professionnel professionnel) {
		this.professionnel = professionnel;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setClient(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setClient(null);

		return commande;
	}

	public List<EvaluationProduit> getEvaluationProduits() {
		return this.evaluationProduits;
	}

	public void setEvaluationProduits(List<EvaluationProduit> evaluationProduits) {
		this.evaluationProduits = evaluationProduits;
	}

	public EvaluationProduit addEvaluationProduit(EvaluationProduit evaluationProduit) {
		getEvaluationProduits().add(evaluationProduit);
		evaluationProduit.setClient(this);

		return evaluationProduit;
	}

	public EvaluationProduit removeEvaluationProduit(EvaluationProduit evaluationProduit) {
		getEvaluationProduits().remove(evaluationProduit);
		evaluationProduit.setClient(null);

		return evaluationProduit;
	}

}