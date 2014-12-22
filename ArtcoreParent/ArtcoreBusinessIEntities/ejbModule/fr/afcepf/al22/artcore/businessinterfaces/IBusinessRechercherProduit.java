package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Format;
import fr.afcepf.al22.artcore.entities.Produit;
@Remote
public interface IBusinessRechercherProduit {
	
	/**
	 * M�thode qui prend une string en param�tre et qui renvoie la liste
	 * des produits dont le nom comprend la string.
	 * @param nom
	 * @return
	 */
	public List<DtoProduit> rechercherProduitsParNom (String nom);
	
	/**
	 * M�thode qui prend en param�tre un id et qui renvoie le produit correspondant � cet id.
	 * @param id
	 * @return
	 */
	public DtoProduit produitParId (int id) ;
	
	/**
	 * M�thode qui renvoie une liste de tous les produits de la table.
	 * @return
	 */
	public List<DtoProduit> listeTousProduits () ;
	
	/**
	 * Méthode qui renvoie une liste de tous les {@link Produit} de la table
	 * et dont la date de fin de vente n'est pas renseignée.
	 * @return
	 */
	public List<DtoProduit> listeTousProduitsEnVente () ;
	
	/**
	 * Méthode qui prend en argument un id de categorie et qui renvoie une liste de {@link DtoProduit} correspondants.
	 * @param idCategorie
	 * @return
	 */
	public List<DtoProduit> produitsParCategorie (int idCategorie);
	
	/**
	 * Méthode qui prend en argument un id de {@link Format} et qui renvoie une liste de {@link Produit} correspondants.
	 * @param idFormat
	 * @return
	 */
	public List<DtoProduit> produitsParFormat (int idFormat) ;
	
	/**
	 * Méthode qui renvoie la liste des produits par prix en fonction de 3 booléens.
	 * Si le booléen est true, alors ça renvoie les produits dans cette catégorie de prix.
	 * @param prixMin 
	 * @param prixInter
	 * @param prixMax
	 * @return
	 */
	public List<DtoProduit> produitsParPrix (Boolean prixMin, Boolean prixInter, Boolean prixMax);

	/**
	 * Méthode qui renvoie une liste de {@link DtoProduit} en fonction d'une string de nom d'artiste.
	 * @param nomArtiste
	 * @return
	 */
	public List<DtoProduit> produitsParArtiste (String nomArtiste);
	
	/**
	 * Méthode qui renvoie une liste de {@link DtoProduit} en fonction de plusieurs critères.
	 * @param libelle
	 * @param nomArtiste
	 * @param idCategorie
	 * @param idFormat
	 * @param prixMin
	 * @param prixInter
	 * @param prixMax
	 * @return
	 */
	public List<DtoProduit> produitsMultiCriteres (String libelle, String nomArtiste, int idCategorie, int idFormat, Boolean prixMin, Boolean prixInter, Boolean prixMax) ;
}
