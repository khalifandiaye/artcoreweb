package fr.afcepf.al22.artcore.daoimpl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Stagiaire
 *
 */
@Stateless
public class DaoAdresse implements IDaoAdresse {

	@PersistenceContext(unitName="DataArtcore")
	EntityManager em;
	@Override
	public Adresse rechercherAdresse(int id) {
		Adresse adresse=null;
		Query query = em.createQuery("select a from Adresse a where "
				+ " a.idAdresse = :paramId");
		query.setParameter("paramId", id);
		adresse=(Adresse) query.getSingleResult();
		return adresse;
	}
	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse#ajouterAdresse(int, int, String);
	 */
	@Override
	public Adresse ajouterAdresse(Ville ville, Pays pays, String libelle) {
		Adresse ad = new Adresse();
		ad.setVille(ville);
		ad.setPays(pays);
		ad.setLibelleAdresse(libelle);
		em.persist(ad);
		return ad;
	}
	@Override
	public Adresse modifierAdresse(Adresse adresse) {
		//Adresse adr = null;
		//adr = em.find(Adresse.class, adresse.getIdAdresse());
		em.merge(adresse);
		return adresse;
	}
	@Override
	public Adresse ajouterLatLongALadresse(Ville ville, Pays pays,
			Adresse adresse) {
		if (adresse.getLatitude() != 0 && adresse.getLongitude() != 0){
			return adresse;
		} else {
			//on transforme l'adresse en string
			String adresseComplete = adresse.getLibelleAdresse() + " " 
					+ ville.getCodePostal() + " "
					+ pays.getLibellePays();
			//on appelle google pour avoir les latitudes et longitudes
			double lati=0;
			double longi = 0;
			GeocoderResult geoResult = rechercheGPS(adresseComplete);
			Adresse adrContenantLatLong = Geocoder2Adresse(geoResult);
			lati = adrContenantLatLong.getLatitude();
			longi = adrContenantLatLong.getLongitude();
			//on les sette à l'adresse
			adresse.setLatitude(lati);
			adresse.setLongitude(longi);
			//on enregistre l'adresse modifiée
			//et on renvoie l'adresse modifiee
			return modifierAdresse(adresse);
		}
	}
	
	/**
	 * Méthode qui prend l'adresse en paramètre 
	 * et qui renvoie une géolocalisation si j'ai bien compris.
	 * @param adresse
	 * @return
	 */
	private static GeocoderResult rechercheGPS(String adresse) {
		final Geocoder geocoder = new Geocoder();
		GeocoderResult geoResult = null;
		try {
			GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(adresse).setLanguage("en").getGeocoderRequest();
//			GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(nomGalerie+" "+adresseGalerie).setLanguage("en").getGeocoderRequest();
			GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
			
			System.out.println("Reponse status : "+geocoderResponse.getStatus().toString());
			System.out.println("Reponse : "+geocoderResponse.getResults().size());
			
			if (geocoderResponse.getResults().size()>0) {
				 geoResult = geocoderResponse.getResults().get(0);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return geoResult;
	}
	
	
	/**
	 * Méthode qui ??? à partir de la géolocalisation retourne 
	 * la latitude et la longitude ?
	 * @param galerieGps
	 * @return
	 */
	private static Adresse Geocoder2Adresse(GeocoderResult adresseGps) {
		Adresse adrClient = new Adresse();
		LatLng latAndLong = adresseGps.getGeometry().getLocation();
		double latitude = latAndLong.getLat().doubleValue();
		double longitude = latAndLong.getLng().doubleValue();
		
		System.out.println("latitude "+latitude);
		System.out.println("longitude "+longitude);
		
		//et là on sette la latitude et la longitude à l'adresse
		adrClient.setLatitude(latitude);
		adrClient.setLongitude(longitude);
		
		return adrClient;
	}

}
