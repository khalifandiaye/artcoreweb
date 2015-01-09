package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;

import fr.afcepf.al22.artcore.entities.Admin;


/**
 * Classe de simples objets correspondant � l'entit� {@link Admin}.
 * 
 */
public class DtoAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idAdmin;
	private String mailAdmin;
	private String nomAdmin;
	private String prenomAdmin;
	private String telAdmin;
	private DtoAdresse adresse;

	private DtoCivilite civilite;
	private DtoUtilisateur utilisateur;
	public DtoAdmin() {
	}
	public DtoAdmin(int idAdmin, DtoAdresse adresse, DtoCivilite civilite,
			DtoUtilisateur utilisateur, String mailAdmin, String nomAdmin,
			String prenomAdmin, String telAdmin) {
		super();
		this.idAdmin = idAdmin;
		this.adresse = adresse;
		this.civilite = civilite;
		this.utilisateur = utilisateur;
		this.mailAdmin = mailAdmin;
		this.nomAdmin = nomAdmin;
		this.prenomAdmin = prenomAdmin;
		this.telAdmin = telAdmin;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getMailAdmin() {
		return mailAdmin;
	}
	public void setMailAdmin(String mailAdmin) {
		this.mailAdmin = mailAdmin;
	}
	public String getNomAdmin() {
		return nomAdmin;
	}
	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	public String getPrenomAdmin() {
		return prenomAdmin;
	}
	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}
	public String getTelAdmin() {
		return telAdmin;
	}
	public void setTelAdmin(String telAdmin) {
		this.telAdmin = telAdmin;
	}
	public DtoAdresse getAdresse() {
		return adresse;
	}
	public void setAdresse(DtoAdresse adresse) {
		this.adresse = adresse;
	}
	public DtoCivilite getCivilite() {
		return civilite;
	}
	public void setCivilite(DtoCivilite civilite) {
		this.civilite = civilite;
	}
	public DtoUtilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

	

}