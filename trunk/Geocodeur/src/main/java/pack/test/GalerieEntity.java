package pack.test;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
@Entity("gpsgalerie")
public class GalerieEntity {
		
		@Id
		private Integer id;
		/**nom de la Galerie*/
		private String nomGalerie;
		/**formattedAddress='76 Rue de Turenne, 75003 Paris, France'*/
		private String formattedAdresse;
		/**geometry=GeocoderGeometry{location=LatLng{lat=48.86053039999999, lng=2.3646096}
		 * must contains [lng,lat]*/
		
		@Indexed
		private double[] loc;
		//private double lng;
		/**viewport=LatLngBounds{southwest=LatLng{lat=48.8591814197085, lng=2.363260619708498}, northeast=LatLng{lat=48.8618793802915, lng=2.365958580291502}}*/
		private double southWestBoundLat;
		private double southWestBoundLng;
		private double northEastBoundLat;
		private double northEastBoundLng;
		//GeocoderResult{types=[street_address], formattedAddress='76 Rue de Turenne, 75003 Paris, France', addressComponents=[GeocoderAddressComponent{longName='76', shortName='76', types=[street_number]}, GeocoderAddressComponent{longName='Rue de Turenne', shortName='Rue de Turenne', types=[route]}, GeocoderAddressComponent{longName='Paris', shortName='Paris', types=[locality, political]}, GeocoderAddressComponent{longName='Paris', shortName='75', types=[administrative_area_level_2, political]}, GeocoderAddressComponent{longName='�le-de-France', shortName='IDF', types=[administrative_area_level_1, political]}, GeocoderAddressComponent{longName='France', shortName='FR', types=[country, political]}, GeocoderAddressComponent{longName='75003', shortName='75003', types=[postal_code]}], geometry=GeocoderGeometry{location=LatLng{lat=48.86053039999999, lng=2.3646096}, locationType=ROOFTOP, viewport=LatLngBounds{southwest=LatLng{lat=48.8591814197085, lng=2.363260619708498}, northeast=LatLng{lat=48.8618793802915, lng=2.365958580291502}}, bounds=null}, partialMatch=true}
		
		/**
		 * 
		 */
		public GalerieEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param id
		 * @param nomGalerie
		 * @param formattedAdresse
		 * @param lat
		 * @param lng
		 * @param southWestBoundLat
		 * @param southWestBoundLng
		 * @param northEastBoundLat
		 * @param northEastBoundLng
		 */
		public GalerieEntity(Integer id, String nomGalerie,
				String formattedAdresse, double lat, double lng,
				double southWestBoundLat, double southWestBoundLng,
				double northEastBoundLat, double northEastBoundLng) {
			super();
			this.id = id;
			this.nomGalerie = nomGalerie;
			this.formattedAdresse = formattedAdresse;
			loc = new double[2];
			loc[1] = lat;
			loc[0] = lng;
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

//		/**
//		 * @return the lat
//		 */
//		public double getLat() {
//			return lat;
//		}
//
//		/**
//		 * @param lat the lat to set
//		 */
//		public void setLat(double lat) {
//			this.lat = lat;
//		}
//
//		/**
//		 * @return the lng
//		 */
//		public double getLng() {
//			return lng;
//		}
//
//		/**
//		 * @param lng the lng to set
//		 */
//		public void setLng(double lng) {
//			this.lng = lng;
//		}

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

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("GalerieEntity [id=").append(id)
					.append(", nomGalerie=").append(nomGalerie)
					.append(", formattedAdresse=").append(formattedAdresse)
					.append(", lat=").append(loc[1]).append(", lng=").append(loc[0])
					.append(", southWestBoundLat=").append(southWestBoundLat)
					.append(", southWestBoundLng=").append(southWestBoundLng)
					.append(", northEastBoundLat=").append(northEastBoundLat)
					.append(", northEastBoundLng=").append(northEastBoundLng)
					.append("]");
			return builder.toString();
		}

		/**
		 * @return the loc
		 */
		public double[] getLoc() {
			return loc;
		}

		/**
		 * @param loc the loc to set
		 */
		public void setLoc(double[] loc) {
			this.loc = loc;
		}
		
		
		
}
