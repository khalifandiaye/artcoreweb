package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.artcore.entities.Civilite;

@Remote
public interface IDaoCivilite {
	
	
	public List<Civilite> listeToutesCivilites ();
	
	/**
	 * Méthode qui prend en argument un int et qui
	 * renvoie la civilité associée.
	 * @param id un int.
	 * @return la {@link Civilite} dont l'id est égal à l'int passé en paramètre.
	 */
	public Civilite civiliteParId (int id);


}
