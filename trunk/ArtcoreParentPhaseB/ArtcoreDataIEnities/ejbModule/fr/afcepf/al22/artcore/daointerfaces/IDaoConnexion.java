package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Admin;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Utilisateur;

@Remote 
public interface IDaoConnexion {
	public Utilisateur connexion(String login, String password);
	public Client recupererClient(Utilisateur util);
	public Admin recupererAdmin(Utilisateur util);
	
}
