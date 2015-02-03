package fr.afcepf.al22.artcore.businessinterfaces;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoProduit;
@Remote
public interface IBusinessPanier {
	/*
	 * ajouter un produit au panier
	 */
	public void ajouterProduit(DtoProduit produit);
	
	/*
	 * retirer un produit du panier
	 */
	public List<BlocProduitDto> retirerProduit(DtoProduit protuit);
	/*
	 * calcul du prix total : prix total eqgale a la somme du prix total des lignes de commande
	 */
	public BigDecimal prixTotal();
	/*
	 * vider le panier
	 */
	public void viderPanier();
	/*
	 *  retourne le panier
	 */
	public List<BlocProduitDto> getListBlocProduit();

	void modifierQtePdt(DtoProduit produiDtoProduit, int quantite);
}
