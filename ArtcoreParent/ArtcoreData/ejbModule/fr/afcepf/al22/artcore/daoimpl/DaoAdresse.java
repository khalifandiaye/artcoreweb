package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.entities.Adresse;

/**
 * @author Stagiaire
 *
 */
@Stateless
public class DaoAdresse implements IDaoAdresse {

	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	@Override
	public Adresse rechercherAdresse(int id) {
		Adresse adresse=null;
		Query query = em.createQuery("select a from Adresse a where "
				+ " a.idAdresse = :paramId");
		query.setParameter("paramId", id);
		adresse=(Adresse) query.getSingleResult();
		return adresse;
	}

}
