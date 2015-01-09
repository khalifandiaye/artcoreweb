package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Tva;

@Remote
public interface IDaoTva {
	
	/**
	 * Méthode qui renvoie une {@link Tva} en fonction de l'id en argument.
	 * @param id
	 * @return
	 */
	public Tva tvaParId (int id);

}
