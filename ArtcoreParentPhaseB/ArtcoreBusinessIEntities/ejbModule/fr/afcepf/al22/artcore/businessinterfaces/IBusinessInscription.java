package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoProfessionnel;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;

@Remote
public interface IBusinessInscription {

	/* Inscription */

	public DtoUtilisateur creerUtilisateur(DtoUtilisateur dtoUtilisateur);
	public DtoAdresse creerAdresse(DtoAdresse dtoAdresse);
	public DtoClient creerClient(DtoClient dtoClient,DtoAdresse dtoAdresse,DtoProfessionnel dtoProfessionnel, DtoUtilisateur dtoUtilisateur);
    public DtoProfessionnel creerPro(DtoProfessionnel dtoProfessionnel);
	public List<DtoPays> listeTousPays();
	public DtoClient creerClient2(DtoClient clientBean);
    
}
