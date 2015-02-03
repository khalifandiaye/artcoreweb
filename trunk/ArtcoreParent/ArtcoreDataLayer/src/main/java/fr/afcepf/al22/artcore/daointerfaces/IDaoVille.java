/**
 * 
 */
package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Ing
 *
 */
@Remote
public interface IDaoVille {
	
	/**
	 * Méthode qui recherche une ville en fonction de son id.
	 * @param id
	 * @return
	 */
	public Ville villeParId(int id);

}
