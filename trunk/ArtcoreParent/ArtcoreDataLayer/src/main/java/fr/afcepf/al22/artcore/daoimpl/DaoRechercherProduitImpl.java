package fr.afcepf.al22.artcore.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.entities.Produit;
@Stateless
public class DaoRechercherProduitImpl implements IDaoRechercherProduit {
	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	
//	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * Méthode qui recherche les {@link Produit} par nom.

	 */
	@Override
	public List<Produit> rechercherProduitsParNom(String nom) {
		//TODO à voir pour le thème
		Query query = em.createQuery("FROM Produit p "
				+ "WHERE p.libelleProduit LIKE :pnom ");
		query.setParameter("pnom", "%"+nom+"%");
		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

	/**
	 * Méthode qui recherche un {@link Produit} par id.
	 */
	@Override
	public Produit produitParId(int id) {
		Query query = em.createQuery("FROM Produit p "
				+ "WHERE p.idProduit = :pid");
		query.setParameter("pid", id);
		Produit p = null;
		//pour être sûr de n'avoir pas d'erreur (si je n'ai pas de résultat)
		if (query.getSingleResult() != null) {
			p = (Produit) query.getSingleResult();
		}
		return p;
	}

	/**
	 * Méthode qui renvoie tous les {@link Produit} de la base.
	 * Pour l'instant je n'ai pas associé au thème.
	 */
	@Override
	public List<Produit> listeTousProduits() {
		Query query = em.createQuery("FROM Produit p ");
//				+ "Inner join fetch p.idCategorie cat "
//				+ "Inner join fetch p.idFormat f "
//				+ "Inner join fetch p.idTva tva ");
		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

	@Override
	public List<Produit> produitsParCategorie(int idCategorie) {
		Query query = em.createQuery("FROM Produit p "
				+ "Inner join fetch p.categorie cat "
				+ "WHERE cat.idCategorie = :pidcat ");
		query.setParameter("pidcat", idCategorie);
		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

	@Override
	public List<Produit> produitsParFormat(int idFormat) {
		Query query = em.createQuery(" FROM Produit p "
				+ "Inner join fetch p.format format "
				+ "WHERE format.idFormat = :pidf ");
		query.setParameter("pidf", idFormat);
		List<Produit> listeProduits = new ArrayList<>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

	@Override
	public List<Produit> produitsParArtiste(String nomArtiste) {
		Query query = em.createQuery("FROM Produit p "
				+ "WHERE p.nomArtiste LIKE :pnom ");
		query.setParameter("pnom", "%"+nomArtiste+"%");
		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

	@Override
	public List<Produit> produitsMultiCriteres(String libelle,
			String nomArtiste, int idCategorie, int idFormat) {
		Query query = em.createQuery("SELECT p FROM Produit p "
				+ "inner join fetch p.categorie "
				+ "inner join fetch p.format "
				+ "WHERE p.libelleProduit LIKE :pnom "
				+ "AND p.nomArtiste LIKE :pnomA "
				+ "AND p.categorie.idCategorie = :pidcat "
				+ "AND p.format.idFormat = :pidf ");
		query.setParameter("pnom", "%"+libelle+"%");
		query.setParameter("pnomA", "%"+nomArtiste+"%");
		query.setParameter("pidcat", idCategorie);
		query.setParameter("pidf", idFormat);
		List<Produit> listeProduits = new ArrayList<Produit>();
		listeProduits = (List<Produit>) query.getResultList();
		return listeProduits;
	}

}
