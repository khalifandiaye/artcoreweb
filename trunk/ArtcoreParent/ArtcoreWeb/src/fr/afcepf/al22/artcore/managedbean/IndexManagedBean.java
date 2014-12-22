package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;

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

	// Je crée une liste pour l'accueil n'ayant pas plus de 4 éléments
	private List<DtoProduit> listeProduitsRaccourcie = new ArrayList<DtoProduit>();
	
	//méthodes 
	/**
	 * Méthode qui récupère un produit sélectionné.
	 * Sert à l'affichage du détail d'un produit.
	 * A VOIR CE QU'ON CODE DEDANS.
	 * @return
	 */


	public String detailProduit(DtoProduit p) {
		produit = p;
		//TODO à coder ; ajouter le lien vers détailProduit
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
		mbAjoutPanier.ajoutProduit(produit);
		return"";
		
	}
	
	
	//getter setter
	public List<DtoProduit> getListeProduits() {
		//je remplis la liste au chargement de la page
		//avec la méthode qui renvoie tous les produits
		listeProduits = buRechercheProduit.listeTousProduits();
		System.out.println("taille de la liste : ");
		System.out.println(listeProduits.size());
		
		int tailleListe = 4;
		if (listeProduits.size() > tailleListe && listeProduitsRaccourcie.size() < tailleListe) {
			for (int i = 0; i < tailleListe; i++) {
				listeProduitsRaccourcie.add(listeProduits.get(i));
			}
		}
		System.out.println("taille de la liste raccourcie : " + listeProduitsRaccourcie.size());
		
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
	

	
	
	
	
	
}
