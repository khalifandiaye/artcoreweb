package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCategorie;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCivilite;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessInscription;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPays;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.dto.DtoCivilite;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoProfessionnel;
import fr.afcepf.al22.artcore.dto.DtoRole;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Ville;
import fr.afcepf.al22.artcore.entities.Produit;

@ManagedBean(name="mbInscription")
@SessionScoped

public class InscriptionManagedBean {
	
		private Logger log = Logger.getLogger(this.getClass());

	    
	    
	    private DtoUtilisateur utilisateurBean;
	    private DtoAdresse	adresseBean;
	    private DtoClient clientBean;
	    private DtoProfessionnel proBean;
	    private DtoCivilite civilBean;
	    
	    private List<DtoCivilite> listeCivilites = new ArrayList<DtoCivilite>();
	    private List<DtoPays> listePays = new ArrayList<DtoPays>();
	    private List<Ville> listeVille=new ArrayList<Ville>();
	    
	    @EJB
	    public IBusinessInscription buInscription;  
	    //@EJB
	    //public IDtoToEntity classeToEntity;
	   // @EJB
	   // public IEntityToDto entityToC;
	    @EJB
		public IBusinessCivilite buCivilite;
	    @EJB
		public IBusinessPays buPays;
	    private String login=" ";
	    private String motDePasse=" ";
	    private String motDePasse2;
	    private String libelleAdresse;
	    private String ville;	
	    private String pays;
	    private String nomClient;
	    private String prenomClient;
	    private String telephoneClient;
	    private Date dateNaissance;
	   
	    private int intRechercheCivilite;
	    
	    
	    
	    
	    /* Constructeur */
		public InscriptionManagedBean() {
		
		}
	 
	    
	    
	    
	

	    public DtoUtilisateur creerCompte() {
	    
	    	
	    	/* Creation Utilisateur  ok */
	    	/* Parametres Clients à 4 */ 
	    	DtoRole dtoRole = new DtoRole(4,"client",4);
	    	
	    	utilisateurBean = new DtoUtilisateur(0, dtoRole, login, motDePasse);
	    	log.info("Managed Bean cfreation Utilisateur ");
	    	utilisateurBean = buInscription.creerUtilisateur(utilisateurBean);
	    	
	    	
	    	/* Creation Adresse */
	    	DtoPays dtoPays = new DtoPays(1,"France");
	    	DtoVille dtoVille = new DtoVille(32555,"75005","Paris","PARIS","75105");
	    	adresseBean = new DtoAdresse(0,dtoPays, dtoVille,libelleAdresse);
	    	log.info("Managed Bean creation Adresse");
	    	adresseBean=buInscription.creerAdresse(adresseBean);
	    	
	    	/* Creation Professionnel */
	    	DtoProfessionnel dtoProfessionnel = new DtoProfessionnel();
	    	
	    	proBean=new DtoProfessionnel(0,"123456");
	    	proBean=buInscription.creerPro(proBean);
	    	
	    	
	    	
	    	/* Creation client */
	   
	    	DtoCivilite dtoCivilite = new DtoCivilite(1," ");
	    	DtoClient dtoClient = new DtoClient();
	    	System.out.println("Managed Bean avant Creation Client ligne 2 ");
	    	// cle a zero, fin activite null,date de naissance
	    	clientBean = new DtoClient(0,null,null,dtoCivilite,proBean,utilisateurBean,login,nomClient,prenomClient,telephoneClient) ;
	    	
	    	System.out.println("Managed Bean avant Creation Client ligne 3");
	    	
	    	// Probleme ici//
	   
	    	/* ok  Utilisateur*/
	    	System.out.println("id Utilisateur Enregistre dans le clientBean  "+clientBean.getUtilisateur().getIdUtilisateur());
	       	System.out.println("login    "+clientBean.getUtilisateur().getLogin());
	       	System.out.println("mdp    "+clientBean.getUtilisateur().getMotDePasse());
	       	System.out.println("Role numero  "+clientBean.getUtilisateur().getRole().getIdRole());
	       	System.out.println("Role numero  "+clientBean.getUtilisateur().getRole().getLibelleRole()); 	
	    	/* ok Adresse */
	    	System.out.println("id adresse enregistree "+adresseBean.getIdAdresse());
	    	System.out.println("libelle adresse"+adresseBean.getLibelleAdresse());

	    	System.out.println("Libelle pays "+adresseBean.getPays().getIdPays());
	    	
	    	System.out.println("Libelle pays "+adresseBean.getPays().getLibellePays());
	    	System.out.println("libelle ville"+adresseBean.getVille().getCommune());
	    	/* Client */ 
	    	System.out.println("IdClient "+clientBean.getIdClient());
	    	System.out.println(" Nom "+clientBean.getNomClient());
	    	System.out.println("TElecphone" +clientBean.getTelClient());
	    	System.out.println("Mail" + clientBean.getMailClient());
	    	
	    
	    	System.out.println("Date Naissance"+clientBean.getDateNaissance());
	    	System.out.println("Adresse"+clientBean.getAdresses());
	    	System.out.println("Civilite "+clientBean.getCivilite().getIdCivilite());
	    	
	    	System.out.println("ID PRO"+clientBean.getProfessionnel().getIdProfessionnel());
	  
	    	
	    	//clientBean.setProfessionnel(getProBean().getIdProfessionnel());
	    	
	    	//dtoCmd2.setVilleClient(dtoAdresse.getVille().getIdVille());
 
	    	clientBean = buInscription.creerClient2(clientBean);
	    	//clientBean = buInscription.creerClient(clientBean,adresseBean,proBean,utilisateurBean);
	    
	    	return utilisateurBean;
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	   // public DtoAdresse creerAdresse(){
	    //	DtoPays dtoPays = new DtoPays(1,"France");
	    //DtoVille dtoVille = new DtoVille(32555,"75005","Paris","PARIS","75105");
	    //	adresseBean = new DtoAdresse(0,dtoPays, dtoVille,libelleAdresse);
	   // 	log.info("Managed Bean Ligne 61 on");
	   // 	adresseBean=buInscription.creerAdresse(adresseBean);
	   // 	return adresseBean	;
	   // }

	    //public DtoClient creerClient(){
	    	//DtoClient dtoClient = new DtoClient();
	    	//clientBean = new DtoClient(0,null,dateNaissance,dtoCivilite,null,utilisateurBean,login,nomClient,prenomClient,telephoneClient) ;
	    //	
		//
	    //	log.info("Managed Bean Ligne 53 ");
	   //
	    	 
	
	    //	return clientBean	;
	    //}
	    

	  
	  // public List<DtoPays> getListePays() {
         
	  // listePays = new ArrayList<DtoPays>();
       // listePays = buInscription.listeTousPays();
      // return listePays;
      // }


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

		public Logger getLog() {
			return log;
		}


		public void setLog(Logger log) {
			this.log = log;
		}






		public IBusinessInscription getBuInscription() {
			return buInscription;
		}

		public void setBuInscription(IBusinessInscription buInscription) {
			this.buInscription = buInscription;
		}






		public DtoUtilisateur getUtilisateurBean() {
			return utilisateurBean;
		}






		public void setUtilisateurBean(DtoUtilisateur utilisateurBean) {
			this.utilisateurBean = utilisateurBean;
		}






		public DtoAdresse getAdresseBean() {
			return adresseBean;
		}






		public void setAdresseBean(DtoAdresse adresseBean) {
			this.adresseBean = adresseBean;
		}






		public DtoClient getClientBean() {
			return clientBean;
		}






		public void setClientBean(DtoClient clientBean) {
			this.clientBean = clientBean;
		}






		public String getLogin() {
			return login;
		}






		public void setLogin(String login) {
			this.login = login;
		}






		public String getMotDePasse() {
			return motDePasse;
		}






		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}






