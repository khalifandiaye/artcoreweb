package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;











import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCategorie;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessFormat;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessRechercherProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessTva;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoFormat;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;

/**
 * @author Ing
 *
 */ 
@ManagedBean(name="mbCatalogue")
@SessionScoped
public class CatalogueManagedBean {
	private Logger log = Logger.getLogger(this.getClass());
	
	//attributs entrants
	private List<DtoProduit> listeProduits = new ArrayList<DtoProduit>();
	private List<DtoCategorie> listeCategories = new ArrayList<DtoCategorie>();
	private List<DtoFormat> listeFormats = new ArrayList<DtoFormat>();
	/**
	 * Int qui fait office de booléen ; il va permettre de choisir quelle liste mettre dans le getter.
	 * S'il est égal à 0, on affiche la liste complète des produits à la vente ;
	 * S'il est égal à 1, on affiche la liste par nom;
	 * S'il est égal à 2, on affiche la liste par catégorie;
	 * S'il est égal à 3, on affiche la liste par format;
	 * S'il est égal à 4, on affiche la liste par prix;
	 * S'il est égal à 5, on affiche la liste part thème;
	 * S'il est égal à 6, on affiche la liste par nom d'artiste
	 * S'il est égal à 7, on affiche la liste multicritères (codée dans le mb);
	 * S'il est égal à 8, on affiche vraiment tous les produits
	 */
	private int recherche = 0;
	//attributs sortants
	private DtoProduit produit;
	private String labelRechercheNom;
	private int intRechercheCategorie;
	private int intRechercheFormat;
	private Boolean prixMin = true;
	private Boolean prixInter = true;
	private Boolean prixMax = true;
	private String labelRechercheNomArtiste;
	/**
	 * AJOUTS ING pour la modification d'un produit
	 */
	private int intModifCategorie;
	private int intModifFormat;
	
