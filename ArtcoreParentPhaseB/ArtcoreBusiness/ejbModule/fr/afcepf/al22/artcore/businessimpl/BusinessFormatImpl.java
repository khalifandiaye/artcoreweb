package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessFormat;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoFormat;
import fr.afcepf.al22.artcore.dto.DtoFormat;
import fr.afcepf.al22.artcore.entities.Format;
@Stateless
public class BusinessFormatImpl implements IBusinessFormat {
	
	
	@EJB
	IDaoFormat dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public List<DtoFormat> listeTousFormats() {
		// TODO règles de gestion si besoin
		//Puis on appelle la méthode du dao (avec les entités).
		List<Format> listeFormats = dao.listeTousFormats();
		// je transforme l'entité en dto
		List<DtoFormat> liste = new ArrayList<DtoFormat>();
		//c'est à dire je transforme chaque categorie de la liste de categorie
		//en dto, et je l'ajoute à ma liste de dto.
		for (Format format : listeFormats) {
			DtoFormat fo = classeToDto.toDto(format);
			liste.add(fo);
		}
		//et je renvoie le dto
		return liste;
	}

	@Override
	public DtoFormat formatParId(int id) {
		// TODO règles de gestion 
		//je vais chercher la categorie du dao
		Format f = dao.formatParId(id);
		//et je la transfoeme en dto
		DtoFormat dto = classeToDto.toDto(f);
		return dto;
	}

}
