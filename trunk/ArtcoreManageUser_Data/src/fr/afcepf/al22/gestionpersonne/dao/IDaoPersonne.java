package fr.afcepf.al22.gestionpersonne.dao;
import java.util.List;

import fr.afcepf.al22.gestionpersonne.entity.Personne;

public interface IDaoPersonne {
	//Personne ajouter(Personne pers);
	//Personne cnx(String mail, String mdp);
	List<Personne> rechercher(String nom);
}
