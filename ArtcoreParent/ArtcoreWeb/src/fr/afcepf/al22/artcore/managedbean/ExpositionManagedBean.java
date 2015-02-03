package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessExposition;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.morphia.entity.Exposition;

@ManagedBean(name="mbExposition")
@SessionScoped
public class ExpositionManagedBean {
    private Logger log = Logger.getLogger(getClass());
    @ManagedProperty(value="#{mbConnexion}")
    private ConnexionManagedBean mbConnexion;
	
	@EJB
	private IBusinessExposition businessExpo;


	private List<Exposition> exposArtistes;
	private List<Exposition> exposProximites;
	private List<Exposition> allExpos;
	private List<String> nomsCategoriesConsultees= new ArrayList();
	private List<String> pseudosArtistesConsultes= new ArrayList();
	
		//mbConnexion.getDtoClient().getSetCategoriesPreferees().toArray();
	//private String premiereCategorieConsultee = nomsCategoriesConsultees;
	
//	private List<Exposition> exposCategories=businessExpo.rechercherExposParLibelleCategorie(stringCategorie[0]);
	private List<Exposition> exposCategories = new ArrayList<>();
	
	public ConnexionManagedBean getMbConnexion() {
	    return mbConnexion;
	}
	public void setMbConnexion(ConnexionManagedBean mbConnexion) {
	    this.mbConnexion = mbConnexion;
	}
	public List<Exposition> getExposCategories() {
	    	
	    	 nomsCategoriesConsultees= new ArrayList(mbConnexion.getDtoClient().getSetCategoriesPreferees());
	    	    
	    	    log.debug(nomsCategoriesConsultees);
	    	    System.out.println("+++++++ " + nomsCategoriesConsultees);
	    	exposCategories = businessExpo.rechercherExposParLibelleCategorie(nomsCategoriesConsultees.get(0));
	    	
		return exposCategories;
	}
	public void setExposCategories(List<Exposition> exposCategories) {
		this.exposCategories = exposCategories;
	}
	public List<Exposition> getExposArtistes() {
	    pseudosArtistesConsultes= new ArrayList(mbConnexion.getDtoClient().getSetArtistesPreferes());
    	    
    	    log.debug(pseudosArtistesConsultes);
    	    System.out.println("+++++++ " + pseudosArtistesConsultes);
    	exposArtistes = businessExpo.rechercherExposParLibelleCategorie(pseudosArtistesConsultes.get(0));
		return exposArtistes;
	}
	public void setExposArtistes(List<Exposition> exposArtistes) {
		this.exposArtistes = exposArtistes;
	}
	public List<Exposition> getExposProximites() {
		return exposProximites;
	}
	public void setExposProximites(List<Exposition> exposProximites) {
		this.exposProximites = exposProximites;
	}
	public List<Exposition> getAllExpos() {
		return allExpos;
	}
	public void setAllExpos(List<Exposition> allExpos) {
		this.allExpos = allExpos;
	}

	
}
