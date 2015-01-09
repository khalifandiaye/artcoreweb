package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoTva;
import fr.afcepf.al22.artcore.entities.Tva;
@Stateless
public class DaoTvaImpl implements IDaoTva {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;

	@Override
	public Tva tvaParId(int id) {
		Tva tva = null;
		Query query = em.createQuery("SELECT tva FROM Tva tva "
				+ "WHERE tva.idTva = :pidt ");
		query.setParameter("pidt", id);
		if (query.getSingleResult() != null) {
			tva = (Tva) query.getSingleResult();
		}
		return tva;
	}

}
