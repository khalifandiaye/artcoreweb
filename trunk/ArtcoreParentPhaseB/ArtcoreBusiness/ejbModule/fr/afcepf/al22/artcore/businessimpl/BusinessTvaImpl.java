package fr.afcepf.al22.artcore.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessTva;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoTva;
import fr.afcepf.al22.artcore.dto.DtoTva;
import fr.afcepf.al22.artcore.entities.Tva;
@Stateless
public class BusinessTvaImpl implements IBusinessTva {

	@EJB
	IDaoTva dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public DtoTva tvaParId(int id) {
		// Je vais chercher la tva dans le dao
		Tva tva = dao.tvaParId(id);
		//puis je la transforme en dto
		DtoTva dto = classeToDto.toDto(tva);
		return dto;
	}

}
