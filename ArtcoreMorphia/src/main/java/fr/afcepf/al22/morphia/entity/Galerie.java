package fr.afcepf.al22.morphia.entity;

import java.util.Arrays;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
@Entity("gpsgalerie")
public class Galerie {
		
		@Override
    public String toString() {
	return "Galerie [id=" + id + ", nomGalerie=" + nomGalerie
		+ ", formattedAdresse=" + formattedAdresse + ", loc="
		+ Arrays.toString(loc) + ", southWestBoundLat="
		+ southWestBoundLat + ", southWestBoundLng="
		+ southWestBoundLng + ", northEastBoundLat="
		+ northEastBoundLat + ", northEastBoundLng="
		+ northEastBoundLng + "]";
    }

		@Id
		private Integer id;
		/**nom de la Galerie*/
		private String nomGalerie;
		/**formattedAddress='76 Rue de Turenne, 75003 Paris, France'*/
		private String formattedAdresse;
		/**geometry=GeocoderGeometry{location=LatLng{lat=48.86053039999999, lng=2.3646096}*/
		@Indexed
		private double[] loc;
		
		/**viewport=LatLngBounds{southwest=LatLng{lat=48.8591814197085, lng=2.363260619708498}, northeast=LatLng{lat=48.8618793802915, lng=2.365958580291502}}*/
		private double southWestBoundLat;
		private double southWestBoundLng;
		private double northEastBoundLat;
		private double northEastBoundLng;
		//GeocoderResult{types=[street_address], formattedAddress='76 Rue de Turenne, 75003 Paris, France', addressComponents=[GeocoderAddressComponent{longName='76', shortName='76', types=[street_number]}, GeocoderAddressComponent{longName='Rue de Turenne', shortName='Rue de Turenne', types=[route]}, GeocoderAddressComponent{longName='Paris', shortName='Paris', types=[locality, political]}, GeocoderAddressComponent{longName='Paris', shortName='75', types=[administrative_area_level_2, political]}, GeocoderAddressComponent{longName='Île-de-France', shortName='IDF', types=[administrative_area_level_1, political]}, GeocoderAddressComponent{longName='France', shortName='FR', types=[country, political]}, GeocoderAddressComponent{longName='75003', shortName='75003', types=[postal_code]}], geometry=GeocoderGeometry{location=LatLng{lat=48.86053039999999, lng=2.3646096}, locationType=ROOFTOP, viewport=LatLngBounds{southwest=LatLng{lat=48.8591814197085, lng=2.363260619708498}, northeast=LatLng{lat=48.8618793802915, lng=2.365958580291502}}, bounds=null}, partialMatch=true}
		
		/**
		 * 
		 */
		public Galerie() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param id
		 * @param nomGalerie
		 * @param formattedAdresse
		 * @param loc
		 * @param southWestBoundLat
		 * @param southWestBoundLng
		 * @param northEastBoundLat
		 * @param northEastBoundLng
		 */
		
		public Galerie(Integer id, String nomGalerie,
			String formattedAdresse, double[] loc,
			double southWestBoundLat, double southWestBoundLng,
			double northEastBoundLat, double northEastBoundLng) {
		    super();
		    this.id = id;
		    this.nomGalerie = nomGalerie;
		    this.formattedAdresse = formattedAdresse;
		    this.loc = loc;
		    this.southWestBoundLat = southWestBoundLat;
		    this.southWestBoundLng = southWestBoundLng;
		    this.northEastBoundLat = northEastBoundLat;
		    this.northEastBoundLng = northEastBoundLng;
		}

		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		

		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * @return the nomGalerie
		 */
		public String getNomGalerie() {
			return nomGalerie;
		}

		/**
		 * @param nomGalerie the nomGalerie to set
		 */
		public void setNomGalerie(String nomGalerie) {
			this.nomGalerie = nomGalerie;
		}

		/**
		 * @return the formattedAdresse
		 */
		public String getFormattedAdresse() {
			return formattedAdresse;
		}

		/**
		 * @param formattedAdresse the formattedAdresse to set
		 */
		public void setFormattedAdresse(String formattedAdresse) {
			this.formattedAdresse = formattedAdresse;
		}

		

		public double[] getLoc() {
		    return loc;
		}

		public void setLoc(double[] loc) {
		    this.loc = loc;
		}

		/**
		 * @return the southWestBoundLat
		 */
		public double getSouthWestBoundLat() {
			return southWestBoundLat;
		}

		/**
		 * @param southWestBoundLat the southWestBoundLat to set
		 */
		public void setSouthWestBoundLat(double southWestBoundLat) {
			this.southWestBoundLat = southWestBoundLat;
		}

		/**
		 * @return the southWestBoundLng
		 */
		public double getSouthWestBoundLng() {
			return southWestBoundLng;
		}

		/**
		 * @param southWestBoundLng the southWestBoundLng to set
		 */
		public void setSouthWestBoundLng(double southWestBoundLng) {
			this.southWestBoundLng = southWestBoundLng;
		}

		/**
		 * @return the northEastBoundLat
		 */
		public double getNorthEastBoundLat() {
			return northEastBoundLat;
		}

		/**
		 * @param northEastBoundLat the northEastBoundLat to set
		 */
		public void setNorthEastBoundLat(double northEastBoundLat) {
			this.northEastBoundLat = northEastBoundLat;
		}

		/**
		 * @return the northEastBoundLng
		 */
		public double getNorthEastBoundLng() {
			return northEastBoundLng;
		}

		/**
		 * @param northEastBoundLng the northEastBoundLng to set
		 */
		public void setNorthEastBoundLng(double northEastBoundLng) {
			this.northEastBoundLng = northEastBoundLng;
		}
		
		
		
}
