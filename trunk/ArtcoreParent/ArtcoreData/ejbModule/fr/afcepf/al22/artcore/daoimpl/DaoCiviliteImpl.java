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

}
