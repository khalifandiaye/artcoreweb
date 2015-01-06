package fr.afcepf.al22.artcore.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCommande;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPanier;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoModeDePaiement;

@ManagedBean(name="confirmerCmdManageBean")
@SessionScoped
public class ConfirmerCmdManageBean {
	
	private Logger log= Logger.getLogger(this.getClass());

	@ManagedProperty(value="#{mbConnexion.dtoClient}")
	private DtoClient dtoClient;
	
	@ManagedProperty(value="#{mbPanier.panier}")
	private List<BlocProduitDto> panier;
	// message de confirmation  d'achat.
	private String message;
	
	private List<DtoModeDePaiement> listMdp;
	
	private DtoAdresse adresseChoisie;
	
	//mode de paiement selectionné
	private int mdp =1;
	
	//adresse de livraison choisie
	private int adrLivraison=1;
	
	//Ajout de la carte de paiement
	private String numeroCarteDuClient;
	
	
	@EJB
	private IBusinessPanier gestionPanier;
	
	public int getAdrLivraison() {
		return adrLivraison;
	}

	public void setAdrLivraison(int adrLivraison) {
		this.adrLivraison = adrLivraison;
	}

	public int getMdp() {
		return mdp;
	}

	public void setMdp(int mdp) {
		this.mdp = mdp;
	}

	@EJB
	private IBusinessCommande daoCommande;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IBusinessCommande getDaoCommande() {
		return daoCommande;
	}

	public void setDaoCommande(IBusinessCommande daoCommande) {
		this.daoCommande = daoCommande;
	}

	public List<BlocProduitDto> getPanier() {
		return panier;
	}

	public void setPanier(List<BlocProduitDto> panier) {
		this.panier = panier;
	}

	public DtoClient getDtoClient() {
		return dtoClient;
	}

	public void setDtoClient(DtoClient dtoClient) {
		this.dtoClient = dtoClient;
	}

	
	public List<DtoModeDePaiement> getListMdp() {
		return listMdp;
	}

	public void setListMdp(List<DtoModeDePaiement> listMdp) {
		this.listMdp = listMdp;
	}
	
	public DtoAdresse getAdresseChoisie() {
		return adresseChoisie;
	}

	public void setAdresseChoisie(DtoAdresse adresseChoisie) {
		this.adresseChoisie = adresseChoisie;
	}
	

	public String confirmerCmd(){
		log.debug("confirmation du panier");
		boolean result=false;
		if (mdp > 0) {
			
		result=daoCommande.validerCmd(panier, mdp, dtoClient,daoCommande.rechercherAdresse(adrLivraison));
		}
		else {
			//FIXME Etrange else avec un  syso ? :(
			log.debug("booooooooooooooooooooooooooooooooouh");
		}
		
		if(result){
			message="Felicitation ! votre commande a été validée ";
		}
		
		return "/bravo.jsf?faces-redirect=true";
	}
	
	public String bravo() {
		if(message!=null){
		gestionPanier.viderPanier();
		return "/bravo.jsf?faces-redirect=true";
		}
		return "";
	}
	
	public String connexion() {
		String pageForward="/connexion.jsf?faces-redirect=true";
		return pageForward;
	}

	public String getNumeroCarteDuClient() {
		return numeroCarteDuClient;
	}

	public void setNumeroCarteDuClient(String numeroCarteDuClient) {
		this.numeroCarteDuClient = numeroCarteDuClient;
	}

}
