package fr.afcepf.al22.artcore.businessimpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessInscription;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoInscription;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoProfessionnel;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Professionnel;
import fr.afcepf.al22.artcore.entities.Utilisateur;

@Stateless
public class BusinessInscriptionImpl implements IBusinessInscription {
	private Logger log = Logger.getLogger(this.getClass());
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;
	@EJB
	IDaoInscription dao;

	@Override
	public DtoUtilisateur creerUtilisateur(DtoUtilisateur dtoUtilisateur) {
		// je transfere mon dtoutilisateur en entite Utilisateur
		Utilisateur utilisateur = classeToEntity.toJpa(dtoUtilisateur);

		// Appel du Dao avec les entites et je renvoie vers le DTO
		Utilisateur u = dao.creerUtilisateur(utilisateur);
		// u est une entite
		dtoUtilisateur = classeToDto.toDto(u);
		return dtoUtilisateur;
		// je remplace l'utilisateur le nouveau avec l'id pour le retransformer
		// en DTO
	}

	@Override
	public DtoAdresse creerAdresse(DtoAdresse dtoAdresse) {

		DtoClient dtoClient = new DtoClient();
		Adresse adresse = classeToEntity.toJpa(dtoAdresse, dtoClient);
		Adresse a = dao.creerAdresse(adresse);
		// a est une entite
		dtoAdresse = classeToDto.toDto(a);

		return dtoAdresse;
	}

	@Override
	public DtoProfessionnel creerPro(DtoProfessionnel dtoProfessionnel) {

		Professionnel professionnel = classeToEntity.toJpa(dtoProfessionnel);
		Professionnel p = dao.creerPro(professionnel);
		dtoProfessionnel = classeToDto.toDto(p);
		return dtoProfessionnel;

	}

	@Override
	public DtoClient creerClient2(DtoClient dtoClient) {
		// Client client =classeToEntity.toJpa(dtoClient);

		Client client = classeToEntity.toJpa(dtoClient);

		Client c = dao.creerClient2(client);
		log.debug("BUSINESS INSCRIPTION IMPL");
		return dtoClient;
	}

	@Override
	public DtoClient creerClient(DtoClient dtoClient, DtoAdresse dtoAdresse,
			DtoProfessionnel dtoProfessionnel, DtoUtilisateur dtoUtilisateur) {
		// Client client =classeToEntity.toJpa(dtoClient);

		Utilisateur utilisateur = classeToEntity.toJpa(dtoUtilisateur);
		Adresse adresse = classeToEntity.toJpa(dtoAdresse, dtoClient);
		Professionnel professionnel = classeToEntity.toJpa(dtoProfessionnel);
		Client client = classeToEntity.toJpa(dtoClient);

		Client c = dao.creerClient(client, adresse, professionnel, utilisateur);
		log.debug("BUSINESS INSCRIPTION IMPL");
		return dtoClient;
	}

	@Override
	public List<DtoPays> listeTousPays() {

		List<Pays> listePays = dao.listeTousPays();

		List<DtoPays> liste = new ArrayList<DtoPays>();

		for (Pays pays : listePays) {
			DtoPays pa = classeToDto.toDto(pays);
			liste.add(pa);
		}

		return liste;
	}

	public IEntityToDto getClasseToDto() {
		return classeToDto;
	}

	public void setClasseToDto(IEntityToDto classeToDto) {
		this.classeToDto = classeToDto;
	}

	public IDtoToEntity getClasseToEntity() {
		return classeToEntity;
	}

	public void setClasseToEntity(IDtoToEntity classeToEntity) {
		this.classeToEntity = classeToEntity;
	}

	public IDaoInscription getDao() {
		return dao;
	}

	public void setDao(IDaoInscription dao) {
		this.dao = dao;
	}

}
