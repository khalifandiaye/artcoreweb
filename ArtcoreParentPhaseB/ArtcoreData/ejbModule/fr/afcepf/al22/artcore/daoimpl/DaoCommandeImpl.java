package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoCommande;
import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.Facture;
import fr.afcepf.al22.artcore.entities.LigneDeCommande;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;

@Stateless
public class DaoCommandeImpl implements IDaoCommande{
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public Commande creer(Commande cmd) {
		
		Commande c=cmd;
		em.persist(c);
		return c;
	}

	@Override
	public LigneDeCommande creerLc(LigneDeCommande ligneCmd) {
		LigneDeCommande lc=null;
		em.persist(ligneCmd);
		lc=ligneCmd;
		return lc;
	}


	@Override
	public Commande rechercherCmd(int id) {
		Commande cmd=null;
		Query query=em.createQuery("select c from Commande c "
				+ "inner join fetch c.ligneDeCommandes lc "
				+ "where c.idCommande = :paramId");
		query.setParameter("paramId", id);
		cmd= (Commande) query.getSingleResult();
		return cmd;
	}

	@Override
	public List<LigneDeCommande> rechercherLigneCmd(Commande cmd) {
		// TODO Auto-generated method stub
		List<LigneDeCommande> lc=null;
		Query query=em.createQuery("select l from LigneDeCommande l  "
				+ "where l.commande.idCommande = :paramIdcmd");
		query.setParameter("paramIdcmd", cmd.getIdCommande());
		lc=query.getResultList();
		return lc;
	}

	@Override
	public ModeDePaiement rechercherModeDePaiement(int id) {
		ModeDePaiement mdp=null;
		Query query= em.createQuery("select m from ModeDePaiement m "
				+ "where m.idModePaiement = :paramId");
		query.setParameter("paramId",id);
		mdp=(ModeDePaiement) query.getSingleResult();
		return mdp;
	}

	@Override
	public Facture rechercherFacture(int id) {
		Facture f=null;
		Query query= em.createQuery("select f from Facture f "
				+ "where f.idFacture = :paramId");
		f=(Facture) query.getSingleResult();
		return f;
	}

	@Override
	public List<ModeDePaiement> rechercherTousModePaiements() {
		List<ModeDePaiement> tabMdp=null;
		Query query= em.createNamedQuery("ModeDePaiement.findAll");
		tabMdp=query.getResultList();
		return tabMdp;
	}
	
	

}

