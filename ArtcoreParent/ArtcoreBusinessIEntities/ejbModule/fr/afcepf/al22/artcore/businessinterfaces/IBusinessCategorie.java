package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoCategorie;

@Remote
public interface IBusinessCategorie {
	
	/**
	 * Méthode du business qui récupère une liste de {@link DtoCategorie} 
	 * qui correspond à toutes les catégories en base.
	 * @return
	 */
	public List<DtoCategorie> listeToutescategories () ;
	
	/**
	 * Méthode qui renvoie une {@link DtoCategorie} en fonction de l'id en paramètre.
	 * @param id
	 * @return
	 */
	public DtoCategorie categorieParId (int id);

}
