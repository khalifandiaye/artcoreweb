package fr.afcepf.al22.artcore.conversion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.dto.DtoAdmin;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoCategorie;
import fr.afcepf.al22.artcore.dto.DtoCivilite;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoCommande;
import fr.afcepf.al22.artcore.dto.DtoEvaluationProduit;
import fr.afcepf.al22.artcore.dto.DtoFacture;
import fr.afcepf.al22.artcore.dto.DtoFormat;
import fr.afcepf.al22.artcore.dto.DtoFournisseur;
import fr.afcepf.al22.artcore.dto.DtoLigneDeCommande;
import fr.afcepf.al22.artcore.dto.DtoModeDePaiement;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.dto.DtoProfessionnel;
import fr.afcepf.al22.artcore.dto.DtoRole;
import fr.afcepf.al22.artcore.dto.DtoTheme;
import fr.afcepf.al22.artcore.dto.DtoTva;
import fr.afcepf.al22.artcore.dto.DtoUtilisateur;
import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Admin;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Categorie;
import fr.afcepf.al22.artcore.entities.Civilite;
import fr.afcepf.al22.artcore.entities.Client;
import fr.afcepf.al22.artcore.entities.ClientAdressePK;
import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.EvaluationProduit;
import fr.afcepf.al22.artcore.entities.Facture;
import fr.afcepf.al22.artcore.entities.Format;
import fr.afcepf.al22.artcore.entities.Fournisseur;
import fr.afcepf.al22.artcore.entities.LigneDeCommande;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Professionnel;
import fr.afcepf.al22.artcore.entities.Role;
import fr.afcepf.al22.artcore.entities.Theme;
import fr.afcepf.al22.artcore.entities.Tva;
import fr.afcepf.al22.artcore.entities.Utilisateur;
import fr.afcepf.al22.artcore.entities.Ville;
@Stateless
public class DtoToEntity implements IDtoToEntity {
	private Logger log = Logger.getLogger(this.getClass());
	/**
	 * M�thode qui convertit un admin {@link DtoAdmin} en {@link Admin}.
	 * Elle remplit un JPA � partir d'un DTO donn� en argument.
	 * @param dto
	 */
	@EJB
	private IDaoRechercherProduit daoRechercherProduit;
	public Admin toJpa (DtoAdmin dto) {
		Admin admin = new Admin();
		admin.setIdAdmin(dto.getIdAdmin());
		admin.setAdresse(toJpa(dto.getAdresse()));
		admin.setCivilite(toJpa(dto.getCivilite()));
		admin.setUtilisateur(toJpa(dto.getUtilisateur()));
		admin.setMailAdmin(dto.getMailAdmin());
		admin.setNomAdmin(dto.getNomAdmin());
		admin.setPrenomAdmin(dto.getPrenomAdmin());
		admin.setTelAdmin(dto.getTelAdmin());
		//BeanUtil.copyProperties(admin,dto);
		return admin;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoAdresse} en {@link Adresse}.
	 * @param dto
	 */
	public Adresse toJpa (DtoAdresse dto, DtoClient dtoClient) {
		Adresse a = new Adresse();
		a.setPays(toJpa(dto.getPays()));
		a.setVille(toJpa(dto.getVille()));
		a.setLibelleAdresse(dto.getLibelleAdresse());
		// TODO a.setClientAdresses(................);
		return a;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoCategorie} en {@link Categorie}.
	 * @param dto
	 */
	public Categorie toJpa (DtoCategorie dto) {
		Categorie cat = new Categorie();
		cat.setIdCategorie(dto.getIdCategorie());
		cat.setLibelleCategorie(dto.getLibelleCategorie());
		return cat;
	}
	
	/**
	 * M�thode qui convertit une {@link DtoCivilite} en {@link Civilite}.
	 * @param dto
	 */
	public Civilite toJpa (DtoCivilite dto) {
		Civilite civ = new Civilite();
		civ.setIdCivilite(dto.getIdCivilite());
		civ.setLibelleCivilite(dto.getLibelleCivilite());
		return civ;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoClient} en {@link Client}.
	 * @param dto
	 */
	public Client toJpa (DtoClient dto) {
		log.debug("DtoToEntity : On rentre dans tiJpa de client.");
		log.debug("DtoToEntity : On crée le client.");
		Client c = new Client();
		log.debug("DtoToEntity : On rentre ses données.");
		log.debug("DtoToEntity : On rentre ses données : son id");
		c.setIdClient(dto.getIdClient());
		log.debug("DtoToEntity : On rentre ses données : sa date de fin d'activite");
		c.setDateFinActivite(dto.getDateFinActivite());
		log.debug("DtoToEntity : On rentre ses données : sa date de naissance");
		c.setDateNaissance(dto.getDateNaissance());
		log.debug("DtoToEntity : On rentre ses données : sa civilite");
		c.setCivilite(toJpa(dto.getCivilite()));
		log.debug("DtoToEntity : On rentre ses données : son id professionnel");
//		c.setProfessionnel(toJpa(dto.getProfessionnel()));
		log.debug("DtoToEntity : On rentre ses données : son id utilisateur");
		if (dto.getUtilisateur() != null) {
			c.setUtilisateur(toJpa(dto.getUtilisateur()));
		}
		log.debug("DtoToEntity : On rentre ses données : son mail");
		c.setMailClient(dto.getMailClient());
		log.debug("DtoToEntity : On rentre ses données : son nom");
		c.setNomClient(dto.getNomClient());
		log.debug("DtoToEntity : On rentre ses données : son prenom");
		c.setPrenomClient(dto.getPrenomClient());
		log.debug("DtoToEntity : On rentre ses données : son tel");
		if (dto.getTelClient() != null) {
			c.setTelClient(dto.getTelClient());
		}
		log.debug("DtoToEntity : On sort de tiJpa de client.");
		//TODO faire le lien avec adresse
		return c;
	}
	
	
	
