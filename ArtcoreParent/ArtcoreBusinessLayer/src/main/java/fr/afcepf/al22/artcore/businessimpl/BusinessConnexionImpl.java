package fr.afcepf.al22.artcore.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessConnexion;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.conversion.EntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoConnexion;
import fr.afcepf.al22.artcore.dto.DtoAdmin;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.entities.Admin;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Utilisateur;

@Stateless
public class BusinessConnexionImpl implements IBusinessConnexion {

	@EJB
	IDaoConnexion dao;
	
	@EJB
	IEntityToDto entityDto;
	
	@EJB
	IDtoToEntity dtoEntity;
	
	@Override
	public DtoUtilisateur connexion(String login, String password) {
			
	Utilisateur user = dao.connexion(login, password);
			
	/*	DtoUtilisateur dto = new DtoUtilisateur(
					user.getIdUtilisateur(),
					user.getIdRole(),
					user.getLogin(),
					user.getMotDePasse());
					*/
		
		DtoUtilisateur dto = entityDto.toDto(user);
		return dto;
	}

	@Override
	public DtoClient recupererClient(DtoUtilisateur dtoUtil) {
		Utilisateur util = dtoEntity.toJpa(dtoUtil);
		Client client = dao.recupererClient(util);
		DtoClient dtoClient = entityDto.toDto(client);
		return dtoClient;
	}

	@Override
	public DtoAdmin recupererAdmin(DtoUtilisateur dtoUtil) {
		Utilisateur util = dtoEntity.toJpa(dtoUtil);
		Admin admin = dao.recupererAdmin(util);
		DtoAdmin dtoAdmin = entityDto.toDto(admin);
		return dtoAdmin;
	}


}
