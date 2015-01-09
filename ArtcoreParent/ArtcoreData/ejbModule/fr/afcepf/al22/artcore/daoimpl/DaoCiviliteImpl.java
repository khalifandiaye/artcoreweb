package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoCivilite;
import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Ville;
@Stateless

public class DaoCiviliteImpl implements IDaoCivilite {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	@Override
	public List<Civilite> listeToutesCivilites() {
		Query query = em.createQuery("FROM Civilite c ");
		List<Civilite> listeCivilite = new ArrayList<Civilite>();
		listeCivilite = (List<Civilite>) query.getResultList();
		return listeCivilite;
		
	}
	@Override
	public Civilite civiliteParId(int id) {
		Query query = em.createQuery("FROM Civilite c "
				+ "WHERE c.idCivilite = :pid");
		query.setParameter("pid", id);
		Civilite c = null;
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
		if (query.getSingleResult() != null) {
			c = (Civilite) query.getSingleResult();
		}
		return c;
	}

}
