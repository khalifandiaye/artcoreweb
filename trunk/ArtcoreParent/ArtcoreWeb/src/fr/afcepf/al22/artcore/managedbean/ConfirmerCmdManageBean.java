package fr.afcepf.al22.artcore.managedbean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.BindingProvider;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCommande;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessPanier;
import fr.afcepf.al22.artcore.businessinterfaces.IBusinessRechercherProduit;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoModeDePaiement;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.orchestration.impl.IVerifCommande;
import fr.afcepf.al22.orchestration.impl.VerifCommandeImplService;
import fr.afcepf.al22.orchestration.interfaces.CheckResultProduitCommande;
import fr.afcepf.al22.orchestration.interfaces.ProduitCommande;

@ManagedBean(name="mbConfirmerCmd")
@SessionScoped
public class ConfirmerCmdManageBean {
    /** Define Jboss logger.*/
    private Logger log= Logger.getLogger(this.getClass());

    @ManagedProperty(value="#{mbPanier}")
    private PanierManagedBean mbpanier;
    @ManagedProperty(value="#{mbConnexion}")
    private ConnexionManagedBean cnxmb;

    @ManagedProperty(value="#{mbPanier.panier}")
    private List<BlocProduitDto> panier;

    /**
     * AJOUTS POUR LE BIG DATA
     */
    @ManagedProperty(value="#{mbConnexion}")
    private ConnexionManagedBean mbConnexion;

    /**Liste des erreur de stock par produit */
    private List<String> msgErreurStock = new ArrayList<String>();

    /** message de confirmation  d'achat.*/
    private String message;

    private List<DtoModeDePaiement> listMdp;

    private DtoAdresse adresseChoisie;

    /**mode de paiement selectionné. */
    private int mdp =1;

    /** adresse de livraison choisie. */
    private int adrLivraison=1;

    /**Ajout de la carte de paiement. */
    private String numeroCarteDuClient;


    @EJB
    private IBusinessPanier gestionPanier;

    @EJB
    private IBusinessCommande daoCommande;

    @EJB
    private IBusinessRechercherProduit daoRechercheProduit;
    private ResourceBundle rb;
    private String url="10.0.0.10";



    /**
     * Ajout méthodes pour le bid data
     */

    /**
     * Méthode qui est appelée par 
     * {@link public void recupeCategosEtProduitsCibles ()}.
     * Méthode qui récupère la catégorie du produit dès que le client 
     * regarde le détail de ce produit ou met le produit dans son panier.
     * @return le set des libelles de la categorie consultée.
     * ATTENTION A N'UTILISER CETTE METHODE QUE SI LE CLIENT EST CONNECTE.
     * TODO appeler ces deux méthodes à chaque appel du detail de produit
     * TODO ou d'ajout du panier.
     */
    public Set<String> recupCategoriesCibles (Set<String> listeCategories, DtoProduit p) {
	listeCategories.add(p.getCategorie().getLibelleCategorie());
	return listeCategories;
    }

    /**
     * Méthode qui est appelée par 
     * {@link public void recupeCategosEtProduitsCibles ()}.
     * Méthode qui récupère l'artiste du produit dès que le client 
     * regarde le détail de ce produit ou met le produit dans son panier.
     * @return le set du nom d'artiste consulté.
     * ATTENTION A N'UTILISER CETTE METHODE QUE SI LE CLIENT EST CONNECTE.
     */
    public Set<String> recupArtistesCibles (Set<String> listeProduits, DtoProduit p) {
	listeProduits.add(p.getNomArtiste());
	return listeProduits;
    }

    /**
     * Méthode finale qui renplit les set du client connecté en appelant les deux méthodes
     * {@link public Set<String> recupCategoriesCibles (Set<String> listeCategories, DtoProduit p)}
     * et 
     * {@link public Set<String> recupArtistesCibles (Set<String> listeProduits, DtoProduit p) }
     */
    public void recupeCategosEtProduitsCibles (DtoProduit produit) {
	if (mbConnexion.getDtoClient() != null) {
	    //ajout de la categorie du produit dans la set.
	    Set<String> setCatego = mbConnexion.getDtoClient().getSetCategoriesPreferees();
	    setCatego = recupCategoriesCibles(setCatego, produit);
	    mbConnexion.getDtoClient().setSetCategoriesPreferees(setCatego);
	    log.debug("mbCatalogue : Fin de l'ajout de la catégorie.");
	    //ajout du nom d'artiste dans la set.
	    Set<String> setArtiste = mbConnexion.getDtoClient().getSetArtistesPreferes();
	    setArtiste = recupArtistesCibles(setArtiste, produit);
	    mbConnexion.getDtoClient().setSetArtistesPreferes(setArtiste);
	    log.debug("mbCatalogue : Fin de l'ajout de l'artiste.");
	}
    }

