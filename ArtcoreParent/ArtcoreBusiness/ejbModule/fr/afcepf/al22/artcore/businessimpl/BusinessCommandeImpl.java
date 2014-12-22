package fr.afcepf.al22.artcore.businessimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
		panier = new ArrayList<BlocProduitDto>();
	}

	@PreDestroy
	public void clear() {
		panier = null;
	}

	@Override
	public boolean validerCmd(List<BlocProduitDto> panier, int modePaiement,DtoClient dtoClient,DtoAdresse dtoAdresse) {
		boolean retour = false;
		DtoProduit dtoProduit = null;
		DtoCommande dtoCommande = new DtoCommande();
		DtoLigneDeCommande dtoLigneCommande = null;
		Commande cmdCreer=null;

		// creation de la commande
		DtoModeDePaiement mdp2=entityToDto.toDto(daoCmd.rechercherModeDePaiement(modePaiement));
		DtoCommande dtoCmd2 =new DtoCommande();
		dtoCmd2.setClient(dtoClient);
		dtoCmd2.setAdresseClient(dtoAdresse.getLibelleAdresse() + " "+dtoAdresse.getVille().getCommune() +" "+ dtoAdresse.getPays().getLibellePays());
		dtoCmd2.setModeDePaiement(mdp2);
		dtoCmd2.setDateCommande(new Date());
		dtoCmd2.setNomClient( dtoClient.getCivilite().getLibelleCivilite()+" " + dtoClient.getNomClient()+" "+ dtoClient.getPrenomClient());
		dtoCmd2.setVilleClient(dtoAdresse.getVille().getIdVille());
		cmdCreer=daoCmd.creer(dtoToEntity.toJpa(dtoCmd2));
		DtoCommande dtoCmdCreer=entityToDto.toDto(cmdCreer);
		System.out.println("la commande à bien ete creee"+ dtoCmdCreer.toString());
		
		for (BlocProduitDto blocProduitDto : panier) {
			
			dtoProduit = blocProduitDto.getProduit();
			dtoProduit.setStock(dtoProduit.getStock()
					- blocProduitDto.getQuantite());
			Produit p = dtoToEntity.toJpa(dtoProduit);
			
			// modification du stock de produit
			daoProduit.modifier(p);
			System.out.println("produit modifiee");
			
			//creation de la ligne de commande .
			DtoLigneDeCommande maLigne=new DtoLigneDeCommande();
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
			
			System.out.println("******dtoCmdCreer.getIdCommande()*******");
			System.out.println(dtoCmdCreer.getIdCommande());
			System.out.println("*************");
			
			
			System.out.println(maLigne.toString());
			System.out.println("*************");
			System.out.println("**Id cmd dans maligne****");
			System.out.println(maLigne.getCommande().getIdCommande());
			System.out.println("*************");
			LigneDeCommande lCmd=dtoToEntity.toJpa(maLigne, dtoCmdCreer);
			System.out.println("juste avant la creation des lignes de commande ");
			System.out.println(entityToDto.toDto(lCmd));

			System.out.println(lCmd.getCommande().getIdCommande());
			System.out.println("*************");
			daoCmd.creerLc(lCmd);
		}
		return retour;
	}

	/**
	 * recherche du prix total de la commande
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
	 *  rechercher tous les mode de paiements 
	 * @return
	 */
	@Override
	public List<DtoModeDePaiement> getModesPaiements(){
				List<DtoModeDePaiement> DtomdpTab= new ArrayList<DtoModeDePaiement>();
				List<ModeDePaiement> mdpTab =daoCmd.rechercherTousModePaiements();
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
		DtoAdresse adr=null;
		adr=entityToDto.toDto(daoAdresse.rechercherAdresse(id));
		return adr;
	}

	
}
