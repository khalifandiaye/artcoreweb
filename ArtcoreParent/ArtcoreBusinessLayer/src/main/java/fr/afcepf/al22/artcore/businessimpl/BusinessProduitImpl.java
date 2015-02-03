package fr.afcepf.al22.artcore.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoProduit;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Produit;

@Stateless
public class BusinessProduitImpl implements IBusinessProduit {
	
	@EJB
	IDaoProduit dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public Produit creer(DtoProduit produit) {
		// TODO règles de gestion si besoin
		//je change le dto en produit
		Produit p = classeToEntity.toJpa(produit);
		//puis j'appelle le dao
		dao.creer(p);
		return null;
	}

	@Override
	public DtoProduit modifier(DtoProduit produit) {
		// TODO règles de gestion si besoin
		//je convertis le dto produit à modifier en entité produit
		Produit p = classeToEntity.toJpa(produit);
		//je modifie le produit
		Produit prodModif = dao.modifier(p);
		//je convertis le produit modifié en dto produit que je renvoie
		DtoProduit prod = classeToDto.toDto(prodModif);
		return prod;
	}

	@Override
	public int supprimer(DtoProduit produit) {
		// TODO règles de gestion si besoin
		//je transforme mon dtoproduit en produit
		Produit p = classeToEntity.toJpa(produit);
		//puis je le supprime via le dao
		int i = dao.supprimer(p);
		return i;
	}

}
