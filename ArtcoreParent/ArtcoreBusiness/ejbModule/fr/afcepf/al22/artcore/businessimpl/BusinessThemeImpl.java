package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessTheme;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoTheme;
import fr.afcepf.al22.artcore.dto.DtoTheme;
import fr.afcepf.al22.artcore.entities.Theme;
@Stateless
public class BusinessThemeImpl implements IBusinessTheme {
	
	@EJB
	IDaoTheme daoTheme;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	@Override
	public List<DtoTheme> listeTousThemes() {
		// TODO règles de gestion si besoin
		List<Theme> listeTheme = daoTheme.listeTousThemes();
		List<DtoTheme> listedto = new ArrayList<DtoTheme>();
		for (Theme theme : listeTheme) {
			DtoTheme dtoT = classeToDto.toDto(theme);
			listedto.add(dtoT);
		}
		return listedto;
	}

}
