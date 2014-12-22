package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoTheme;
import fr.afcepf.al22.artcore.entities.Theme;
@Stateless
public class DaoThemeImpl implements IDaoTheme {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public Theme themeParId(int id) {
		log.info("DaoProduitImpl : themeParId");
		Query query = em.createQuery("FROM Theme t "
				+ "WHERE t.idTheme = :pidt ");
		query.setParameter("pidt", id);
		Theme t = null;
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
		if (query.getSingleResult() != null) {
			t = (Theme) query.getSingleResult();
		}
		return t;
	}

	@Override
	public List<Theme> listeTousThemes() {
		Query query = em.createQuery("FROM Theme t ");
		List<Theme> listeTheme = new ArrayList<>();
		listeTheme = query.getResultList();
		return listeTheme;
	}

}
