package fr.afcepf.al22.artcore.businessimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessRechercherProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Produit;

@Stateless
public class BusinessRechercherProduitImpl implements
		IBusinessRechercherProduit {
	/**
	 * Ici sont renseignées les valeurs frontières pour les fourchettes de prix.
	 */
	private BigDecimal maxPrixMin = BigDecimal.valueOf(1000.0);
	private BigDecimal minPrixMax = BigDecimal.valueOf(2000.0);
	
	@EJB
	IDaoRechercherProduit dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public List<DtoProduit> rechercherProduitsParNom(String nom) {
		// TODO règles de gestion : si la date de fin de vente est nulle
		//Puis on appelle la méthode du dao (avec les entités).
		List<Produit> listeProduits = dao.rechercherProduitsParNom(nom);
		// je transforme l'entité en dto
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		//c'est à dire je transforme chaque produiit de la liste de produits
		//en dto, et je l'ajoute à ma liste de dto.
		for (Produit produit : listeProduits) {
			if (produit.getDateFinDeVente() == null) {//sinon il n'est plus en vente, donc plus visible
				DtoProduit prod = classeToDto.toDto(produit);
				liste.add(prod);
			}
		}
		//et je renvoie le dto
		return liste;
	}

	@Override
	public DtoProduit produitParId(int id) {
		//TODO règles de gestion si besoin ; on ne met pas la date de fin de vente :
		//seuls les admins demanderont le produit selon son id,
		//au pire les utilisateurs qui l'auront vu dans une liste
		//(auquel cas le produit a déjà été checké).
		Produit p = dao.produitParId(id);
		DtoProduit prod = classeToDto.toDto(p);
		return prod;
	}

	/**
	 * Méthode qui renvoie tous les {@link DtoProduit}.
	 * ATTENTION : CETTE METHODE RENVOIE AUSSI LES PRODUITS QUI NE SONT PLUS PROPOSES A LA VENTE.
	 */
	@Override
	public List<DtoProduit> listeTousProduits() {
		// TODO règles de gestion si besoin
		List<Produit> listeProduits = dao.listeTousProduits();
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		for (Produit produit : listeProduits) {
			DtoProduit prod = classeToDto.toDto(produit);
			liste.add(prod);
		}
		return liste;
	}
	
	/**
	 * Méthode qui renvoie tous les {@link DtoProduit} dont la date de fin de vente n'est pas renseignee.
	 */
	@Override
	public List<DtoProduit> listeTousProduitsEnVente() {
		// TODO règles de gestion si besoin
		List<Produit> listeProduits = dao.listeTousProduits();
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		for (Produit produit : listeProduits) {
			if (produit.getDateFinDeVente() == null) {
				//regle de gestion, le produit est encore en vente
				DtoProduit prod = classeToDto.toDto(produit);
				liste.add(prod);
			}
		}
		return liste;
	}

	@Override
	public List<DtoProduit> produitsParCategorie(int idCategorie) {
		// TODO règles de gestion si besoin
		//Puis on appelle la méthode du dao (avec les entités).
		List<Produit> listeProduits = dao.produitsParCategorie(idCategorie);
		// je transforme l'entité en dto
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		//c'est à dire je transforme chaque produiit de la liste de produits
		//en dto, et je l'ajoute à ma liste de dto.
		for (Produit produit : listeProduits) {
			DtoProduit prod = classeToDto.toDto(produit);
			liste.add(prod);
		}
		//et je renvoie le dto
		return liste;
	}

	@Override
	public List<DtoProduit> produitsParFormat(int idFormat) {
		// TODO règles de gestion si besoin
		//Puis on appelle la méthode du dao (avec les entités).
		List<Produit> listeProduits = dao.produitsParFormat(idFormat);
		// je transforme l'entité en dto
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		//c'est à dire je transforme chaque produit de la liste de produits
		//en dto, et je l'ajoute à ma liste de dto.
		for (Produit produit : listeProduits) {
			DtoProduit prod = classeToDto.toDto(produit);
			liste.add(prod);
		}
		//et je renvoie le dto
		return liste;
	}

	@Override
	public List<DtoProduit> produitsParPrix(Boolean prixMin, Boolean prixInter,
			Boolean prixMax) {
		// TODO règles de gestion si besoin
				List<Produit> listeProduits = dao.listeTousProduits();
				List<DtoProduit> liste = new ArrayList<DtoProduit>();
				for (Produit produit : listeProduits) {
					if (produit.getDateFinDeVente() == null) {
//						if ((prixMin && produit.getPrixProduit().compareTo(minPrixMax) <0)
//								|| (prixInter && produit.getPrixProduit().compareTo(minPrixMax) >0
//									&& produit.getPrixProduit().compareTo(maxPrixMin)>0)
//								|| (prixMax && produit.getPrixProduit().compareTo(maxPrixMin))>0)) {
//									
//								}
						if (prixMin && produit.getPrixProduit().compareTo(maxPrixMin) <0) {//1000
							//regle de gestion, le produit est encore en vente
							DtoProduit prod = classeToDto.toDto(produit);
							liste.add(prod);
						}
						if (prixInter && produit.getPrixProduit().compareTo(minPrixMax) <0
									&& produit.getPrixProduit().compareTo(maxPrixMin)>0) {
							DtoProduit prod = classeToDto.toDto(produit);
							liste.add(prod);
						}
						if (prixMax && produit.getPrixProduit().compareTo(minPrixMax)>0) {
							DtoProduit prod = classeToDto.toDto(produit);
							liste.add(prod);
						}
						
					}
				}
				
				return liste;
	}

	@Override
	public List<DtoProduit> produitsParArtiste(String nomArtiste) {
		// TODO règles de gestion : si la date de fin de vente est nulle
		//Puis on appelle la méthode du dao (avec les entités).
		List<Produit> listeProduits = dao.produitsParArtiste(nomArtiste);
		// je transforme l'entité en dto
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		//c'est à dire je transforme chaque produiit de la liste de produits
		//en dto, et je l'ajoute à ma liste de dto.
		for (Produit produit : listeProduits) {
			if (produit.getDateFinDeVente() == null) {//sinon il n'est plus en vente, donc plus visible
				DtoProduit prod = classeToDto.toDto(produit);
				liste.add(prod);
			}
		}
		//et je renvoie le dto
		return liste;
	}


	@Override
	public List<DtoProduit> produitsMultiCriteres(String libelle,
			String nomArtiste, int idCategorie, int idFormat, Boolean prixMin,
			Boolean prixInter, Boolean prixMax) {
		// TODO règles de gestion si besoin
		List<Produit> listeProduits = dao.produitsMultiCriteres(libelle, nomArtiste, idCategorie, idFormat);
		List<DtoProduit> liste = new ArrayList<DtoProduit>();
		for (Produit produit : listeProduits) {
			if (produit.getDateFinDeVente() == null) {
				if (prixMin && produit.getPrixProduit().compareTo(maxPrixMin) <0) {//1000
					DtoProduit prod = classeToDto.toDto(produit);
					liste.add(prod);
				}
				if (prixInter && produit.getPrixProduit().compareTo(minPrixMax) <0
							&& produit.getPrixProduit().compareTo(maxPrixMin)>0) {
					DtoProduit prod = classeToDto.toDto(produit);
					liste.add(prod);
				}
				if (prixMax && produit.getPrixProduit().compareTo(minPrixMax)>0) {
					DtoProduit prod = classeToDto.toDto(produit);
					liste.add(prod);
				}
			}
		}
		return liste;
	}

}
