package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoAdmin;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.entities.Utilisateur;


@Remote 
public interface IBusinessConnexion {
	
	public DtoUtilisateur connexion(String login, String password);
	public DtoClient recupererClient(DtoUtilisateur util);
	public DtoAdmin recupererAdmin(DtoUtilisateur util);
	
}
