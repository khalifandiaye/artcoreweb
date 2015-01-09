package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import javax.persistence.*;

import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.Facture;
import fr.afcepf.al22.artcore.entities.LigneDeCommande;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Classe de simples objets correspondant � l'entit� {@link Commande}.
 * 
 */
public class DtoCommande implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributes
	private int idCommande;
	private String adresseClient;

	private Date dateCommande;
	private Date dateLivraison;

	private Date dateReception;
	private BigDecimal fraisEnvoi;
	private String nomClient;

	private BigDecimal prixTotal;

	private int villeClient;
	private DtoClient client;

	private DtoModeDePaiement modeDePaiement;

	private List<DtoFacture> factures;

	private List<DtoLigneDeCommande> ligneDeCommandes;

	//constructeurs
	public DtoCommande() {
	}
	public DtoCommande(Integer idCommande, String adresseClient, Date dateCommande,
			Date dateLivraison, Date dateReception, BigDecimal fraisEnvoi,
			DtoClient client, DtoModeDePaiement modeDePaiement, String nomClient,
			BigDecimal prixTotal, int villeClient) {
		super();
		this.idCommande = idCommande;
		this.adresseClient = adresseClient;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
		this.dateReception = dateReception;
		this.fraisEnvoi = fraisEnvoi;
		this.client = client;
		this.modeDePaiement = modeDePaiement;
		this.nomClient = nomClient;
		this.prixTotal = prixTotal;
		this.villeClient = villeClient;
	}

	//getter setter
	public Integer getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(Integer idCommande) {
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
	public DtoClient getClient() {
		return client;
	}
	public void setClient(DtoClient client) {
		this.client = client;
	}
	public DtoModeDePaiement getModeDePaiement() {
		return modeDePaiement;
	}
	public void setModeDePaiement(DtoModeDePaiement modeDePaiement) {
		this.modeDePaiement = modeDePaiement;
	}
	public List<DtoFacture> getFactures() {
		return factures;
	}
	public void setFactures(List<DtoFacture> factures) {
		this.factures = factures;
	}
	public List<DtoLigneDeCommande> getLigneDeCommandes() {
		return ligneDeCommandes;
	}
	public void setLigneDeCommandes(List<DtoLigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	@Override
	public String toString() {
		return "DtoCommande [idCommande=" + idCommande + ", adresseClient="
				+ adresseClient + ", dateCommande=" + dateCommande
				+ ", dateLivraison=" + dateLivraison + ", dateReception="
				+ dateReception + ", fraisEnvoi=" + fraisEnvoi + ", nomClient="
				+ nomClient + ", prixTotal=" + prixTotal + ", villeClient="
				+ villeClient + ", client=" + client + ", modeDePaiement="
				+ modeDePaiement + ", factures=" + factures
				+ ", ligneDeCommandes=" + ligneDeCommandes + "]";
	}
	
	
	

}