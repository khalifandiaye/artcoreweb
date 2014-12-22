package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoProduitTheme;
import fr.afcepf.al22.artcore.entities.Theme;
@Stateless
public class DaoProduitThemeImpl implements IDaoProduitTheme {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * Methode qui prend un {@link Produit} en argument et qui renvoie la liste de {@link ProduitThemePK} correspondants.
	 */
/*	@Override
	public List<ProduitThemePK> rechercherProduitThemeParProduit(Produit produit) {
		log.info("DaoProduitThemeImpl : rechercherProduitThemeParProduit");
		Query query = em.createQuery("FROM ProduitThemePK pt "
				+ "WHERE pt.idProduit = :pidp ");
		query.setParameter("pidp", produit.getIdProduit());
		List<ProduitThemePK> listeProduitThemes = new ArrayList<ProduitThemePK>();
		listeProduitThemes = (List<ProduitThemePK>) query.getResultList();
		return listeProduitThemes;
	}


	/*
	@Override
	public List<ProduitThemePK> rechercherProduitThemeParTheme(Theme theme) {
		Query query = em.createQuery("FROM ProduitThemePK pt "
				+ "WHERE pt.idTheme = :pidt ");
		query.setParameter("pidt", theme.getIdTheme());
		List<ProduitThemePK> listeProduitThemes = new ArrayList<ProduitThemePK>();
		listeProduitThemes = (List<ProduitThemePK>) query.getResultList();
		return listeProduitThemes;
	}
*/
}
