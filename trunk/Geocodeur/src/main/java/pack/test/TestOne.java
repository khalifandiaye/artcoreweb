package pack.test;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.LatLng;

public class TestOne {
	

	public static void main(String[] args) {
	try {
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Paris, France").setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		System.out.println("Reponse status : "+geocoderResponse.getStatus().toString());
		System.out.println("Reponse : "+geocoderResponse.getResults().size());
		for (GeocoderResult result : geocoderResponse.getResults()) {
			System.out.println("result : "+result.toString());
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
System.out.println("*********************test avec une vraie adresse*****************");
	try {
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("Galerie Perrotin 76 rue de Turenne Paris, France").setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		System.out.println("Reponse status : "+geocoderResponse.getStatus().toString());
		System.out.println("Reponse : "+geocoderResponse.getResults().size());
		//geometry=GeocoderGeometry{location=LatLng{lat=48.86053039999999, lng=2.3646096}
		GeocoderResult geoResult = geocoderResponse.getResults().get(0);
		LatLng latAndLong = geoResult.getGeometry().getLocation();
		String latitude = latAndLong.getLat().toString();
		String longitude = latAndLong.getLng().toString();
		System.out.println("latitude "+latitude);
		System.out.println("longitude "+longitude);
		
		for (GeocoderResult result : geocoderResponse.getResults()) {
			System.out.println("result : "+result);
			String resultat = result.toString();
			resultat = resultat.substring(14);
			System.out.println("Apres substring "+ resultat);
			resultat = resultat.replaceAll("=",":");
			System.out.println(" enfin du JSON "+ resultat);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
}