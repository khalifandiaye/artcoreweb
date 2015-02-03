package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.List;

import fr.afcepf.al22.artcore.entities.Admin;
import fr.afcepf.al22.artcore.entities.Adresse;


/**
 * Classe de simples objets correspondant � l'entit� {@link Adresse}.
 * 
 */
public class DtoAdresse implements Serializable {
	private static final long serialVersionUID = 1L;

	//attributes
	private int idAdresse;

	private String libelleAdresse;
	
	private double latitude;
	
	private double longitude;

	private List<Admin> admins;

	private DtoPays pays;

	private DtoVille ville;

	private List<DtoClient> clients;

	private List<DtoFournisseur> fournisseurs;

	//constructeurs
	public DtoAdresse() {
	}
	
	public DtoAdresse(int idAdresse, DtoPays pays, DtoVille ville,
			String libelleAdresse) {
		super();
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.libelleAdresse = libelleAdresse;

	}
	
	public DtoAdresse(int idAdresse, DtoPays pays, DtoVille ville,
			String libelleAdresse, double latitude, double longitude) {
		super();
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.libelleAdresse = libelleAdresse;
		this.latitude = latitude;
		this.longitude = longitude;

	}
	
	
	//getter setter
	public int getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}
	
	public String getLibelleAdresse() {
		return libelleAdresse;
	}
	public void setLibelleAdresse(String libelleAdresse) {
		this.libelleAdresse = libelleAdresse;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public DtoPays getPays() {
		return pays;
	}

	public void setPays(DtoPays pays) {
		this.pays = pays;
	}

	public DtoVille getVille() {
		return ville;
	}

	public void setVille(DtoVille ville) {
		this.ville = ville;
	}

	public List<DtoClient> getClients() {
		return clients;
	}

	public void setClients(List<DtoClient> clients) {
		this.clients = clients;
	}

	public List<DtoFournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(List<DtoFournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	

}