	public Commande toJpa (DtoCommande dto) {
		Commande c = new Commande();
		log.debug( "l id de la ccommande est :"+ dto.getIdCommande()+ " "+ dto.getPrixTotal()+ " "+ dto.getAdresseClient());
		c.setIdCommande(dto.getIdCommande());
		c.setAdresseClient(dto.getAdresseClient());
		c.setDateCommande(dto.getDateCommande());
		c.setDateLivraison(dto.getDateLivraison());
		c.setDateReception(dto.getDateReception());
		c.setFraisEnvoi(dto.getFraisEnvoi());
		c.setClient(toJpa(dto.getClient()));
		c.setModeDePaiement(toJpa(dto.getModeDePaiement()));
		c.setNomClient(dto.getNomClient());
		c.setPrixTotal(dto.getPrixTotal());
		c.setVilleClient(dto.getVilleClient());
		
		//TODO lien avec ligne de commande
		
		return c;
		}
	
	/**
	 * M�thode qui convertit une {@link DtoEvaluationProduit} en {@link EvaluationProduit}.
	 * @param dto
	 */
	public EvaluationProduit toJpa (DtoEvaluationProduit dto) {
		EvaluationProduit eval = new EvaluationProduit();
		eval.setIdEvaluation(dto.getIdEvaluation());
		eval.setCommentaireProduit(dto.getCommentaireProduit());
		eval.setClient(toJpa(dto.getClient()));
		eval.setProduit(toJpa(dto.getProduit()));
		eval.setNoteProduit(dto.getNoteProduit());
		return eval;
	}
	
	/**
	 * M�thode qui convertit une {@link DtoFacture} en {@link Facture}.
	 * @param dto
	 */
	public Facture toJpa (DtoFacture dto) {
		Facture f = new Facture();
		f.setIdFacture(dto.getIdFacture());
		f.setCommande(toJpa(dto.getCommande()));
		return f;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoFormat} en {@link Format}.
	 * @param dto
	 */
	public Format toJpa (DtoFormat dto) {
		Format f = new Format();
		f.setIdFormat(dto.getIdFormat());
		f.setLibelleFormat(dto.getLibelleFormat());
		return f;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoFournisseur} en {@link Fournisseur}.
	 * @param dto
	 */
	public Fournisseur toJpa (DtoFournisseur dto) {
		Fournisseur f = new Fournisseur();
		f.setIdFournisseur(dto.getIdFournisseur());
		f.setDateFinActivite(dto.getDateFinActivite());
		f.setAdresse(toJpa(dto.getAdresse()));
		f.setCivilite(toJpa(dto.getCivilite()));
		f.setProduit(toJpa(dto.getProduit()));
		f.setMailFournisseur(dto.getMailFournisseur());
		f.setNomFournisseur(dto.getNomFournisseur());
		f.setTelFournisseur(dto.getTelFournisseur());
		return f;
	}
	
	/**
	 * M�thode qui convertit une {@link DtoLigneDeCommande} en {@link LigneDeCommande}.
	 * @param dto
	 */
	public LigneDeCommande toJpa (DtoLigneDeCommande dtolc, DtoCommande dtoCommande) {
		LigneDeCommande lc = new LigneDeCommande();
		log.debug("avant ::"+dtolc.toString());
		log.debug("dans toJpa "+ dtoCommande);
		
		//lc.setIdLigneCommande(dto.getIdLigneCommande());
		
		Commande cmd = toJpa(dtoCommande);
		
		// Faire la commande dans la base
		
		log.debug("**************");
		log.debug(cmd.toString()+"  "+ cmd.getIdCommande());
		log.debug("**************");
		
		lc.setCommande(cmd);
		lc.setProduit(toJpa(dtolc.getProduit()));
		lc.setQuantiteProduit(dtolc.getQuantiteProduit());
		lc.setTva(dtolc.getTva());


		return lc;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoModeDePaiement} en {@link ModeDePaiement}.
	 * @param dto
	 */
	public ModeDePaiement toJpa (DtoModeDePaiement dto) {
		ModeDePaiement mp = new ModeDePaiement();
		mp.setIdModePaiement(dto.getIdModePaiement());
		mp.setLibelleModePaiement(dto.getLibelleModePaiement());
		return mp;
	}
	
