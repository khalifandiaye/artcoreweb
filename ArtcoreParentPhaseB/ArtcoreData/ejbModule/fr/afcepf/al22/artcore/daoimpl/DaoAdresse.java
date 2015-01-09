package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Stagiaire
 * 
 */
@Stateless
public class DaoAdresse implements IDaoAdresse {

    private Logger log = Logger.getLogger(getClass());
    @PersistenceContext(unitName = "DataArtcore")
    EntityManager em;

    /**
     * @see fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse#rechercherAdresse(int)
     */
    @Override
    public Adresse rechercherAdresse(int id) {
	Adresse adresse = null;
	Query query = em.createQuery("select a from Adresse a where "
		+ " a.idAdresse = :paramId");
	query.setParameter("paramId", id);
	adresse = null;
	try {
	    adresse = (Adresse) query.getSingleResult();
	} catch (NoResultException nore) {
	    log.error("Aucun resultat retournee par la requete d'adresse "
		    + nore.getMessage());
	}
	return adresse;
    }

    /**
     * @see fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse#ajouterAdresse(int,
     * int, String);
     */
    @Override
    public Adresse ajouterAdresse(Ville ville, Pays pays, String libelle) {
	Adresse ad = new Adresse();
	ad.setVille(ville);
	ad.setPays(pays);
	ad.setLibelleAdresse(libelle);
	em.persist(ad);
	return ad;
    }
    // @Override
    // public Adresse modifierAdresse(Adresse adresse) {
    // //Adresse adr = null;
    // //adr = em.find(Adresse.class, adresse.getIdAdresse());
    // em.merge(adresse);
    // return adresse;
    // }

}
