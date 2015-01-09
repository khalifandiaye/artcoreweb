package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCategorie;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessFormat;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessTva;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.dto.DtoFormat;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name="mbAjoutProduit")
@SessionScoped
public class AjoutProduitAdminManagedBean {
	
	//attributs entrants
	private List<DtoCategorie> listeCategories = new ArrayList<DtoCategorie>();
	private List<DtoFormat> listeFormats = new ArrayList<DtoFormat>();
	/**
	 * C'est la tva par défaut ; c'est ici qu'on la changerait si besoin.
	 */
	int variableTva = 1;
	//attributs sortants
	DtoProduit produit = new DtoProduit();
	int intAjoutCategorie;
	int intAjoutFormat;
	//ejb
	@EJB
	public IBusinessCategorie buCategorie;
	@EJB
	public IBusinessFormat buFormat;
	@EJB
	public IBusinessProduit buProduit;
	@EJB
	public IBusinessTva buTva;
	//méthodes
	/**
	 * Méthode ajouter un produit (à la base). NON CODEE ENCORE.
	 * @param prod
	 * @return
	 */
	public String ajouterProduit () {
		//Choix de catégorie et de format selon les existants
		produit.setCategorie(buCategorie.categorieParId(intAjoutCategorie));
		produit.setFormat(buFormat.formatParId(intAjoutFormat));
		produit.setTva(buTva.tvaParId(variableTva));
		buProduit.creer(produit);
		//Puis on redirige vers le catalogue.
		return "catalogueAdmin.xhtml";
	}
	//getter setter
	public List<DtoCategorie> getListeCategories() {
		listeCategories = new ArrayList<DtoCategorie>();
		listeCategories = buCategorie.listeToutescategories();
		return listeCategories;
	}
	public DtoProduit getProduit() {
		return produit;
	}
	public void setProduit(DtoProduit produit) {
		this.produit = produit;
	}
	public void setListeCategories(List<DtoCategorie> listeCategories) {
		this.listeCategories = listeCategories;
	}
	public List<DtoFormat> getListeFormats() {
		listeFormats = new ArrayList<DtoFormat>();
		listeFormats = buFormat.listeTousFormats();
		return listeFormats;
	}
	public void setListeFormats(List<DtoFormat> listeFormats) {
		this.listeFormats = listeFormats;
	}
	public int getIntAjoutCategorie() {
		return intAjoutCategorie;
	}
	public void setIntAjoutCategorie(int intAjoutCategorie) {
		this.intAjoutCategorie = intAjoutCategorie;
	}
	public int getIntAjoutFormat() {
		return intAjoutFormat;
	}
	public void setIntAjoutFormat(int intAjoutFormat) {
		this.intAjoutFormat = intAjoutFormat;
	}
	
}
