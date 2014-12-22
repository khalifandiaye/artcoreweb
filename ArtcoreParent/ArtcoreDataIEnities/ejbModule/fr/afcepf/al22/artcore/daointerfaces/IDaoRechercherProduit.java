package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Format;
import fr.afcepf.al22.artcore.entities.Produit;
@Remote
public interface IDaoRechercherProduit {
	
	/**
	 * M�thode qui prend une string en param�tre et qui renvoie la liste
	 * des produits dont le nom comprend la string.
	 * @param nom
	 * @return
	 */
	public List<Produit> rechercherProduitsParNom (String nom);
	
	/**
	 * M�thode qui prend en param�tre un id et qui renvoie le produit correspondant � cet id.
	 * @param id
	 * @return
	 */
	public Produit produitParId (int id) ;
	
	/**
	 * M�thode qui renvoie une liste de tous les produits de la table.
	 * @return
	 */
	public List<Produit> listeTousProduits () ;
	
	/**
	 * Méthode qui recherche les porduits en fonction d'une catégorie.
	 * @param idCategorie
	 * @return
	 */
	public List<Produit> produitsParCategorie (int idCategorie) ;
	
	/**
	 * Méthode qui recherche les {@link Produit} en fonction d'un {@link Format}.
	 * @param idFormat
	 * @return
	 */
	public List<Produit> produitsParFormat (int idFormat) ;
	
	/**
	 * Méthode qui renvoie une liste de {@link Produit} en fonction du nom de l'artiste.
	 * @param nomArtiste
	 * @return
	 */
	public List<Produit> produitsParArtiste (String nomArtiste) ;
	
	/**
	 * Méthode qui renvoie une liste de {@link Produit} en fonction de plusieurs critères.
	 * @param libelle
	 * @param nomArtiste
	 * @param idCategorie
	 * @param idFormat
	 * @return
	 */
	public List<Produit> produitsMultiCriteres (String libelle, String nomArtiste, int idCategorie, int idFormat) ; 

}
