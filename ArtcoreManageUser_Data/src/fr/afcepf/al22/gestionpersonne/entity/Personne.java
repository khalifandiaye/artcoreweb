package fr.afcepf.al22.gestionpersonne.entity;
 
import java.util.Date;

import org.omg.PortableServer.ID_UNIQUENESS_POLICY_ID;
public class Personne {
	private Integer id_client;
	private Integer id_utilisateur;
	private Integer id_civilite;
	private Integer id_professionnel;
	
	private String nom;
	private String prenom;
	private String mail;
	private String tel;
	private Date naissance;
	private Date fin_activite;
	
	public Personne() {
	}

	/**
	 * @param id_client
	 * @param id_utilisateur
	 * @param id_civilite
	 * @param id_professionnel
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param tel
	 * @param naissance
	 * @param fin_activite
	 */
	public Personne(Integer id_client, Integer id_utilisateur,
			Integer id_civilite, Integer id_professionnel, String nom,
			String prenom, String mail, String tel, Date naissance,
			Date fin_activite) {
		super();
		this.id_client = id_client;
		this.id_utilisateur = id_utilisateur;
		this.id_civilite = id_civilite;
		this.id_professionnel = id_professionnel;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.naissance = naissance;
		this.fin_activite = fin_activite;
	}

	public Integer getId_client() {
		return id_client;
	}

	public void setId_client(Integer id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	/**
	 * @return the id_utilisateur
	 */
	public Integer getId_utilisateur() {
		return id_utilisateur;
	}

	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setId_utilisateur(Integer id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	/**
	 * @return the id_civilite
	 */
	public Integer getId_civilite() {
		return id_civilite;
	}

	/**
	 * @param id_civilite the id_civilite to set
	 */
	public void setId_civilite(Integer id_civilite) {
		this.id_civilite = id_civilite;
	}

	/**
	 * @return the id_professionnel
	 */
	public Integer getId_professionnel() {
		return id_professionnel;
	}

	/**
	 * @param id_professionnel the id_professionnel to set
	 */
	public void setId_professionnel(Integer id_professionnel) {
		this.id_professionnel = id_professionnel;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the fin_activite
	 */
	public Date getFin_activite() {
		return fin_activite;
	}

	/**
	 * @param fin_activite the fin_activite to set
	 */
	public void setFin_activite(Date fin_activite) {
		this.fin_activite = fin_activite;
	}
	
	
	
}
