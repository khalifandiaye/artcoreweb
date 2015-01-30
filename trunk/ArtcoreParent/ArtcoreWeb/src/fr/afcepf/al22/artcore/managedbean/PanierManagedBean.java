package fr.afcepf.al22.artcore.managedbean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	
	/**
	 * AJOUTS POUR LE BIG DATA
	 */
	@ManagedProperty(value="#{mbConnexion}")
	private ConnexionManagedBean mbConnexion;
	
	
	/**
	 * Ajout méthodes pour le bid data
	 */
	
	/**
	 * Méthode qui est appelée par 
	 * {@link public void recupeCategosEtProduitsCibles ()}.
	 * Méthode qui récupère la catégorie du produit dès que le client 
	 * regarde le détail de ce produit ou met le produit dans son panier.
	 * @return le set des libelles de la categorie consultée.
	 * ATTENTION A N'UTILISER CETTE METHODE QUE SI LE CLIENT EST CONNECTE.
	 * TODO appeler ces deux méthodes à chaque appel du detail de produit
	 * TODO ou d'ajout du panier.
	 */
	public Set<String> recupCategoriesCibles (Set<String> listeCategories, DtoProduit p) {
		listeCategories.add(p.getCategorie().getLibelleCategorie());
		return listeCategories;
	}
	/**
	 * Méthode qui est appelée par 
	 * {@link public void recupeCategosEtProduitsCibles ()}.
	 * Méthode qui récupère l'artiste du produit dès que le client 
	 * regarde le détail de ce produit ou met le produit dans son panier.
	 * @return le set du nom d'artiste consulté.
	 * ATTENTION A N'UTILISER CETTE METHODE QUE SI LE CLIENT EST CONNECTE.
	 */
	public Set<String> recupArtistesCibles (Set<String> listeProduits, DtoProduit p) {
		listeProduits.add(p.getNomArtiste());
		return listeProduits;
	}
	
	/**
	 * Méthode finale qui renplit les set du client connecté en appelant les deux méthodes
	 * {@link public Set<String> recupCategoriesCibles (Set<String> listeCategories, DtoProduit p)}
	 * et 
	 * {@link public Set<String> recupArtistesCibles (Set<String> listeProduits, DtoProduit p) }
	 */
	public void recupeCategosEtProduitsCibles () {
		if (mbConnexion.getDtoClient() != null) {
			//ajout de la categorie du produit dans la set.
			Set<String> setCatego = mbConnexion.getDtoClient().getSetCategoriesPreferees();
			setCatego = recupCategoriesCibles(setCatego, produitEnCours);
			mbConnexion.getDtoClient().setSetCategoriesPreferees(setCatego);
			log.debug("mbCatalogue : Fin de l'ajout de la catégorie.");
			//ajout du nom d'artiste dans la set.
			Set<String> setArtiste = mbConnexion.getDtoClient().getSetArtistesPreferes();
			setArtiste = recupArtistesCibles(setArtiste, produitEnCours);
			mbConnexion.getDtoClient().setSetArtistesPreferes(setArtiste);
			log.debug("mbCatalogue : Fin de l'ajout de l'artiste.");
		}
	}
	


	public String recupPanier() {
		this.panier = gestionPanier.getListBlocProduit();
		return "";
	}

	
	public String supprimerProduit(DtoProduit produit) {
		/**
		 * L'inconvénient de quantite--, c'est si on supprime un produit qui est présent 
		 * en plusieurs quantités dans le panier ;
		 * auquel cas ça ne supprime qu'une seule quantité.
		 */
//		quantite--;
		/**
		 * J'essaye de trouver le BlocProiduitDto qui correspond au proiduit.
		 * Si j'arrive à le trouver, alors je bouclerai sur la quantité du bloc.
		 * Et dans la boucle je décrémenterai.
		 */
		//je vais chercher l'index du produit à supprimer
		//pour pouvoir appeler le get(index)
		
		//je crée une variable quantite que je remplirai
		//(oui, même ça c'est pas évident, hein Ivan ;-) )
		int quantiteProduit = 0;
		//je parcours la liste :
		for (BlocProduitDto bloc : panier) {
			log.debug("On est rentré dans mon for.");
			//si c'est le produit à supprimer
			if (bloc.getProduit() == produit) {
				log.debug("Le produit a été trouvé.");
				//alors on met la quantité du bloc dans la variable quantite.
				quantiteProduit = bloc.getQuantite();
				log.debug("Le produit a supprimer était en " + quantiteProduit + " exemplaires.");
			}
		}
		//Maintenant je peux boucler
		for (int i = 0; i < quantiteProduit; i++) {
			quantite--;
		}
		this.panier=gestionPanier.retirerProduit(produit);

		
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
		/**
		 * Ajout de la catégorie et de l'artiste si l'utilisateur est connecté.
		 */
		recupeCategosEtProduitsCibles();
		if (mbConnexion.getDtoClient() != null) {
			for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
				log.debug("mbPanier : Set catego du client après ajout : " + string);
			}
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				log.debug("mbPanier : Set artiste du client après ajout : " + string);
			}
		}
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
	
	
	//getter setter
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
	public ConnexionManagedBean getMbConnexion() {
		return mbConnexion;
	}
	public void setMbConnexion(ConnexionManagedBean mbConnexion) {
		this.mbConnexion = mbConnexion;
	}
	
	
}
