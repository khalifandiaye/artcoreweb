/**
 * 
 */
package pack.test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;
import com.mongodb.MongoClient;

/**
 * @author Stagiaire
 *
 */
public class ImportGalerie {

	private static GeocoderResult rechercheGPS(String nomGalerie, String adresseGalerie) {
		final Geocoder geocoder = new Geocoder();
		GeocoderResult geoResult = null;
		try {
			
			GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(nomGalerie+" "+adresseGalerie).setLanguage("en").getGeocoderRequest();
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
	private static GalerieEntity Geocoder2GalerieEntity(GeocoderResult galerieGps) {
		GalerieEntity galerie = new GalerieEntity();
		LatLng latAndLong = galerieGps.getGeometry().getLocation();
		double latitude = latAndLong.getLat().doubleValue();
		double longitude = latAndLong.getLng().doubleValue();
		
		System.out.println("latitude "+latitude);
		System.out.println("longitude "+longitude);
		double loc[] = new double[2];
		loc[0]=longitude;
		loc[1]=latitude;
		galerie.setLoc(loc);
		
		latAndLong = galerieGps.getGeometry().getViewport().getNortheast();
		
		galerie.setNorthEastBoundLat(latAndLong.getLat().doubleValue());
		galerie.setNorthEastBoundLng(latAndLong.getLng().doubleValue());
		System.out.println("NorthEast latitude "+galerie.getNorthEastBoundLat());
		System.out.println("NorthEast longitude "+galerie.getNorthEastBoundLng());
		
		latAndLong = galerieGps.getGeometry().getViewport().getSouthwest();
		
		galerie.setSouthWestBoundLat(latAndLong.getLat().doubleValue());
		galerie.setSouthWestBoundLng(latAndLong.getLng().doubleValue());
		System.out.println("SouthWest latitude "+galerie.getSouthWestBoundLat());
		System.out.println("SouthWest longitude "+galerie.getSouthWestBoundLng());
		
		return galerie;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MongoClient mongo = null;
		List<String> lines = null;
		GalerieDao dao = null;
		try {
			lines = Files.readAllLines(Paths.get("C:\\Users\\Stagiaire\\Projet\\liste_gallerie_raw.txt"), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		try {
			mongo = new MongoClient("localhost");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Morphia morphia = new Morphia();
		dao = new GalerieDao(mongo,morphia,"galerieDB");
			
		String[] nomAdresse = null;
		
		if (lines != null) {

			int i=0;
			for(String line:lines){
				System.out.println(line);
				nomAdresse = line.split("/");
				System.out.println("Galerie : "+nomAdresse[0]+" , "+nomAdresse[1]);
				GeocoderResult geocoder = rechercheGPS(nomAdresse[0], nomAdresse[1]);
				GalerieEntity entity = Geocoder2GalerieEntity(geocoder);
				entity.setNomGalerie(nomAdresse[0]);
				entity.setFormattedAdresse(nomAdresse[1]);
				entity.setId(new Integer(i));
				System.out.println(entity);
				dao.save(entity);
				i++;
			}
		}	
		
	}

}
