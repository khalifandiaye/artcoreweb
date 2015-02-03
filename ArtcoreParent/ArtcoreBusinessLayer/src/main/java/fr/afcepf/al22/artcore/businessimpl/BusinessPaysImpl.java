package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPays;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoPays;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.entities.Pays;
@Stateless
public class BusinessPaysImpl implements IBusinessPays {
	@EJB
	IDaoPays dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public List<DtoPays> listeTousPays() {
		List<Pays> listePays = dao.listeTousPays();
		 
		List<DtoPays> liste = new ArrayList<DtoPays>();
		 
		for (Pays pays : listePays) {
			DtoPays paysDto = classeToDto.toDto(pays);
			liste.add(paysDto);}
		return liste;
	}

	@Override
	public DtoPays paysParId(int id) {
		Pays pays = dao.paysParId(id);
		DtoPays paysDto = classeToDto.toDto(pays);
		return paysDto;
	}

}
