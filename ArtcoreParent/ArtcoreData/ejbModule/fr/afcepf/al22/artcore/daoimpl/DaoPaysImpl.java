package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoPays;
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
	/**
	 * Méthode rajoutée le 08/01 pour rechercher un pays en fonction de son id.
	 * J'en ai besoin pour rajouter un pays dans l'adresse,
	 * pour pouvoir inscrire un nouveau client.
	 */
	@Override
	public Pays paysParId(int id) {
		Query query = em.createQuery("FROM Pays p "
				+ "WHERE p.idPays = :pid");
		query.setParameter("pid", id);
		Pays p = null;
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
		if (query.getSingleResult() != null) {
			p = (Pays) query.getSingleResult();
		}
		return p;
	}

}
