/**
 * 
 */
package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoVille;
import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Ing
 *
 */
@Stateless
public class DaoVilleImpl implements IDaoVille {
	
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.daointerfaces.IDaoVille#villeParId(int)
	 */
	@Override
	public Ville villeParId(int id) {
		Query query = em.createQuery("FROM Ville v "
				+ "WHERE v.idVille = :pid");
		query.setParameter("pid", id);
		Ville v = null;
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
		if (query.getSingleResult() != null) {
			v = (Ville) query.getSingleResult();
		}
		return v;
	}

}
