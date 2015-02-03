package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Remote;

@Remote
public interface IBusinessProduitTheme {
	

	/**
	 * Méthode qui prend un produit theme en argument et 
	 * qui renvoie une liste de thème
	 * @param pt
	 * @return
	 */
	// à refaire car la classe ProduitThemePK n existe plus
	//public List<DtoTheme> rechercherThemesParProduitTheme (ProduitThemePK pt);
	

}
