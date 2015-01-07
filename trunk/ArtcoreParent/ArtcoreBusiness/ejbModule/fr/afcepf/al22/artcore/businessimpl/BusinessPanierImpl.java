package fr.afcepf.al22.artcore.businessimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPanier;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@Stateful
public class BusinessPanierImpl implements IBusinessPanier {
	private Logger log = Logger.getLogger(this.getClass());
	/*
	 * ListBlocProduit represente le panier .
	 * un BlocProduitDto est un Objet qui a un attribut produit,quantite et prixTotal 
	 */
	List<BlocProduitDto> ListBlocProduit;
	
	@PostConstruct
	public void initialisation(){ 
		ListBlocProduit =new ArrayList<BlocProduitDto>();	
	}
	
	@PreDestroy 
	public void clear(){
		ListBlocProduit=null;
	}
	
	/*
	 * ajouter un produit au panier
	 */
	@Override
	public void ajouterProduit(DtoProduit produit) {
		boolean inexistant=true;
		for (BlocProduitDto blocProduitDto : ListBlocProduit) {
			if(blocProduitDto.getProduit().getIdProduit()==produit.getIdProduit()){
				inexistant=false;
				blocProduitDto.setQuantite(blocProduitDto.getQuantite()+1);
			}
		}
		
		if(inexistant){
			ListBlocProduit.add(new BlocProduitDto(produit));
		}
	}

	/*
	 * retirer un produit du panier
	 */
	@Override
	public List<BlocProduitDto> retirerProduit(DtoProduit produiDtoProduit) {
		BlocProduitDto asupp = null;
		for (BlocProduitDto blocProduitDto : ListBlocProduit) {
			if(blocProduitDto.getProduit().getIdProduit()==produiDtoProduit.getIdProduit()){
				asupp = blocProduitDto;
			}
		}
		if(asupp != null) {
			ListBlocProduit.remove(asupp);
		}
		return this.ListBlocProduit;
	}

	/*
	 * calcul du prix total : prix total eqgale a la somme du prix total des lignes de commande
	 */
	@Override
	public BigDecimal prixTotal() {
		BigDecimal prixTotal=new BigDecimal(0);
		log.debug("Business : on rentre dans la méthode prix total.");
		if(ListBlocProduit!=null && !ListBlocProduit.isEmpty()){
			log.debug("business : le panier n'est ni null ni vide.");
			log.debug("Business : Le panier a une taille de : " +ListBlocProduit.size());
			for (BlocProduitDto blocProduitDto : ListBlocProduit) {
				prixTotal = prixTotal.add(blocProduitDto.getPrixTotalParPdt());
			}
		}
		/**
		 * Et s'il est vidé alors ???
		 */
		else {
			log.debug("Business : on rentre dans mon else");
			int prix = 0;
			prixTotal = null;
			log.debug("Business : le prix total est null : " +prixTotal);
			prixTotal=new BigDecimal(0);
			log.debug("Business : maintenant il est censé être à 0 : " + prixTotal);
		}
		return prixTotal;
	}

	/*
	 * vider le panier
	 */
	@Override
	public void viderPanier() {
		//FIXME Je vais remettre checkstyle :( 
		if(ListBlocProduit!=null)log.debug("le panier n existe pas ");
		else log.debug(ListBlocProduit.size());
		ListBlocProduit=null;
	}

	/**
	 *  retourne le panier
	 */
	@Override
	public List<BlocProduitDto> getListBlocProduit() {
		return this.ListBlocProduit;
	}
	
	/**
	 * modification de la quantite d'un produit
	 */
	@Override
	public void modifierQtePdt(DtoProduit produiDtoProduit,int quantite){
		BlocProduitDto aChange = null;
		for (BlocProduitDto blocProduitDto : ListBlocProduit) {
			if(blocProduitDto.getProduit().getIdProduit()==produiDtoProduit.getIdProduit()){
				aChange = blocProduitDto;
			}
		}
		if(aChange != null) {
			aChange.setQuantite(quantite);
		}
		
	}

}