    /**
     * Méthode qui prend un produit spécial du panier et qui remplit la set de la categorie et de l'artiste.
     * @param blocProduit
     */
    public void remplirSetDesProduitsPanierAvantConnexion (BlocProduitDto blocProduit){
	log.debug("mbCommande : On est passé dans la méthode pour remplir les sets");
	recupeCategosEtProduitsCibles(blocProduit.getProduit());
	for (String string : mbConnexion.getDtoClient().getSetCategoriesPreferees()) {
	    log.debug("mbCommande : Set catego du client après confirmation commande : " + string);
	}
	for (String string : mbConnexion.getDtoClient().getSetArtistesPreferes()) {
	    log.debug("mbCommande : Set artiste du client après confirmation commande : " + string);
	}
    }




    /**Convertion d'un blocProduit (Produit.getIdProduit, Quantite) vers ProduitCommande.
     * @param paramBlocProduit 
     * @return Le ProduitCommande creer.
     */
    private ProduitCommande convertPanierProduitCommande(BlocProduitDto paramBlocProduit) {
	ProduitCommande retour = new ProduitCommande();
	log.debug("convert blocProduit "+paramBlocProduit.getProduit().getDescriptionProduit());
	retour.setIdProduit(paramBlocProduit.getProduit().getIdProduit());
	log.debug("convert blocProduit quantite "+paramBlocProduit.getQuantite());
	retour.setQuantiteCommande(paramBlocProduit.getQuantite());
	return retour;
    }


    /**Appel les webService pour verifier la commande.
     * @return
     */
    public String validerCmd() {
	//Pour gerer l'adresse IP des WebServices
	try {
	    rb = ResourceBundle.getBundle("db");
	}catch(MissingResourceException e) {
	    log.debug("Impossible de trouver le fichier db.properties "+e.getMessage());
	}
	if (rb==null) {
	    url="127.0.0.1:9090";
	}else {
	    url = rb.getString("url");
	}
	log.debug("URL WSOrchestration : "+url);
	//		//méthodes
	this.msgErreurStock = null;
	msgErreurStock = new ArrayList<String>();
	//Pour gerer la date de naissance de l'utilsateur
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String dateNaissance;
	message="";
	log.debug("Message = "+message+" de taille "+message.length());
	boolean bquantite = true;
	log.debug("valideCmd avec en panier "+panier.size());
	log.debug("Init WebService");

	/* Ancienne Version localhost uniquement 
	 *  VerifCommandeImplService verifWS = new VerifCommandeImplService();
	    		CheckResultProduitCommande validation = verifWS.getVerifCommandeImplPort().verifCommande(cnxmb.getDtoClient().getNomClient(),
	    cnxmb.getDtoClient().getPrenomClient(),dateNaissance ,numeroCarteDuClient, listeProduit);
	 */
	//Generation proxy
	VerifCommandeImplService verifWS = new VerifCommandeImplService();
	//Recuperation du port WebServices.
	IVerifCommande portVerifCommande = verifWS.getVerifCommandeImplPort();
	//on recupere le BindingProvider pour changer l'url du ws
	BindingProvider bindingProvider = (BindingProvider) portVerifCommande;
	
	log.debug("WS bind adresse : "+"http://"+url+"/WSOrchestrator/VerifCommandeImpl");
	//populate BindingProvider
	bindingProvider.getRequestContext().put(
		BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
		"http://"+url+"/WSOrchestrator/VerifCommandeImpl");
	
	////192.168.100.129
	//	CheckResultProduitCommande validation = port.verifCommande(mbCnx
	//		.getDtoClient().getNomClient(), mbCnx.getDtoClient()
	//		.getPrenomClient(), dateNaissance, numeroCarteDuClient,
	//		listeProduit);
	//
	//	log.debug("Retour Appel WS Validation commande *******************");
	//	log.debug("Validation alertePolice " + validation.getAlertePolice() + "!");
	//	log.debug("validation AlertCB " + validation.isAlerteCB());
	//	log.debug("validation listeProduits " + validation.getListeProduits());
	//	log.debug("***************************************");
	//
	//	log.debug("verif alerte police");
	//	if (!"".equalsIgnoreCase(validation.getAlertePolice())) {
	//	    this.message = "Vous n'êtes pas autorisés car vous êtes fichés par la police pour "
	//		    + validation.getAlertePolice();
	//	    log.debug("police msg " + this.message);
	//	}
	List listeProduit = new ArrayList<ProduitCommande>();
	log.debug("on convertit le panier");
	for (BlocProduitDto blocProduitDto :this.mbpanier.getPanier()) {
	    remplirSetDesProduitsPanierAvantConnexion(blocProduitDto);
	    listeProduit.add(convertPanierProduitCommande(blocProduitDto));
	}

	dateNaissance = sdf.format(cnxmb.getDtoClient().getDateNaissance());
	log.debug("On appel le WebService Orchestration ");
	log.debug("nom "+cnxmb.getDtoClient().getPrenomClient()+" prenom "+cnxmb.getDtoClient().getPrenomClient());
	log.debug(" date "+dateNaissance+" numCarte "+numeroCarteDuClient);
	
	CheckResultProduitCommande validation = portVerifCommande.verifCommande(cnxmb.getDtoClient().getNomClient(),
		cnxmb.getDtoClient().getPrenomClient(),dateNaissance ,
		numeroCarteDuClient, listeProduit);
/*	CheckResultProduitCommande validation = verifWS.getVerifCommandeImplPort().verifCommande(cnxmb.getDtoClient().getNomClient(),
		cnxmb.getDtoClient().getPrenomClient(),dateNaissance ,
		numeroCarteDuClient, listeProduit);
*/
	log.debug("Retour Appel WS Validation commande *******************");
	log.debug("Validation alertePolice "+validation.getAlertePolice()+"!");
	log.debug("validation AlertCB "+validation.isAlerteCB());
	log.debug("validation listeProduits "+validation.getListeProduits());
	log.debug("***************************************");

	log.debug("verif alerte police");
	if (!"".equalsIgnoreCase(validation.getAlertePolice())) {
	    this.message = "Vous n'ête pas authorisé car vous fiche par la police pour "+validation.getAlertePolice();
	    log.debug("police msg "+this.message);
	}
	if (validation.isAlerteCB()) {
	    message=" Carte de paiement invalide !!!";
	    log.debug("isAlerteCB msg "+message);
	}
	if (!message.isEmpty()) {
	    log.debug("message.isEmpty "+message);
	    return "/bravo.jsf?faces-redirect=true";
	}

	//Dans tous les autres cas
	log.debug("*************************List Produits*******************");
	log.debug("list produits size "+validation.getListeProduits().size());
	for (ProduitCommande p : validation.getListeProduits()) {
	    DtoProduit dto;
	    log.debug("p.getQuantiteCommande = "+p.getQuantiteCommande());
	    if (p.getQuantiteCommande()<0) {
		log.debug("Produit manque stock "+p.getIdProduit()+" "+p.getQuantiteCommande());
		message="Produit manquant "+p.getIdProduit()+" "+p.getQuantiteCommande();
		dto = daoRechercheProduit.produitParId(p.getIdProduit());
		this.msgErreurStock.add("Il manque "+Math.abs(p.getQuantiteCommande())+" pour le produit "+dto.getLibelleProduit()+".");
		log.debug("message added : "+"Il manque "+Math.abs(p.getQuantiteCommande())+" pour le produit "+dto.getLibelleProduit()+".");
		bquantite = false;
	    }	
	}
	if (!bquantite) {
	    log.debug("message "+message);
	    return "/afficherPanier.jsf?faces-redirect=true";
	}
	return "";
    }

