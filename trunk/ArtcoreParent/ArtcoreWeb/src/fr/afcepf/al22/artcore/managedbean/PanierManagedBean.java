package fr.afcepf.al22.artcore.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPanier;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name = "mbPanier")
@SessionScoped
public class PanierManagedBean {
	private List<BlocProduitDto> panier;
	
	//nombre total des articles
	private int quantite;
	//prix total du panier
	private BigDecimal prixTotal;
	
	private DtoProduit produitEnCours;
	
	@EJB
	private IBusinessPanier gestionPanier;
	
	public BigDecimal getPrixTotal() {
		this.prixTotal=gestionPanier.prixTotal();
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public List<BlocProduitDto> getPanier() {
		return panier;
	}

	public DtoProduit getProduitEnCours() {
		return produitEnCours;
	}

	public void setProduitEnCours(DtoProduit produitEnCours) {
		this.produitEnCours = produitEnCours;
	}

	public void setPanier(List<BlocProduitDto> panier) {
		this.panier = panier;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public IBusinessPanier getGestionPanier() {
		return gestionPanier;
	}

	public void setGestionPanier(IBusinessPanier gestionPanier) {
		this.gestionPanier = gestionPanier;
	}

	public String recupPanier() {
		System.out.println("dans mbPanier recupPanier");
		this.panier = gestionPanier.getListBlocProduit();
		return "";
	}

	public String supprimerProduit(DtoProduit produit) {
		System.out.println("Dans supprimerProduit ,Produit à supprimer: "+produit.getLibelleProduit());
		this.panier=gestionPanier.retirerProduit(produit);
		loggerPanier();
		return "";
	}
	public String ajoutProduit(DtoProduit produit){
		this.produitEnCours=produit;
		System.out.println("dans mbPanier AjouterProduit");
		System.out.println(this.produitEnCours.getLibelleProduit());
		gestionPanier.ajouterProduit(produitEnCours);
		this.panier=gestionPanier.getListBlocProduit();
		loggerPanier();
		return "/catalogue.jsf?faces-redirect=true";
	}
	public String prixTotalString(){
		System.out.println("dans mbPanier prixTotalString");
		prixTotal=gestionPanier.prixTotal();
		return "";
	}
	
	public String confirmer() {
		// Supprime toutes les informations de la session
		return "/confirmerCommande.jsf?faces-redirect=true";
	}
	// a effacer
	public void loggerPanier(){
		System.out.println("etat du panier");
		System.out.println("*********************************************************");
		if(panier!=null && !panier.isEmpty()){
		for (BlocProduitDto blocProduitDto : panier) {
			System.out.println(blocProduitDto.getProduit().getIdProduit()+"\t"+ blocProduitDto.getProduit().getLibelleProduit() + "\t"
					+ " " + blocProduitDto.getQuantite() +"\t "
					+ " "+blocProduitDto.getPrixTotalParPdt() 
					);
		}
			System.out.println("Prix total=" +gestionPanier.prixTotal());
		}
		
	}
}
