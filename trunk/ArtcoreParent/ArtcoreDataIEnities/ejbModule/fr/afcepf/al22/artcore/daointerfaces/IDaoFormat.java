package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Format;

@Remote
public interface IDaoFormat {
	
	/**
	 * Méthode qui retourne la liste de tous les formats de la base
	 * @return
	 */
	public List<Format> listeTousFormats () ;
	
	/**
	 * Méthode qui renvoie un {@link Format} en fonction de l'id passé en argument
	 * @param id
	 * @return
	 */
	public Format formatParId (int id);

}
