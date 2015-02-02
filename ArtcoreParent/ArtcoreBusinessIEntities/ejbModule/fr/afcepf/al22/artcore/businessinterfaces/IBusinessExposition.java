package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import fr.afcepf.al22.morphia.entity.Exposition;

public interface IBusinessExposition {
	public List<Exposition> toutesLesExpos();
	public List<Exposition> rechercherExposParPseudoArtiste(String pseudo);
	public List<Exposition> rechercherExposParLibelleCategorie(String categorie);
	public List<Exposition> rechercherExposParProximiteLatLongiRadius(double lat, double longi,double radius);

}
