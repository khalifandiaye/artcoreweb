package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoFormat;
import fr.afcepf.al22.artcore.entities.Format;
@Stateless
public class DaoFormatImpl implements IDaoFormat {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;

	@Override
	public List<Format> listeTousFormats() {
		Query query = em.createQuery("FROM Format f ");
		List<Format> listeFormat = new ArrayList<Format>();
		listeFormat = (List<Format>) query.getResultList();
		return listeFormat;
	}

	@Override
	public Format formatParId(int id) {
		Format f = null;
		Query query = em.createQuery("SELECT f FROM Format f "
				+ "WHERE f.idFormat = :pidf ");
		query.setParameter("pidf", id);
		if (query.getSingleResult() != null) {
			f = (Format) query.getSingleResult();
		}
		return f;
	}

}