		public String getMotDePasse2() {
			return motDePasse2;
		}






		public void setMotDePasse2(String motDePasse2) {
			this.motDePasse2 = motDePasse2;
		}






		public String getLibelleAdresse() {
			return libelleAdresse;
		}






		public void setLibelleAdresse(String libelleAdresse) {
			this.libelleAdresse = libelleAdresse;
		}






		public String getVille() {
			return ville;
		}






		public void setVille(String ville) {
			this.ville = ville;
		}






		public String getPays() {
			return pays;
		}






		public void setPays(String pays) {
			this.pays = pays;
		}






		public String getNomClient() {
			return nomClient;
		}






		public void setNomClient(String nomClient) {
			this.nomClient = nomClient;
		}






		public String getPrenomClient() {
			return prenomClient;
		}






		public void setPrenomClient(String prenomClient) {
			this.prenomClient = prenomClient;
		}






		public String getTelephoneClient() {
			return telephoneClient;
		}






		public void setTelephoneClient(String telephoneClient) {
			this.telephoneClient = telephoneClient;
		}






		public Date getDateNaissance() {
			return dateNaissance;
		}






		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}















		public List<Ville> getListeVille() {
			return listeVille;
		}






		public void setListeVille(List<Ville> listeVille) {
			this.listeVille = listeVille;
		}






		public DtoProfessionnel getProBean() {
			return proBean;
		}






		public void setProBean(DtoProfessionnel proBean) {
			this.proBean = proBean;
		}






		public DtoCivilite getCivilBean() {
			return civilBean;
		}






		public void setCivilBean(DtoCivilite civilBean) {
			this.civilBean = civilBean;
		}






	






		public List<DtoCivilite> getListeCivilites() {
			listeCivilites = new ArrayList<DtoCivilite>();
			listeCivilites = buCivilite.listeToutesCivilites();
			
						
			
			return listeCivilites;
		}






		public void setListeCivilites(List<DtoCivilite> listeCivilites) {
			this.listeCivilites = listeCivilites;
		}






		public int getIntRechercheCivilite() {
			return intRechercheCivilite;
		}






		public void setIntRechercheCivilite(int intRechercheCivilite) {
			this.intRechercheCivilite = intRechercheCivilite;
		}











		public IBusinessCivilite getBuCivilite() {
			return buCivilite;
		}






		public void setBuCivilite(IBusinessCivilite buCivilite) {
			this.buCivilite = buCivilite;
		}






		public List<DtoPays> getListePays() {
			listePays = new ArrayList<DtoPays>();
			listePays = buPays.listeTousPays();
			
						
			
		
			return listePays;
		}






		public void setListePays(List<DtoPays> listePays) {
			this.listePays = listePays;
		}






		public IBusinessPays getBuPays() {
			return buPays;
		}






		public void setBuPays(IBusinessPays buPays) {
			this.buPays = buPays;
		}






	     
	  
	    /* Methode pour creerClient
	     * (creer Util et creerAdresse)
	     */
	  
	    
		
		
	    

	 
	    
	    
	    
	   
}

	     