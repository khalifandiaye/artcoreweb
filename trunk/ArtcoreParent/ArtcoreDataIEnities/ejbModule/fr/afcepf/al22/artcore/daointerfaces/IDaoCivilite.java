package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.artcore.entities.Civilite;

@Remote
public interface IDaoCivilite {
	
	
	public List<Civilite> listeToutesCivilites ();


}
