package fr.afcepf.al22.artcore.managedbean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessConnexion;
import fr.afcepf.al22.artcore.dto.DtoAdmin;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;

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
				
			dtoClient = buConnexion.recupererClient(paramUtil);	
				pageForward = "/index.jsf?faces-redirect=true";

			for (int i = 0; i < dtoClient.getAdresses().size() ; i++) {
			
				log.debug(dtoClient.getAdresses().get(i).getLibelleAdresse());
				log.debug(dtoClient.getAdresses().get(i).getVille().getCommune());	
				log.debug(dtoClient.getAdresses().get(i).getVille().getCodePostal());			
				log.debug(dtoClient.getAdresses().get(i).getPays().getLibellePays());
			}

						
			}
			
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
