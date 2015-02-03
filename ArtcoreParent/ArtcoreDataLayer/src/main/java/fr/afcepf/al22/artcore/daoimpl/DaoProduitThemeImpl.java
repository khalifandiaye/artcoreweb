package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoProduitTheme;
@Stateless
public class DaoProduitThemeImpl implements IDaoProduitTheme {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());

}
