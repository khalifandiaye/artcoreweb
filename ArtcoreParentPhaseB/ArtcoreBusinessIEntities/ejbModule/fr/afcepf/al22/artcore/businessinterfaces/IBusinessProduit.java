package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Produit;
@Remote
public interface IBusinessProduit {
	
	/**
	 * M�thode qui prend en param�tre un dtoproduit , le rentre dans la table, et renvoie le proguit cr��.
	 * @param produit
	 * @return
	 */
	public Produit creer (DtoProduit produit);
	
	/**
	 * M�thode qui prend en param�tre le produit � modifier, le modifie, et renvoie le produit modifi�.
	 * @param produit
	 * @return
	 */
	public DtoProduit modifier (DtoProduit produit) ;
	
	/**
	 * M�thode qui prend un produit en argument, le supprime, 
	 * (c'est � dire rajoute une date de fin de vente), et renvoie un entier.
	 * @param produit
	 * @return 1 si �a a fonctionn�, 0 sinon.
	 */
	public int supprimer (DtoProduit produit) ;

}
