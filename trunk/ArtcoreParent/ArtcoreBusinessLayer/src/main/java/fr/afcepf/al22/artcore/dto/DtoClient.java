package fr.afcepf.al22.artcore.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.entities.Client;


/**
 * Classe de simples objets correspondant � l'entit� {@link Client}.
 * 
 */
public class DtoClient implements Serializable {
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());

	//attributes
	private int idClient;

	private Date dateFinActivite;
	private Date dateNaissance;
	private String mailClient;
	private String nomClient;
	private String prenomClient;
	private String telClient;
	private List<DtoAdresse> adresses;
	private DtoCivilite civilite;
	private DtoProfessionnel professionnel;
	private DtoUtilisateur utilisateur;
	private List<DtoCommande> commandes;
	private List<DtoEvaluationProduit> evaluationProduits;
	
	
	/**
	 * Rajouts pour big data :
	 */
	private Set<String> setCategoriesPreferees = new HashSet<>();
	private Set<String> setArtistesPreferes = new HashSet<>();
	
	
	//constructeurs
	public DtoClient() {
		log.debug("DtoClient : on rentre dans le constructeur vide du client.");
		
	}
	public DtoClient(int idClient,  
			DtoCivilite civilite, String mailClient, 
			String nomClient, String prenomClient,
			List<DtoAdresse> adresses) {
		super();
		log.debug("DtoClient : on rentre dans le constructeur 2 du client.");
		this.idClient = idClient;
		this.mailClient = mailClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.adresses = adresses;
		this.civilite = civilite;
	}
	public DtoClient(int idClient, Date dateFinActivite, Date dateNaissance,
			DtoCivilite civilite/*, DtoProfessionnel professionnel*/, DtoUtilisateur utilisateur,
			String mailClient, String nomClient, String prenomClient,
			String telClient) {
		super();
		log.debug("DtoClient : on rentre dans le constructeur 3 du client.");
		this.idClient = idClient;
		this.dateFinActivite = dateFinActivite;
		this.dateNaissance = dateNaissance;
		this.civilite = civilite;
//		this.professionnel = professionnel;
		this.utilisateur = utilisateur;
		this.mailClient = mailClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.telClient = telClient;
	}
	
	public DtoClient(int idClient, Date dateFinActivite, Date dateNaissance,
			DtoCivilite civilite/*, DtoProfessionnel professionnel*/, DtoUtilisateur utilisateur,
			String mailClient, String nomClient, String prenomClient,
			String telClient, List<DtoAdresse> adresses) {
		super();
		log.debug("DtoClient : on rentre dans le constructeur 4 du client.");
		this.idClient = idClient;
		this.dateFinActivite = dateFinActivite;
		this.dateNaissance = dateNaissance;
		this.mailClient = mailClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.telClient = telClient;
		this.adresses = adresses;
		this.civilite = civilite;
//		this.professionnel = professionnel;
		this.utilisateur = utilisateur;
	}
	
	//getter setter
	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getDateFinActivite() {
		return this.dateFinActivite;
	}

	public void setDateFinActivite(Date dateFinActivite) {
		this.dateFinActivite = dateFinActivite;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getMailClient() {
		return this.mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public String getTelClient() {
		return this.telClient;
	}

	public void setTelClient(String telClient) {
		this.telClient = telClient;
	}
	public List<DtoAdresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<DtoAdresse> adresses) {
		this.adresses = adresses;
	}
	public DtoCivilite getCivilite() {
		return civilite;
	}
	public void setCivilite(DtoCivilite civilite) {
		this.civilite = civilite;
	}
	public DtoProfessionnel getProfessionnel() {
		return professionnel;
	}
	public void setProfessionnel(DtoProfessionnel professionnel) {
		this.professionnel = professionnel;
	}
	public DtoUtilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<DtoCommande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<DtoCommande> commandes) {
		this.commandes = commandes;
	}
	public List<DtoEvaluationProduit> getEvaluationProduits() {
		return evaluationProduits;
	}
	public void setEvaluationProduits(List<DtoEvaluationProduit> evaluationProduits) {
		this.evaluationProduits = evaluationProduits;
	}
	public Set<String> getSetCategoriesPreferees() {
		return setCategoriesPreferees;
	}
	public void setSetCategoriesPreferees(Set<String> setCategoriesPreferees) {
		this.setCategoriesPreferees = setCategoriesPreferees;
	}
	public Set<String> getSetArtistesPreferes() {
		return setArtistesPreferes;
	}
	public void setSetArtistesPreferes(Set<String> setArtistesPreferes) {
		this.setArtistesPreferes = setArtistesPreferes;
	}
	

}