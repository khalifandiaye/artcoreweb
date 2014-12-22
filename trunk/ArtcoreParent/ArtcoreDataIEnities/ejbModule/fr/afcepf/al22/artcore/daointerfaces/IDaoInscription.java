package fr.afcepf.al22.artcore.daointerfaces;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Professionnel;
import fr.afcepf.al22.artcore.entities.Utilisateur;
 
@Remote
public interface IDaoInscription {


public Utilisateur creerUtilisateur(Utilisateur utilisateur);
public Adresse creerAdresse(Adresse adresse);
public Client creerClient(Client client,Adresse adresse,Professionnel professionnel,Utilisateur utilisateur);
public Professionnel creerPro(Professionnel pro);
public List<Pays> listeTousPays();
public Client creerClient2(Client client);


}