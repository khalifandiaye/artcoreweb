package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import fr.afcepf.al22.artcore.entities.Produit;


/**
 * Classe de simples objets correspondant � l'entit� {@link Produit}.
 * 
 */
public class DtoProduit implements Serializable {
	private static final long serialVersionUID = 1L;

	//attrubuts
	private int idProduit;
	private Date dateDebutDeVente;
	private Date dateFinDeVente;
	private String descriptionProduit;
	private String imageProduit;
	private String libelleProduit;
	private String nomArtiste;
	private BigDecimal prixProduit;
	private int stock;
	private List<DtoEvaluationProduit> evaluationProduits;

	private List<DtoFournisseur> fournisseurs;

	private List<DtoLigneDeCommande> ligneDeCommandes;
	private DtoCategorie categorie;

	private DtoFormat format;
	private List<DtoTheme> themes;

	//bi-directional many-to-one association to Tva
	private DtoTva tva;

	//constructeurs
	public DtoProduit() {
	}
	public DtoProduit(int idProduit, Date dateDebutDeVente,
			Date dateFinDeVente, String descriptionProduit, DtoCategorie categorie,
			DtoFormat format, DtoTva tva, String imageProduit,
			String libelleProduit, String nomArtiste, BigDecimal prixProduit,
			int stock) {
		super();
		this.idProduit = idProduit;
		this.dateDebutDeVente = dateDebutDeVente;
		this.dateFinDeVente = dateFinDeVente;
		this.descriptionProduit = descriptionProduit;
		this.categorie = categorie;
		this.format = format;
		this.tva = tva;
		this.imageProduit = imageProduit;
		this.libelleProduit = libelleProduit;
		this.nomArtiste = nomArtiste;
		this.prixProduit = prixProduit;
		this.stock = stock;
	}
	//getter setter
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
	public List<DtoTheme> getThemes() {
		return themes;
	}
	public void setThemes(List<DtoTheme> themes) {
		this.themes = themes;
	}
	public List<DtoEvaluationProduit> getEvaluationProduits() {
		return evaluationProduits;
	}
	public void setEvaluationProduits(List<DtoEvaluationProduit> evaluationProduits) {
		this.evaluationProduits = evaluationProduits;
	}
	public List<DtoFournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<DtoFournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public List<DtoLigneDeCommande> getLigneDeCommandes() {
		return ligneDeCommandes;
	}
	public void setLigneDeCommandes(List<DtoLigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}
	public DtoCategorie getCategorie() {
		return categorie;
	}
	public void setCategorie(DtoCategorie categorie) {
		this.categorie = categorie;
	}
	public DtoFormat getFormat() {
		return format;
	}
	public void setFormat(DtoFormat format) {
		this.format = format;
	}
	public DtoTva getTva() {
		return tva;
	}
	public void setTva(DtoTva tva) {
		this.tva = tva;
	}
	
	
	

}