package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Stagiaire
 *
 */
@Stateless
public class DaoAdresse implements IDaoAdresse {

	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	@Override
	public Adresse rechercherAdresse(int id) {
		Adresse adresse=null;
		Query query = em.createQuery("select a from Adresse a where "
				+ " a.idAdresse = :paramId");
		query.setParameter("paramId", id);
		adresse=(Adresse) query.getSingleResult();
		return adresse;
	}
	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse#ajouterAdresse(int, int, String);
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
//	@Override
//	public Adresse modifierAdresse(Adresse adresse) {
//		//Adresse adr = null;
//		//adr = em.find(Adresse.class, adresse.getIdAdresse());
//		em.merge(adresse);
//		return adresse;
//	}


}
