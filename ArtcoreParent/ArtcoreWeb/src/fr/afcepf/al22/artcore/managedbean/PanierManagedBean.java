package fr.afcepf.al22.artcore.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPanier;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name = "mbPanier")
@SessionScoped
public class PanierManagedBean {
	
	private Logger log = Logger.getLogger(this.getClass());
	
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
		this.panier = gestionPanier.getListBlocProduit();
		return "";
	}

	
	public String supprimerProduit(DtoProduit produit) {
		this.panier=gestionPanier.retirerProduit(produit);
		quantite--;
		loggerPanier();
		return "";
	}
	public String ajoutProduit(DtoProduit produit){
		this.produitEnCours=produit;
		gestionPanier.ajouterProduit(produitEnCours);
		this.panier=gestionPanier.getListBlocProduit();
		loggerPanier();
		quantite++;
		log.debug("IL Y A " + quantite + " ARTICLES DANS LE PANIER.");
		return "/catalogue.jsf?faces-redirect=true";
	}
	public String prixTotalString(){
		prixTotal=gestionPanier.prixTotal();
		return "";
	}
	
	public String confirmer() {
		// Supprime toutes les informations de la session
		return "/confirmerCommande.jsf?faces-redirect=true";
	}
	
	/**
	 * Réinitialsation du panier
	 * (on fait une nouvelle arraylist)
	 */
	public void reinitPanier () {
		log.debug("segtfnhkjldfghgfdsdfghjgfdsqfghdsqdfghj");

		/**
		 * En fait le panier dans le business n'est pas vide ;
		 * donc c'est celui-là que je vais chercher à vider.
		 */
		for (BlocProduitDto bloc : panier) {
			gestionPanier.retirerProduit(bloc.getProduit());
		}
		
		/**
		 * Ya besoin d'initialiser celui ci pour que le produit ne s'affiche plus.
		 * Et d'initialiser celui du business (plus haut) pour initialiser le prix...
		 * Et oui !!! :-D
		 */
		panier = new ArrayList<BlocProduitDto>();
//		for (BlocProduitDto bloc : panier) {
//			log.debug("On supprime l'objet " + bloc + " du panier.");
//			panier.remove(bloc);
//		}
		log.debug("Le panier est maintenant censé être vide. Il contient " + panier.size() + " éléments."); 
		log.debug("ET MAINTENANT LE PANIER CONTIENT " + panier.size() + " ELEMENTS !!!!!!!!!!!!!!!!!!!!!!");
		quantite = 0;
//		int prix = 0;
		
		log.debug("LE PRIX TOTAL EST DE " + prixTotal + " EUROS");
//		prixTotal = null;
//		prixTotal=BigDecimal.valueOf(prix);
//		getPrixTotal();
//		prixTotal=gestionPanier.prixTotal();
//		prixTotal=new BigDecimal(0);
		
		/**
		 * J'essaye (même si ma liste est censée être vide,
		 * de supprimer chaque produit du panier.
		 * Parce que quand on supprime le produit,
		 * ça met le prix total à jour
		 * (par magie peut-être, en tout cas je ne sais pas comment).
		 */
		for (BlocProduitDto bloc : panier) {
			gestionPanier.retirerProduit(bloc.getProduit());
		}
		/**
		 * Il ne rentre pas dans mon get...
		 */
		log.debug("ET MAINTENANT IL EST CENSE ETRE NULL : " + prixTotal);
		log.debug("Taille du panier : " + panier.size());
	}
	// a effacer
	public void loggerPanier(){
		log.debug("etat du panier");
		log.debug("*********************************************************");
		if(panier!=null && !panier.isEmpty()){
		for (BlocProduitDto blocProduitDto : panier) {
			log.debug(blocProduitDto.getProduit().getIdProduit()+"\t"+ blocProduitDto.getProduit().getLibelleProduit() + "\t"
					+ " " + blocProduitDto.getQuantite() +"\t "
					+ " "+blocProduitDto.getPrixTotalParPdt() 
					);
		}
			log.debug("Prix total=" +gestionPanier.prixTotal());
		}
		
	}
}