	/**
	 * M�thode qui convertit un {@link DtoPays} en {@link Pays}.
	 * @param dto
	 */
	public Pays toJpa (DtoPays dto) {
		Pays p = new Pays();
		p.setIdPays(dto.getIdPays());
		p.setLibellePays(dto.getLibellePays());
		return p;
	}
	
	/**
	 * M�thode qui convertit un admin {@link DtoAdmin} en {@link Admin}.
	 * @param dto
	 */
	public Produit toJpa (DtoProduit dto) {
		log.debug("dans la fonction toJPA avec dto=" + dto.toString());
		Produit p = new Produit();
		p.setIdProduit(dto.getIdProduit());
		p.setDateDebutDeVente(dto.getDateDebutDeVente());
		p.setDateFinDeVente(dto.getDateFinDeVente());
		p.setDescriptionProduit(dto.getDescriptionProduit());
		p.setCategorie(toJpa(dto.getCategorie()));
		p.setFormat(toJpa(dto.getFormat()));
		p.setTva(toJpa(dto.getTva()));
		p.setImageProduit(dto.getImageProduit());
		p.setLibelleProduit(dto.getLibelleProduit());
		p.setNomArtiste(dto.getNomArtiste());
		p.setPrixProduit(dto.getPrixProduit());
		p.setStock(dto.getStock());
		//TODO lier les thèmes au produit
		return p;
	}
	/*public Produit toJpa(DtoProduit dto) {
		// dans la methode toJPA
		Produit p = daoRechercherProduit.produitParId(dto.getIdProduit());
		p.setIdProduit(dto.getIdProduit());
		p.setDateDebutDeVente(dto.getDateDebutDeVente());
		p.setDateFinDeVente(dto.getDateFinDeVente());
		p.setDescriptionProduit(dto.getDescriptionProduit());
		p.setIdCategorie(dto.getIdCategorie());
		p.setIdFormat(dto.getIdFormat());
		p.setIdTva(dto.getIdTva());
		p.setImageProduit(dto.getImageProduit());
		p.setLibelleProduit(dto.getLibelleProduit());
		p.setNomArtiste(dto.getNomArtiste());
		p.setPrixProduit(dto.getPrixProduit());
		p.setStock(dto.getStock());
		//TODO lier les thèmes au produit
		return p;
	}*/
	
	/**
	 * M�thode qui convertit un {@link DtoProfessionnel} en {@link Professionnel}.
	 * @param dto
	 */
	public Professionnel toJpa (DtoProfessionnel dto) {
		Professionnel pro = new Professionnel();
		pro.setIdProfessionnel(dto.getIdProfessionnel());
		pro.setNumSiret(dto.getNumSiret());
		return pro;
		}
	
	/**
	 * M�thode qui convertit un {@link DtoRole} en {@link Role}.
	 * @param dto
	 */
	public Role toJpa (DtoRole dto) {
		Role r = new Role();
		r.setIdRole(dto.getIdRole());
		r.setLibelleRole(dto.getLibelleRole());
		r.setNiveauRole(dto.getNiveauRole());
		return r;
		}
	
	/**
	 * Méthode qui convertit un {@link DtoTheme} en {@link Theme}.
	 * @param dto
	 */
	public Theme toJpa (DtoTheme dto) {
		Theme t = new Theme();
		t.setIdTheme(dto.getIdTheme());
		t.setLibelleTheme(dto.getLibelleTheme());
		//TODO faire le lien avec theme
		return t;
		}
	
	/**
	 * Méthode qui convertit une {@link DtoTva} en {@link Tva}.
	 * @param dto
	 */
	public Tva toJpa (DtoTva dto) {
		Tva tva = new Tva();
		tva.setIdTva(dto.getIdTva());
		tva.setTauxTva(dto.getTauxTva());
		return tva;
		}
	
	/**
	 * Méthode qui convertit un {@link DtoUtilisateur} en {@link Utilisateur}.
	 * @param dto
	 */
	public Utilisateur toJpa (DtoUtilisateur dto) {
		Utilisateur user = new Utilisateur();
		user.setIdUtilisateur(dto.getIdUtilisateur());
		user.setRole(toJpa(dto.getRole()));
		user.setLogin(dto.getLogin());
		user.setMotDePasse(dto.getMotDePasse());
		return user;
		}
	
	/**
	 * Méthode qui convertit une {@link DtoVille} en {@link Ville}.
	 * @param dto
	 */
	public Ville toJpa (DtoVille dto) {
		Ville v = new Ville();
		v.setIdVille(dto.getIdVille());
		v.setCodePostal(dto.getCodePostal());
		v.setCommune(dto.getCommune());
		v.setDepartement(dto.getDepartement());
		v.setInsee(dto.getInsee());
		return v;
		}
	
	//TODO recuperer les autres parametres 
	public Adresse toJpa (DtoAdresse dto){
		Adresse adr= new Adresse();
		adr.setIdAdresse(dto.getIdAdresse());
		adr.setLibelleAdresse(dto.getLibelleAdresse());
		adr.setPays(toJpa(dto.getPays()));
		adr.setVille(toJpa(dto.getVille()));
		
		return adr;
	}



}
