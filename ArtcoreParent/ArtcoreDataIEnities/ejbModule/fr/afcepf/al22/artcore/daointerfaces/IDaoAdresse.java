package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Adresse;
@Remote
public interface IDaoAdresse {

	/**
	 * rechercher une adresse avec son id
	 * @param id
	 * @return
	 */
	public Adresse rechercherAdresse(int id);
}
