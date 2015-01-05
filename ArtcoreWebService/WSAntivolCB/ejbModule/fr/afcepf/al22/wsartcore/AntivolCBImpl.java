/**
 * 
 */
package fr.afcepf.al22.wsartcore;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.entities.Cartebleue;

/**
 * @author Ing
 *
 */
@WebService
@Stateless
public class AntivolCBImpl implements IAntivolCB {
	
	@PersistenceContext(unitName="WSAntivolCB")
	EntityManager em;
	
	/**
	 * Je recherche dans les cartes bleues celle dont le numero est celui passé en argument.
	 * Si je trouve une carte, la méthode retourne true ; ça signifie que la carte est volée, perdue, bref, non valable.
	 * Si je ne trouve pas de carte correspondant à ce numéro, la méthode retourne false ; celà signifie que la carte est valide.
		(non-Javadoc)
	 * @see fr.afcepf.al22.wsartcore.IAntivolCB#rechercheCBVoleeParNumero(java.lang.String)
	 */
	@Override
	public boolean rechercheCBVoleeParNumero(String nbCB) {
		//je recherche dans les cartes bleues celle dont le numero est celui-ci
		//je cree un objet carte null
		Cartebleue cbRecherchee = null;
		//je recherche, s'il trouve, ça remplit l'objet carte.
		Query query = em.createQuery("SELECT cb FROM Cartebleue cb "
				+ "WHERE cb.numero = :pnum");
		query.setParameter("pnum", nbCB);
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
//		if (query.getSingleResult() != null) {
		if (query.getResultList().size() == 1) {
			cbRecherchee = (Cartebleue) query.getSingleResult();
		}
		
		//si je trouve : retourne true
		//(càd il a trouvé :la carte est volée, perdue,...)
		//su je ne trouve pas : retourne false
		//(càd il n'a pas trouvé, la carte est valide)
		if (cbRecherchee == null) {
			return false;
		} else {
			return true;
		}
		
	}

}
