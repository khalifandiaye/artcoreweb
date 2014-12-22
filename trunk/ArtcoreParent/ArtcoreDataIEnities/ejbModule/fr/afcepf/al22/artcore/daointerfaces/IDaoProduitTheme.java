package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

@Remote
public interface IDaoProduitTheme {
	
	/**
	 * Méthode qui prend un {@link Produit} en argument 
	 * et qui va chercher tous les {@link ProduitTheme} qui correspondent
	 * à ce produit.
	 * @param produit
	 * @return
	 */
	//public List<ProduitThemePK> rechercherProduitThemeParProduit (Produit produit);
	
	/**
	 * Méthode qui va chercher tous les {@link ProduitTheme} de la table.
	 * @return
	 */
//	public List<ProduitThemePK> listeTousProduitTheme ();

}
