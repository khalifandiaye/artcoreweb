package fr.afcepf.al22.artcore.daoimpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;







import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoConnexion;
import fr.afcepf.al22.artcore.entities.Admin;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Utilisateur;



@Stateless
public class DaoConnexionImpl implements IDaoConnexion {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	// MF 18/11/2014
	@Override
	public Utilisateur connexion(String login, String password) {
		/**
		 * On cr�e la requ�te dans la table utilisateur et on cherche le login et le mdp.
		 */

	Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login LIKE :paramlogin AND u.motDePasse LIKE :parampassword");
	query.setParameter("paramlogin", login);
	query.setParameter("parampassword", password);

	Utilisateur util = null;

	// Notre query fait des erreurs 500 s'il n'y a rien
	try {
		if (query.getSingleResult() != null) {
			util = (Utilisateur) query.getSingleResult() ;
			log.debug(util);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error(e.toString());
		e.printStackTrace();
	}	
	
	// Si on le trouve, on renvoie un utilisateur avec son int (tuteur, presta ...)
	return util;
	}

	@Override
	public Client recupererClient(Utilisateur util) {
		log.debug("DaoConnexion : dao mal nommé par Michaël où on cherche un client.");
		Query query = em.createQuery("SELECT c FROM Client c "
				+ " inner join fetch c.adresses a "
				+ " inner join fetch a.pays p"
				+ " inner join fetch a.ville v "
				+ " WHERE c.utilisateur.idUtilisateur LIKE :paramUtil ");
		
		query.setParameter("paramUtil", util.getIdUtilisateur());
		
		Client client = null;
		try {
			if (query.getSingleResult() != null) {
				client = (Client) query.getSingleResult() ;
				log.debug(util);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}	
		log.debug("daoConnexion toujours : le client a :");
		log.debug("daoConnexion toujours : id du client  :" + client.getIdClient());
		log.debug("daoConnexion toujours : nom du client :"+client.getNomClient());
		for (Adresse adr : client.getAdresses()) {
			log.debug("");
			log.debug("daoConnexion toujours : une adresse d'id :"+adr.getIdAdresse());
			log.debug("daoConnexion toujours : et de libelle "+adr.getLibelleAdresse());
			log.debug("");
		}
		
		
		return client;
	}

	@Override
	public Admin recupererAdmin(Utilisateur util) {
		Query query = em.createQuery("SELECT a FROM Admin a WHERE a.utilisateur.idUtilisateur LIKE :paramUtil ");
		query.setParameter("paramUtil", util.getIdUtilisateur());
		
		Admin admin = null;
		try {
			if (query.getSingleResult() != null) {
				admin = (Admin) query.getSingleResult() ;
				log.debug(util);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
			e.printStackTrace();
		}	
		
		return admin;
	}
	
	

}
