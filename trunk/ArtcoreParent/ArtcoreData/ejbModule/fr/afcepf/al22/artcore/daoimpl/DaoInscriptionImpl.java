package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoInscription;


import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Professionnel;
import fr.afcepf.al22.artcore.entities.Utilisateur;
@Stateless
public class DaoInscriptionImpl implements IDaoInscription {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	private Logger log = Logger.getLogger(this.getClass());



	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {	
		Utilisateur u= utilisateur;
		System.out.println(u.toString());
		em.persist(u);
		return u;
	}

	@Override
	public Adresse creerAdresse(Adresse adresse) {	
		Adresse a  =adresse;
		System.out.println(a.toString());
		em.persist(a);
		return a;
	}
	
	
	@Override
	public Professionnel creerPro(Professionnel professionnel) {
	
		Professionnel p = new Professionnel();
		p.setIdProfessionnel(51);
		p.setNumSiret("51");
		professionnel=p; 
		System.out.println(p.toString());
		em.persist(professionnel);
		return p;
	}

	
	@Override
	public Client creerClient(Client client,Adresse adresse,Professionnel professionnel, Utilisateur utilisateur) {
			Client c = null;
			
			client.setProfessionnel(professionnel);
		    client.setUtilisateur(utilisateur);
			
			em.persist(client);
			return null;
	}
	
	@Override
	public Client creerClient2(Client client) {
			Client c = null;
			em.persist(client);
			c=client;
			System.out.println(c.toString());
			return c;
	}
	
	
	
	@Override
	public List<Pays> listeTousPays() {
		List<Pays> tablePays=null;
		Query query = em.createNamedQuery("Pays.findAll");
		tablePays=query.getResultList()
		 ;
		 
		return tablePays;
	}
	
	
	
	}
	
	
	

