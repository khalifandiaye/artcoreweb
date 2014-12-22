package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Categorie;

@Remote
public interface IDaoCategorie {
	
	/**
	 * Méthode qui va chercher toutes les {@link Categorie} de la base.
	 * @return
	 */
	public List<Categorie> listeToutesCategories ();
	
	/**
	 * Méthode qui retourne une {@link Categorie} en fonction de l'id passé en argument.
	 * @param id
	 * @return
	 */
	public Categorie categorieParId (int id);

}
