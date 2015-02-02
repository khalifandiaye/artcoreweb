package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessExposition;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.morphia.entity.Exposition;

@ManagedBean(name="mbExposition")
@SessionScoped
public class ExpositionManagedBean {
	private DtoClient dto;
	@EJB
	private IBusinessExposition businessExpo;


	private List<Exposition> exposArtistes;
	private List<Exposition> exposProximites;
	private List<Exposition> allExpos;
	private List<String> nomsCategoriesConsultees= new ArrayList(dto.getSetCategoriesPreferees());
	private List<String> pseudosArtistesConsultes= new ArrayList(dto.getSetArtistesPreferes());
	//private String premiereCategorieConsultee = nomsCategoriesConsultees;
	private List<Exposition> exposCategories=businessExpo.rechercherExposParLibelleCategorie(nomsCategoriesConsultees.get(0));
	public DtoClient getDto() {
		return dto;
	}
	public void setDto(DtoClient dto) {
		this.dto = dto;
	}
	public List<Exposition> getExposCategories() {
		return exposCategories;
	}
	public void setExposCategories(List<Exposition> exposCategories) {
		this.exposCategories = exposCategories;
	}
	public List<Exposition> getExposArtistes() {
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