    /**Valide la commande via WebService l'appel methode {{@link #validerCmd()} puis enregistre la commande en base via DAO
     * @return
     */
    public String confirmerCmd(){
	boolean result=true;

	String redirection = validerCmd();
	if (!redirection.equals("")) {
	    return redirection;
	}


	log.debug("confirmation du panier");

	if (mdp > 0) {
	    result=daoCommande.validerCmd(panier, mdp, cnxmb.getDtoClient(),daoCommande.rechercherAdresse(adrLivraison));
	    log.debug("retour du dao result = "+result);
	    if (result) {
		mbpanier.reinitPanier();
		message="Felicitation ! votre commande a été validée ";
		log.debug("message ="+message);
		redirection = "/bravo.jsf?faces-redirect=true";
	    } else {
		message="Une erreure est survenue pendant la création de votre commande ! ";
		log.debug("message "+message);
		redirection = "/afficherPanier.jsf?faces-redirect=true";
	    }
	}

	log.debug("message "+message);
	return redirection; 
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


    //getter setter
    public String getNumeroCarteDuClient() {
	return numeroCarteDuClient;
    }

    public void setNumeroCarteDuClient(String numeroCarteDuClient) {
	this.numeroCarteDuClient = numeroCarteDuClient;
    }

    public PanierManagedBean getMbpanier() {
	return mbpanier;
    }

    public void setMbpanier(PanierManagedBean mbpanier) {
	this.mbpanier = mbpanier;
    }

    /**
     * @return the msgErreurStock
     */
    public List<String> getMsgErreurStock() {
	return msgErreurStock;
    }

    /**
     * @param msgErreurStock the msgErreurStock to set
     */
    public void setMsgErreurStock(List<String> msgErreurStock) {
	this.msgErreurStock = msgErreurStock;
    }
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
    /**
     * @return the daoRechercheProduit
     */
    public IBusinessRechercherProduit getDaoRechercheProduit() {
	return daoRechercheProduit;
    }

    /**
     * @param daoRechercheProduit the daoRechercheProduit to set
     */
    public void setDaoRechercheProduit(
	    IBusinessRechercherProduit daoRechercheProduit) {
	this.daoRechercheProduit = daoRechercheProduit;
    }

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

    public ConnexionManagedBean getCnxmb() {
	return cnxmb;
    }

    public void setCnxmb(ConnexionManagedBean cnxmb) {
	this.cnxmb = cnxmb;
    }

    public List<BlocProduitDto> getPanier() {
	return panier;
    }

    public void setPanier(List<BlocProduitDto> panier) {
	this.panier = panier;
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
    public ConnexionManagedBean getMbConnexion() {
	return mbConnexion;
    }
    public void setMbConnexion(ConnexionManagedBean mbConnexion) {
	this.mbConnexion = mbConnexion;
    }

}
