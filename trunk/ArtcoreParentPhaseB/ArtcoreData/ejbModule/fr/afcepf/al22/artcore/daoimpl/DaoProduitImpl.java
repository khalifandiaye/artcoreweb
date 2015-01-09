package fr.afcepf.al22.artcore.daoimpl;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.daointerfaces.IDaoProduit;
import fr.afcepf.al22.artcore.entities.Produit;
@Stateless
public class DaoProduitImpl implements IDaoProduit {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
	private Logger log = Logger.getLogger(this.getClass());



	/**
	 * Méthode qui crée un {@link Produit} donné en argument.
	 */
	@Override
	public Produit creer(Produit produit) {
		log.info("DaoProduitImpl : creer");
		Produit p = null;
		produit.setDateDebutDeVente(new Date());
		em.persist(produit);
		p = produit;
		return p;
	}





	/**
	 * Méthode qui modifie un {@link Produit} ;
	 * On lui donne un {@link Produit} en argument.
	 * Elle recherche ce {@link Produit} et le modifie.
	 * Elle retourne le {@link Produit} modifié.
	 */
	@Override
	public Produit modifier(Produit produit) {
		log.info("DaoProduitImpl : modifier");
		//Produit p = null;
		//p = em.find(Produit.class, produit.getIdProduit());
		em.merge(produit);
		return produit;
	}

	/**
	 * Méthode qui "supprime" les produits,
	 * c'est à dire qui leur ajoute une date de fin de vente.
	 */
	@Override
	public int supprimer(Produit produit) {
		log.info("DaoProduitImpl : supprimer");
		produit.setDateFinDeVente(new Date());
		em.merge(produit);
		return 1;
	}

}
