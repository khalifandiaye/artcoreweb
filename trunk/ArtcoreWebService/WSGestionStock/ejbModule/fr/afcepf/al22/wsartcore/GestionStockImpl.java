package fr.afcepf.al22.wsartcore;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al22.entities.Produit;

@WebService //pour les webservices
@Stateless //pour les ejb
public class GestionStockImpl implements IGestionStock {

	//nom du persistence-unit dans le fichier persistence.xml
	@PersistenceContext(unitName="WSGestionStock")
	EntityManager em;
	
		@Override
		public int rechercherNbProduitDisponibleParId(int id) {
		Produit produitTrouve=em.find(Produit.class, id);
		return produitTrouve.getStock();
		
	}

}
