package fr.afcepf.al22.artcore.managedbean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessConnexion;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPays;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessVille;
import fr.afcepf.al22.artcore.dto.DtoAdmin;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Ville;

@ManagedBean(name="mbConnexion")
@SessionScoped
public class ConnexionManagedBean {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private String login ;
	private String password ;
	private DtoUtilisateur paramUtil;
	private String pageForward;
	
	private DtoClient dtoClient;
	private DtoAdmin dtoAdmin;
	

	@EJB
	public IBusinessConnexion buConnexion ;
	
	@EJB
	public IBusinessAdresse buAdresse;
	@EJB
	public IBusinessPays buPays;
	@EJB
	public IBusinessVille buVille;
	
	
	public String getPageForward() {
		return pageForward;
	}


	public void setPageForward(String pageForward) {
		this.pageForward = pageForward;
	}


	public IBusinessConnexion getbuConnexion() {
		return buConnexion;
	}


	public void setbuConnexion(IBusinessConnexion buConnexion) {
		this.buConnexion = buConnexion;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}





	public DtoUtilisateur getParamUtil() {
		return paramUtil;
	}


	public void setParamUtil(DtoUtilisateur paramUtil) {
		this.paramUtil = paramUtil;
	}

	private String messageErreurConnexion;
	public String getMessageErreurConnexion() {
		return messageErreurConnexion;
	}


	public void setMessageErreurConnexion(String messageErreurConnexion) {
		this.messageErreurConnexion = messageErreurConnexion;
	}
	
	public DtoClient getDtoClient() {
		return dtoClient;
	}


	public void setDtoClient(DtoClient dtoClient) {
		this.dtoClient = dtoClient;
	}


	public DtoAdmin getDtoAdmin() {
		return dtoAdmin;
	}


	public void setDtoAdmin(DtoAdmin dtoAdmin) {
		this.dtoAdmin = dtoAdmin;
	}

	
	/*
	_________                                    .__               
	\_   ___ \  ____   ____   ____   ____ ___  __|__| ____   ____  
	/    \  \/ /  _ \ /    \ /    \_/ __ \\  \/  /  |/  _ \ /    \ 
	\     \___(  <_> )   |  \   |  \  ___/ >    <|  (  <_> )   |  \
	 \______  /\____/|___|  /___|  /\___  >__/\_ \__|\____/|___|  /
	        \/            \/     \/     \/      \/              \/ 
	        
	 */
	



	/**
	 * Connexion.
	 * @return une page.
	 */
	public String connexion() {
		log.debug("Login + mdp : " + login +" ..."  + password);
		if (buConnexion.connexion(login, password) == null) {
			messageErreurConnexion="Identifiant ou mot de passe invalide.";
			log.debug("Pas bien");
		}
		else {
			paramUtil = buConnexion.connexion(login, password);
			log.debug("Connection ok");
			
			/*
			 * Ici, suivant le  role, on va sur le Front ou sur le Back Office
			 * 
			 */
			if (paramUtil.getRole().getIdRole() == 1){
				
			
			dtoAdmin = buConnexion.recupererAdmin(paramUtil);	
				
			pageForward = "/accueil.jsf?faces-redirect=true";
			log.info("Admin"+paramUtil.getIdUtilisateur());
			
			
			}
			else if (paramUtil.getRole().getIdRole() == 4){
			log.debug("mbConnexion : je rentre bien dans le else if c'est un client ????????????");
			dtoClient = buConnexion.recupererClient(paramUtil);
			
			//et là je géolocalise ses adresses.
			for (DtoAdresse adr : dtoClient.getAdresses()) {
				log.debug("mbConnexion : on rentre dans ma boucle des adresses");
				log.debug("mbConnexion : adresse : " + adr.getLibelleAdresse());
				log.debug("mbConnexion : latitude : " + adr.getLatitude());
				log.debug("mbConnexion : longitude : " + adr.getLongitude());
				//je vais chercher sa ville
				DtoVille v = adr.getVille();
				log.debug("mbConnexion : ville : " + adr.getVille());
				//je vais chercher son pays
				DtoPays p = adr.getPays();
				log.debug("mbConnexion : pays : " + adr.getPays());
				//et j'appelle am méthode
//				buAdresse.ajouterLatLongALadresse(v, p, adr);
				log.debug("mbConnexion : adresse : " + adr.getLibelleAdresse());
				log.debug("mbConnexion : latitude : " + adr.getLatitude());
				log.debug("mbConnexion : longitude : " + adr.getLongitude());
				log.debug("mbConnexion : on sort de ma boucle des adresses");
				
			}
			
			
				pageForward = "/index.jsf?faces-redirect=true";
				log.debug("mbConnexion : on a fait le forward. ");
			for (int i = 0; i < dtoClient.getAdresses().size() ; i++) {
				log.debug("mbConnexion : on est dans le for ; i = " + i);
				log.debug(dtoClient.getAdresses().get(i).getIdAdresse());
				log.debug(dtoClient.getAdresses().get(i).getLibelleAdresse());
				log.debug(dtoClient.getAdresses().get(i).getVille().getCommune());	
				log.debug(dtoClient.getAdresses().get(i).getVille().getCodePostal());			
				log.debug(dtoClient.getAdresses().get(i).getPays().getLibellePays());
				//et là je géolocalise ses adresses.
					log.debug("mbConnexion : latitude : " + dtoClient.getAdresses().get(i).getLatitude());
					log.debug("mbConnexion : longitude : " + dtoClient.getAdresses().get(i).getLongitude());
					//je vais chercher sa ville
					DtoVille v = dtoClient.getAdresses().get(i).getVille();
					log.debug("mbConnexion : ville : " + dtoClient.getAdresses().get(i).getVille());
					//je vais chercher son pays
					DtoPays p = dtoClient.getAdresses().get(i).getPays();
					log.debug("mbConnexion : pays : " + dtoClient.getAdresses().get(i).getPays());
					//et j'appelle am méthode
					buAdresse.ajouterLatLongALadresse(v, p, dtoClient.getAdresses().get(i));
					log.debug("mbConnexion : adresse : " + dtoClient.getAdresses().get(i).getLibelleAdresse());
					log.debug("mbConnexion : latitude : " + dtoClient.getAdresses().get(i).getLatitude());
					log.debug("mbConnexion : longitude : " + dtoClient.getAdresses().get(i).getLongitude());
					log.debug("mbConnexion : on sort de ma boucle des adresses");
			}
			log.debug("mbConnexion : on est sorti du for");

						
			}
			log.debug("mbConnexion : on est sortis du if.");
			
	}
		log.debug("HELLLLP");
		log.info(paramUtil.getRole().getIdRole());

		log.debug("Je passe a la fin ?");
		return pageForward;
		
		
		
		
	}
	

	public String connexionTest() {
		if (buConnexion.connexion(login, password) == null) {
			messageErreurConnexion="Identifiant ou mot de passe invalide.";
		}
		else {
			paramUtil = buConnexion.connexion(login, password);
			
			}
		pageForward = "/page.xhtml";
		return pageForward;
		
	}
	
	public String deconnexion() {
		setParamUtil(null);
		// Supprime toutes les informations de la session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.jsf?faces-redirect=true";
	}
	
	
}
