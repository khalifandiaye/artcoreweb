package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessRechercherProduit;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name="mbIndex")
@SessionScoped
public class IndexManagedBean {
	private Logger log = Logger.getLogger(this.getClass());
	//attributs entrants
	private List<DtoProduit> listeProduits = new ArrayList<DtoProduit>();
	//attributs sortants
	private DtoProduit produit;
	//Ejb
	@EJB
	public IBusinessRechercherProduit buRechercheProduit;
	
	/**
	 * AJOUTS ING 24/11 pour la méthode ajouter au panier
	 */
	@ManagedProperty(value="#{mbPanier}")
	public PanierManagedBean mbAjoutPanier;
	
	/**
	 * AJOUTS POUR LE BIG DATA
	 */
	@ManagedProperty(value="#{mbConnexion}")
	private ConnexionManagedBean mbConnexion;

	// Je crée une liste pour l'accueil n'ayant pas plus de 4 éléments
	private List<DtoProduit> listeProduitsRaccourcie = new ArrayList<DtoProduit>();
	
	//méthodes 
	
	
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
			setCatego = recupCategoriesCibles(setCatego, produit);
			mbConnexion.getDtoClient().setSetCategoriesPreferees(setCatego);
			log.debug("mbCatalogue : Fin de l'ajout de la catégorie.");
			//ajout du nom d'artiste dans la set.
			Set<String> setArtiste = mbConnexion.getDtoClient().getSetArtistesPreferes();
			setArtiste = recupArtistesCibles(setArtiste, produit);
			mbConnexion.getDtoClient().setSetArtistesPreferes(setArtiste);
			log.debug("mbCatalogue : Fin de l'ajout de l'artiste.");
		}
	}
	
	
	
	
	/**
	 * Méthode qui récupère un produit sélectionné.
	 * Sert à l'affichage du détail d'un produit.
	 * A VOIR CE QU'ON CODE DEDANS.
	 * @return
	 */


	public String detailProduit(DtoProduit p) {
		produit = p;
		/**
		 * Ajout de la catégorie et de l'artiste si l'utilisateur est connecté.
		 */
		recupeCategosEtProduitsCibles();
		if (mbConnexion.getDtoClient() != null) {
			for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
				log.debug("mbIndex : Set catego du client après détail : " + string);
			}
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				log.debug("mbIndex : Set artiste du client après détail : " + string);
			}
		}
		return "detailProduit.xhtml";
	}
	/**
	 * Méthode pour ajouter un produit au panier.
	 * @param p
	 */
	public String ajouterAuPanier(DtoProduit p) {
		produit = p;
		//J'appelle la méthode d'Ivan qui ajoute au panier
		//(la sienne fonctionne depuis le détail du produit,
		//ici je la fais fonctionner du catalogue)
		/**
		 * Ajout de la catégorie et de l'artiste si l'utilisateur est connecté.
		 */
		recupeCategosEtProduitsCibles();
		if (mbConnexion.getDtoClient() != null) {
			for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
				log.debug("mbIndex : Set catego du client après ajout au panier : " + string);
			}
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				log.debug("mbIndex : Set artiste du client après ajut au panier : " + string);
			}
		}
		mbAjoutPanier.ajoutProduit(produit);
		return"";
		
	}
	
	
	//getter setter
	public List<DtoProduit> getListeProduits() {
		//je remplis la liste au chargement de la page
		//avec la méthode qui renvoie tous les produits
		listeProduits = buRechercheProduit.listeTousProduits();

		int tailleListe = 4;
		if (listeProduits.size() > tailleListe && listeProduitsRaccourcie.size() < tailleListe) {
			for (int i = 0; i < tailleListe; i++) {
				listeProduitsRaccourcie.add(listeProduits.get(i));
			}
		}
		
		return listeProduitsRaccourcie;
	}
	public void setListeProduits(List<DtoProduit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	public DtoProduit getProduit() {
		return produit;
	}
	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
	public List<DtoProduit> getListeProduitsRaccourcie() {
		return listeProduitsRaccourcie;
	}
	public void setListeProduitsRaccourcie(List<DtoProduit> listeProduitsRaccourcie) {
		this.listeProduitsRaccourcie = listeProduitsRaccourcie;
	}
	public PanierManagedBean getMbAjoutPanier() {
		return mbAjoutPanier;
	}
	public void setMbAjoutPanier(PanierManagedBean mbAjoutPanier) {
		this.mbAjoutPanier = mbAjoutPanier;
	}
	public ConnexionManagedBean getMbConnexion() {
		return mbConnexion;
	}
	public void setMbConnexion(ConnexionManagedBean mbConnexion) {
		this.mbConnexion = mbConnexion;
	}
	

	
	
	
	
	
}
