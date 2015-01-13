package fr.afcepf.al22.artcore.businessimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessCommande;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.daointerfaces.IDaoCommande;
import fr.afcepf.al22.artcore.daointerfaces.IDaoProduit;
import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoCommande;
import fr.afcepf.al22.artcore.dto.DtoLigneDeCommande;
import fr.afcepf.al22.artcore.dto.DtoModeDePaiement;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.LigneDeCommande;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;
import fr.afcepf.al22.artcore.entities.Produit;

@Stateless
public class BusinessCommandeImpl implements IBusinessCommande {
    private Logger log = Logger.getLogger(this.getClass());
    @EJB
    private IDtoToEntity dtoToEntity;

    @EJB
    private IEntityToDto entityToDto;
    @EJB
    private IDaoProduit daoProduit;

    @EJB
    private IDaoRechercherProduit daoRechPdt;
    @EJB
    private IDaoCommande daoCmd;
    @EJB
    private IDaoAdresse daoAdresse;

    List<BlocProduitDto> panier;

    @PostConstruct
    public void initialise() {
	log.debug("On rentre dans la méthode INITIALISE pour créer un nouveau panier.");
	panier = new ArrayList<BlocProduitDto>();
	log.debug("Le panier contient maintenant " + panier.size()
		+ " éléments.");
    }

    @PreDestroy
    public void clear() {
	log.debug("On rentre dans la méthode CLEAR pour vider le panier.");
	panier = null;
	log.debug("Le panier est maintenant null : " + panier);
    }

    @Override
    public boolean validerCmd(List<BlocProduitDto> panier, int modePaiement,
	    DtoClient dtoClient, DtoAdresse dtoAdresse) {
	boolean retour = true;
	DtoProduit dtoProduit = null;
	DtoCommande dtoCommande = new DtoCommande();
	DtoLigneDeCommande dtoLigneCommande = null;
	Commande cmdCreer = null;

	// creation de la commande
	DtoModeDePaiement mdp2 = entityToDto.toDto(daoCmd
		.rechercherModeDePaiement(modePaiement));
	DtoCommande dtoCmd2 = new DtoCommande();
	dtoCmd2.setClient(dtoClient);
	log.debug("validerCmd dtoAdresse "+dtoAdresse);
	dtoCmd2.setAdresseClient(dtoAdresse.getLibelleAdresse() + " "
		+ dtoAdresse.getVille().getCommune() + " "
		+ dtoAdresse.getPays().getLibellePays());
	dtoCmd2.setModeDePaiement(mdp2);
	dtoCmd2.setDateCommande(new Date());
	dtoCmd2.setNomClient(dtoClient.getCivilite().getLibelleCivilite() + " "
		+ dtoClient.getNomClient() + " " + dtoClient.getPrenomClient());
	dtoCmd2.setVilleClient(dtoAdresse.getVille().getIdVille());
	cmdCreer = daoCmd.creer(dtoToEntity.toJpa(dtoCmd2));
	DtoCommande dtoCmdCreer = entityToDto.toDto(cmdCreer);
	log.debug("la commande à bien ete creee" + dtoCmdCreer.toString());

	for (BlocProduitDto blocProduitDto : panier) {

	    dtoProduit = blocProduitDto.getProduit();
	    dtoProduit.setStock(dtoProduit.getStock()
		    - blocProduitDto.getQuantite());
	    Produit p = dtoToEntity.toJpa(dtoProduit);

	    // modification du stock de produit
	    daoProduit.modifier(p);
	    log.debug("produit modifiee");

	    // creation de la ligne de commande .
	    DtoLigneDeCommande maLigne = new DtoLigneDeCommande();
	    maLigne.setCommande(dtoCmdCreer);
	    maLigne.setProduit(dtoProduit);
	    maLigne.setQuantiteProduit(blocProduitDto.getQuantite());
	    maLigne.setTva(new BigDecimal(19)); // a modifier
	    maLigne.setNumeroLigne(1);

	    // dto Cmd

	    // Faut prendre l'entite commande
	    // qui a persisté dans la base
	    // La réenvoyer ici pour avoir son id
	    // Puis on peut faire notre ajout de ligne de commande

	    log.debug("******dtoCmdCreer.getIdCommande()*******");
	    log.debug(dtoCmdCreer.getIdCommande());
	    log.debug("*************");

	    log.debug(maLigne.toString());
	    log.debug("*************");
	    log.debug("**Id cmd dans maligne****");
	    log.debug(maLigne.getCommande().getIdCommande());
	    log.debug("*************");
	    LigneDeCommande lCmd = dtoToEntity.toJpa(maLigne, dtoCmdCreer);
	    log.debug("juste avant la creation des lignes de commande ");
	    log.debug(entityToDto.toDto(lCmd));

	    log.debug(lCmd.getCommande().getIdCommande());
	    log.debug("*************");
	    daoCmd.creerLc(lCmd);
	}

	return retour;
    }

    /**
     * recherche du prix total de la commande
     * 
     * @return
     */
    @Override
    public BigDecimal prixTotal() {
	BigDecimal prixTotal = new BigDecimal(0);
	if (panier != null && !panier.isEmpty()) {
	    for (BlocProduitDto blocProduitDto : panier) {
		prixTotal = prixTotal.add(blocProduitDto.getPrixTotalParPdt());
	    }
	}
	return prixTotal;
    }

    /**
     * Rechercher tous les mode de paiements.
     * 
     * @return List as ArryaList of {@link DtoModeDePaiement}
     */
    @Override
    public List<DtoModeDePaiement> getModesPaiements() {
	List<DtoModeDePaiement> DtomdpTab = new ArrayList<DtoModeDePaiement>();
	List<ModeDePaiement> mdpTab = daoCmd.rechercherTousModePaiements();
	for (ModeDePaiement modeDePaiement : mdpTab) {
	    DtomdpTab.add(entityToDto.toDto(modeDePaiement));
	}
	return DtomdpTab;
    }

    @Override
    public List<DtoLigneDeCommande> rechercherLignesCommandes() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public DtoAdresse rechercherAdresse(int id) {
	DtoAdresse adr = null;
	adr = entityToDto.toDto(daoAdresse.rechercherAdresse(id));
	return adr;
    }

}
