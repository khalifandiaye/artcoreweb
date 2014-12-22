package fr.afcepf.al22.artcore.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCategorie;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessFormat;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessProduit;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessTva;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.dto.DtoFormat;
import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name="mbModifProduit")
@RequestScoped
public class ModifProduitAdminManagedBean {

	//attributs entrants
		private List<DtoCategorie> listeCategories = new ArrayList<DtoCategorie>();
		private List<DtoFormat> listeFormats = new ArrayList<DtoFormat>();
		/**
		 * C'est la tva par défaut ; c'est ici qu'on la changerait si besoin.
		 */
		private final int variableTva = 1;
		//attributs sortants
		DtoProduit produit = new DtoProduit();
		int intModifCategorie = produit.getCategorie().getIdCategorie();
		int intModifFormat = produit.getFormat().getIdFormat();
		String modifLibelle = produit.getLibelleProduit();
		//ejb
		@EJB
		private IBusinessCategorie buCategorie;
		@EJB
		private IBusinessFormat buFormat;
		@EJB
		private IBusinessProduit buProduit;
		@EJB
		private IBusinessTva buTva;
		
		@ManagedProperty(value="mbCatalogue")
		private CatalogueManagedBean mbCatalogueA;
		
		public int getVariableTva() {
			return variableTva;
		}
		public IBusinessCategorie getBuCategorie() {
			return buCategorie;
		}
		public void setBuCategorie(IBusinessCategorie buCategorie) {
			this.buCategorie = buCategorie;
		}
		public IBusinessFormat getBuFormat() {
			return buFormat;
		}
		public void setBuFormat(IBusinessFormat buFormat) {
			this.buFormat = buFormat;
		}
		public IBusinessProduit getBuProduit() {
			return buProduit;
		}
		public void setBuProduit(IBusinessProduit buProduit) {
			this.buProduit = buProduit;
		}
		public IBusinessTva getBuTva() {
			return buTva;
		}
		public void setBuTva(IBusinessTva buTva) {
			this.buTva = buTva;
		}
		//méthodes
		/**
		 * Méthode ajouter un produit (à la base). NON CODEE ENCORE.
		 * @param prod
		 * @return
		 */
		public String modifierProduit () {
			//TODO à coder la modification de produit
			//Choix de catégorie et de format selon les existants
			produit.setCategorie(buCategorie.categorieParId(intModifCategorie));
			produit.setFormat(buFormat.formatParId(intModifFormat));
			produit.setTva(buTva.tvaParId(variableTva));
			produit.setLibelleProduit(modifLibelle);
//			buProduit.creer(produit);
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
			produit = mbCatalogueA.getProduit();
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
		public int getIntModifCategorie() {
			return intModifCategorie;
		}
		public void setIntModifCategorie(int intModifCategorie) {
			this.intModifCategorie = intModifCategorie;
		}
		public int getIntModifFormat() {
			return intModifFormat;
		}
		public void setIntModifFormat(int intModifFormat) {
			this.intModifFormat = intModifFormat;
		}
		public String getModifLibelle() {
			return modifLibelle;
		}
		public void setModifLibelle(String modifLibelle) {
			this.modifLibelle = modifLibelle;
		}
		public CatalogueManagedBean getMbCatalogueA() {
			return mbCatalogueA;
		}
		public void setMbCatalogueA(CatalogueManagedBean mbCatalogueA) {
			this.mbCatalogueA = mbCatalogueA;
		}
		
	
}
