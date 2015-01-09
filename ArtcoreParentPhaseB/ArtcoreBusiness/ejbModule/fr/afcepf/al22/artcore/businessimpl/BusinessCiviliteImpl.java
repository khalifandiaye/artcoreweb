package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCivilite;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoCivilite;
import fr.afcepf.al22.artcore.dto.DtoCivilite;
import fr.afcepf.al22.artcore.entities.Civilite;

@Stateless
public class BusinessCiviliteImpl implements IBusinessCivilite {
    @EJB
    IDaoCivilite dao;
    @EJB
    IEntityToDto classeToDto;
    @EJB
    IDtoToEntity classeToEntity;

    @Override
    public List<DtoCivilite> listeToutesCivilites() {

	List<Civilite> listeCivilites = dao.listeToutesCivilites();

	List<DtoCivilite> liste = new ArrayList<DtoCivilite>();

	for (Civilite civilite : listeCivilites) {
	    DtoCivilite civil = classeToDto.toDto(civilite);
	    liste.add(civil);
	}

	return liste;
    }

    @Override
    public DtoCivilite civiliteParId(int id) {
	DtoCivilite civilDto = null;
	Civilite civil = dao.civiliteParId(id);
	civilDto = classeToDto.toDto(civil);
	return civilDto;
    }
}
