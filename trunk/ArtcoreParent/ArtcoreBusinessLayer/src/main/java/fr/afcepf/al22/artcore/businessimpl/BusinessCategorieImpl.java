package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCategorie;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoCategorie;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.entities.Categorie;

@Stateless
public class BusinessCategorieImpl implements IBusinessCategorie {
	
	@EJB
	IDaoCategorie dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public List<DtoCategorie> listeToutescategories() {
		// TODO règles de gestion si besoin
		//Puis on appelle la méthode du dao (avec les entités).
		List<Categorie> listeCategories = dao.listeToutesCategories();
		// je transforme l'entité en dto
		List<DtoCategorie> liste = new ArrayList<DtoCategorie>();
		//c'est à dire je transforme chaque categorie de la liste de categorie
		//en dto, et je l'ajoute à ma liste de dto.
		for (Categorie categorie : listeCategories) {
			DtoCategorie cat = classeToDto.toDto(categorie);
			liste.add(cat);
		}
		//et je renvoie le dto
		return liste;
	}

	@Override
	public DtoCategorie categorieParId(int id) {
		// TODO règles de gestion 
		//je vais chercher la categorie du dao
		Categorie c = dao.categorieParId(id);
		//et je la transfoeme en dto
		DtoCategorie dto = classeToDto.toDto(c);
		return dto;
	}

}
