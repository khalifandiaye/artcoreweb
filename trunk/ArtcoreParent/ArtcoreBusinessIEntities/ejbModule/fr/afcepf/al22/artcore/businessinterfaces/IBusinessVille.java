/**
 * 
 */
package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Ing
 *
 */
@Remote
public interface IBusinessVille {
	
	/**
	 * Méthode qui recherche une ville en fonction de son id.
	 * @param id
	 * @return
	 */
	public DtoVille villeParId(int id);

}
