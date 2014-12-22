package fr.afcepf.al22.artcore.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.artcore.dto.DtoUtilisateur;

@ManagedBean(name="mbAccueilAdmin")
@SessionScoped
public class AccueilAdminManagedBean {
	
	@ManagedProperty(value="#{mbConnexion.paramUtil}")
	private DtoUtilisateur utilisateur;
	
	public DtoUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(DtoUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}




	
	
	
}