	//Ejb
	@EJB
	public IBusinessRechercherProduit buRechercheProduit;
	@EJB
	public IBusinessCategorie buCategorie;
	@EJB
	public IBusinessFormat buFormat;
	@EJB
	public IBusinessProduit buProduit;
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
			for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
				System.out.println("mbCatalogue : la set comprend : " + string);
			}
			//ajout du nom d'artiste dans la set.
			Set<String> setArtiste = mbConnexion.getDtoClient().getSetArtistesPreferes();
			setArtiste = recupArtistesCibles(setArtiste, produit);
			mbConnexion.getDtoClient().setSetArtistesPreferes(setArtiste);
			log.debug("mbCatalogue : Fin de l'ajout de l'artiste.");
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				System.out.println("mbCatalogue : la set comprend : " + string);
			}
		}
	}
	
	 
	
	
	
	
	
	
	
	
	/**
	 * Méthode qui permet d'aller vers la page de modification du produit.
	 * @param p
	 * @return
	 */
	public String modifierProduit (DtoProduit p) {
		produit = p;
		return "modifProduitAdmin.xhtml";
	}
	/**
	 * Méthode qui modifie réellement le produit.
	 * Redirige vers le catalogue.
	 * @return
	 */
	public String modifProduit() {
		//TODO à coder l'ajout de produit
		//Choix de catégorie et de format selon les existants
		produit.setCategorie(buCategorie.categorieParId(intModifCategorie));
		produit.setFormat(buFormat.formatParId(intModifFormat));
		buProduit.modifier(produit);
		//Puis on redirige vers le catalogue.
		return "catalogueAdmin.xhtml";
	}
	/**
	 * Méthode pour retirer le produit de la vente.
	 * Redirige vers le calalogue à la fin du traitement.
	 * @param p
	 * @return
	 */
	public String supprimerProduit (DtoProduit p) {
		int i = buProduit.supprimer(p);
		return "catalogueAdmin.xhtml";
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
				System.out.println("mbCatalogue : Set catego du client après détail : " + string);
			}
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				System.out.println("mbCatalogue : Set artiste du client après détail : " + string);
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
		//TODO à coder ; ajouter le produit au panier
		//J'appelle la méthode d'Ivan qui ajoute au panier
		//(la sienne fonctionne depuis le détail du produit,
		//ici je la fais fonctionner du catalogue)
		
		/**
		 * Ajout de la catégorie et de l'artiste si l'utilisateur est connecté.
		 */
		recupeCategosEtProduitsCibles();
		if (mbConnexion.getDtoClient() != null) {
			for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
				System.out.println("mbCatalogue : Set catego du client après détail : " + string);
			}
			for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
				System.out.println("mbCatalogue : Set artiste du client après détail : " + string);
			}
		}
		
		mbAjoutPanier.ajoutProduit(produit);
		return"";
		
	}
	public void rechercheParNom() {
		recherche = 1;
	}
	public void rechercheParCategorie () {
		recherche = 2;
	}
	public void rechercheParFormat() {
		recherche = 3;
	}
	public void rechercheParPrix() {
		recherche = 4;
	}
	public void rechercheParTheme () {
		recherche = 5;
	}
	public void rechercheParNomArtiste () {
		recherche = 6;
	}
	public void rechercheMulticritere () {
		recherche = 7;
	}
	public void reinitialisation () {
		recherche = 0;
	}
	public void tousProduits () {
		recherche = 8;
	}
	/**
	 * GETTER SETTER
	 */
	//getter setter
	public List<DtoProduit> getListeProduits() {
		log.debug("DANS LE GETTER : RECHERCHE = " + recherche);
		//Au chargement de la page, recherche = 0 :
		
		switch (recherche) {
		case 0:
			//je remplis la liste au chargement de la page
			//avec la méthode qui renvoie tous les produits
			listeProduits = buRechercheProduit.listeTousProduitsEnVente();
			log.debug("taille de la liste : ");
			log.debug(listeProduits.size());
			return listeProduits;
		case 1:
			listeProduits = buRechercheProduit.rechercherProduitsParNom(labelRechercheNom);
			return listeProduits;
		case 2:
			if (intRechercheCategorie == 0 ) {
				//je retourne la liste complète
				listeProduits = buRechercheProduit.listeTousProduitsEnVente();
			} else {
				//je retourne la liste en fonction de la catégorie recherchée.
				listeProduits = buRechercheProduit.produitsParCategorie(intRechercheCategorie);
			}
			return listeProduits;
		case 3:
			if (intRechercheFormat == 0) {
				//je retourne la liste complète
				listeProduits = buRechercheProduit.listeTousProduitsEnVente();
			} else {
				//je retourne la liste en fonction du format recherché
				listeProduits = buRechercheProduit.produitsParFormat(intRechercheFormat);
			}
			return listeProduits;
		case 4:
			listeProduits = buRechercheProduit.produitsParPrix(prixMin, prixInter, prixMax);
			return listeProduits;
		case 5:
		case 6:
			listeProduits = buRechercheProduit.produitsParArtiste(labelRechercheNomArtiste);
			return listeProduits;
		case 7:
			listeProduits = buRechercheProduit.produitsMultiCriteres(labelRechercheNom, labelRechercheNomArtiste, intRechercheCategorie, intRechercheFormat, prixMin, prixInter, prixMax);
			return listeProduits;
		case 8:
			listeProduits = buRechercheProduit.listeTousProduits();
			return listeProduits;
		default:
			return listeProduits;
		}
		

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
	public String getLabelRechercheNom() {
		return labelRechercheNom;
	}
	public void setLabelRechercheNom(String labelRechercheNom) {
		this.labelRechercheNom = labelRechercheNom;
	}
	public int getRecherche() {
		return recherche;
	}
	public void setRecherche(int recherche) {
		this.recherche = recherche;
	}
	public int getIntRechercheCategorie() {
		return intRechercheCategorie;
	}
	public void setIntRechercheCategorie(int intRechercheCategorie) {
		this.intRechercheCategorie = intRechercheCategorie;
	}
	public List<DtoCategorie> getListeCategories() {
		listeCategories = new ArrayList<DtoCategorie>();
		listeCategories = buCategorie.listeToutescategories();
		log.debug("la liste de categorie contient " + listeCategories.size() + " items.");
		return listeCategories;
	}
	public void setListeCategories(List<DtoCategorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	public List<DtoFormat> getListeFormats() {
		listeFormats = new ArrayList<DtoFormat>();
		listeFormats = buFormat.listeTousFormats();
		return listeFormats;
	}
	public void setListeFormats(List<DtoFormat> listeFormats) {
		this.listeFormats = listeFormats;
	}
	public int getIntRechercheFormat() {
		return intRechercheFormat;
	}
	public void setIntRechercheFormat(int intRechercheFormat) {
		this.intRechercheFormat = intRechercheFormat;
	}
	public Boolean getPrixMin() {
		return prixMin;
	}
	public void setPrixMin(Boolean prixMin) {
		this.prixMin = prixMin;
	}
	public Boolean getPrixInter() {
		return prixInter;
	}
	public void setPrixInter(Boolean prixInter) {
		this.prixInter = prixInter;
	}
	public Boolean getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(Boolean prixMax) {
		this.prixMax = prixMax;
	}
	public String getLabelRechercheNomArtiste() {
		return labelRechercheNomArtiste;
	}
	public void setLabelRechercheNomArtiste(String labelRechercheNomArtiste) {
		this.labelRechercheNomArtiste = labelRechercheNomArtiste;
	}
	public int getIntModifCategorie() {
		intModifCategorie = produit.getCategorie().getIdCategorie();
		return intModifCategorie;
	}
	public void setIntModifCategorie(int intModifCategorie) {
		this.intModifCategorie = intModifCategorie;
	}
	public int getIntModifFormat() {
		intModifFormat = produit.getFormat().getIdFormat();
		return intModifFormat;
	}
	public void setIntModifFormat(int intModifFormat) {
		this.intModifFormat = intModifFormat;
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
