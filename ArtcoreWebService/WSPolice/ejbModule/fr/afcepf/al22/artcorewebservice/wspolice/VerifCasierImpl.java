/**
 * 
 */
package fr.afcepf.al22.artcorewebservice.wspolice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcorewebservice.wspolice.entities.Statut;

/**
 * @author Stagiaire
 *
 */
@Stateless
@WebService(endpointInterface="fr.afcepf.al22.artcorewebservice.wspolice.IVerifCasier")
public class VerifCasierImpl implements IVerifCasier {
	private Logger log = Logger.getLogger(this.getClass());
	@PersistenceContext(unitName="WSPolice")
	EntityManager em;

	
	/**
	 * @see fr.afcepf.al22.artcorewebservice.wspolice.IVerifCasier#verifCasier(java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public String verifCasier(String nom, String prenom, String birthday) {
		String retour = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Query hql = em.createQuery("SELECT s.statut FROM Suspect s WHERE s.nom = :paramNom AND s.prenom = :paramPrenom AND s.dateNaissance = :paramBirthday ");
		hql.setParameter("paramNom", nom);
		hql.setParameter("paramPrenom", prenom);
		
		try {
			hql.setParameter("paramBirthday", sdf.parse(birthday) );
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		List<Statut> liste = hql.getResultList();
		if (liste.size()>0) {
			retour = liste.get(0).getLibelle();
		}else {
			retour = "";
		}
		
		return retour;
	}

}
