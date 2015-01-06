package fr.afcepf.al22.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produit")
	private int idProduit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_debut_de_vente")
	private Date dateDebutDeVente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin_de_vente")
	private Date dateFinDeVente;

	@Column(name="description_produit")
	private String descriptionProduit;

	@Column(name="image_produit")
	private String imageProduit;

	@Column(name="libelle_produit")
	private String libelleProduit;

	@Column(name="nom_artiste")
	private String nomArtiste;

	@Column(name="prix_produit")
	private BigDecimal prixProduit;

	private int stock;

	//bi-directional many-to-one association to EvaluationProduit
	@OneToMany(mappedBy="produit")
	private List<EvaluationProduit> evaluationProduits;

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="produit")
	private List<Fournisseur> fournisseurs;

	//bi-directional many-to-one association to LigneDeCommande
	@OneToMany(mappedBy="produit")
	private List<LigneDeCommande> ligneDeCommandes;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="id_categorie")
	private Categorie categorie;

	//bi-directional many-to-one association to Format
	@ManyToOne
	@JoinColumn(name="id_format")
	private Format format;

	//bi-directional many-to-one association to Tva
	@ManyToOne
	@JoinColumn(name="id_tva")
	private Tva tva;

	//bi-directional many-to-one association to ProduitTheme
	/*@OneToMany(mappedBy="produit")
	private List<ProduitTheme> produitThemes;*/

	//bi-directional many-to-many association to Theme
	@ManyToMany
	@JoinTable(
		name="produit_theme"
		, joinColumns={
			@JoinColumn(name="id_produit")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_theme")
			}
		)
	private List<Theme> themes;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public Date getDateDebutDeVente() {
		return this.dateDebutDeVente;
	}

	public void setDateDebutDeVente(Date dateDebutDeVente) {
		this.dateDebutDeVente = dateDebutDeVente;
	}

	public Date getDateFinDeVente() {
		return this.dateFinDeVente;
	}

	public void setDateFinDeVente(Date dateFinDeVente) {
		this.dateFinDeVente = dateFinDeVente;
	}

	public String getDescriptionProduit() {
		return this.descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public String getImageProduit() {
		return this.imageProduit;
	}

	public void setImageProduit(String imageProduit) {
		this.imageProduit = imageProduit;
	}

	public String getLibelleProduit() {
		return this.libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public String getNomArtiste() {
		return this.nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public BigDecimal getPrixProduit() {
		return this.prixProduit;
	}

	public void setPrixProduit(BigDecimal prixProduit) {
		this.prixProduit = prixProduit;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<EvaluationProduit> getEvaluationProduits() {
		return this.evaluationProduits;
	}

	public void setEvaluationProduits(List<EvaluationProduit> evaluationProduits) {
		this.evaluationProduits = evaluationProduits;
	}

	public EvaluationProduit addEvaluationProduit(EvaluationProduit evaluationProduit) {
		getEvaluationProduits().add(evaluationProduit);
		evaluationProduit.setProduit(this);

		return evaluationProduit;
	}

	public EvaluationProduit removeEvaluationProduit(EvaluationProduit evaluationProduit) {
		getEvaluationProduits().remove(evaluationProduit);
		evaluationProduit.setProduit(null);

		return evaluationProduit;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		getFournisseurs().add(fournisseur);
		fournisseur.setProduit(this);

		return fournisseur;
	}

	public Fournisseur removeFournisseur(Fournisseur fournisseur) {
		getFournisseurs().remove(fournisseur);
		fournisseur.setProduit(null);

		return fournisseur;
	}

	public List<LigneDeCommande> getLigneDeCommandes() {
		return this.ligneDeCommandes;
	}

	public void setLigneDeCommandes(List<LigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}

	public LigneDeCommande addLigneDeCommande(LigneDeCommande ligneDeCommande) {
		getLigneDeCommandes().add(ligneDeCommande);
		ligneDeCommande.setProduit(this);

		return ligneDeCommande;
	}

	public LigneDeCommande removeLigneDeCommande(LigneDeCommande ligneDeCommande) {
		getLigneDeCommandes().remove(ligneDeCommande);
		ligneDeCommande.setProduit(null);

		return ligneDeCommande;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Format getFormat() {
		return this.format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Tva getTva() {
		return this.tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	/*public List<ProduitTheme> getProduitThemes() {
		return this.produitThemes;
	}

	public void setProduitThemes(List<ProduitTheme> produitThemes) {
		this.produitThemes = produitThemes;
	}

	public ProduitTheme addProduitTheme(ProduitTheme produitTheme) {
		getProduitThemes().add(produitTheme);
		produitTheme.setProduit(this);

		return produitTheme;
	}

	public ProduitTheme removeProduitTheme(ProduitTheme produitTheme) {
		getProduitThemes().remove(produitTheme);
		produitTheme.setProduit(null);

		return produitTheme;
	}
*/
	public List<Theme> getThemes() {
		return this.themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

}