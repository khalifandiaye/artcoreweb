package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoCategorie;
import fr.afcepf.al22.artcore.entities.Categorie;
@Stateless
public class DaoCategorieImpl implements IDaoCategorie {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
//	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public List<Categorie> listeToutesCategories() {
//		log.debug("DaoCategorieImpl : listeToutesCategories");
		Query query = em.createQuery("FROM Categorie c ");
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		listeCategorie = (List<Categorie>) query.getResultList();
//		log.debug("La liste contient du coup " + listeCategorie.size() + " items.");
		return listeCategorie;
	}

	@Override
	public Categorie categorieParId(int id) {
		System.out.println("************************");
//		log.info("***********************************************");
		Categorie cat = null;
		Query query = em.createQuery("SELECT c FROM Categorie c "
				+ "WHERE c.idCategorie = :pidc ");
		query.setParameter("pidc", id);
		System.out.println(id + " " );
		if (query.getSingleResult() != null) {
			cat = (Categorie) query.getSingleResult();
			System.out.println(cat.getIdCategorie()+" ****************" );
		}
		return cat;
	}

}
