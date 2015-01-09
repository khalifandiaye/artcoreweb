package fr.afcepf.al22.artcore.daointerfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Ville;
@Remote
public interface IDaoAdresse {

	/**
	 * rechercher une adresse avec son id.
	 * @param id .
	 * @return
	 */
	public Adresse rechercherAdresse(int id);
	/**
	 * Méthode pour ajouter une adresse.
	 * @param ville  la {@link Ville} correspondant à cette adresse.
	 * @param pays le {@link Pays} correspondant à cette adresse.
	 * @param libelle le libelle de l'adresse.
	 * @return l'{@link Adresse} qui vient d'être crée.
	 */
	public Adresse ajouterAdresse (Ville ville, Pays pays, String libelle);
	
//	/**
//	 * Méthode permettant de modifier une adresse.
//	 * J'en aurai besoin pour lui ajouter le client.
//	 * Parce qu'il faut l'adresse avant de créer un client,
//	 * mais une adresse possède un client.
//	 * Donc la modif reviendra à ajouter le client une fois qu'il existe.
//	 * @param adresse la nouvelle adresse.
//	 * @return l'adresse modifiée.
//	 */
//	public Adresse modifierAdresse (Adresse adresse);
	
}
