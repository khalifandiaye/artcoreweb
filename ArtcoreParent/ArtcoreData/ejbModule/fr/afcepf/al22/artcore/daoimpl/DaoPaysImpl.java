package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoPays;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Pays;
@Stateless
public class DaoPaysImpl implements IDaoPays {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	@Override
	public List<Pays> listeTousPays() {
		Query query = em.createQuery("FROM Pays p ");
		List<Pays> listePays = new ArrayList<Pays>();
		listePays = (List<Pays>) query.getResultList();
		return listePays;
	}
	
	@Override
	public Pays paysParId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
