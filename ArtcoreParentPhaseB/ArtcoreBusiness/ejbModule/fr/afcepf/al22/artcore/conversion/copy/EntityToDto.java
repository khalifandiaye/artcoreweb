/*package fr.afcepf.al22.artcore.conversion.copy;

import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
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
public class EntityToDto implements IEntityToDto {
	
	/**
	 * Méthode qui convertit un {@link Admin} en {@link DtoAdmin}.
	 * A partir de ce JPA, elle remplit un objet DTO.
	 * @return
	 
	public DtoAdmin toDto (Admin admin) {
		DtoAdmin dto = new DtoAdmin(
				admin.getIdAdmin(), 
				toDto(admin.getAdresse() ), 
				toDto( admin.getCivilite()), 
				toDto(admin.getUtilisateur() ), 
				admin.getMailAdmin(), 
				admin.getNomAdmin(), 
				admin.getPrenomAdmin(), 
				admin.getTelAdmin());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Adresse} en {@link DtoAdresse}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoAdresse toDto (Adresse adresse) {
		DtoAdresse dto = new DtoAdresse(
				adresse.getIdAdresse(),
				toDto( adresse.getPays()),
				toDto(adresse.getVille()),
				adresse.getLibelleAdresse());
//				adresse.getClientAdresses();
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link Categorie} en {@link DtoCategorie}.
	 * @return
	 *//*
	public DtoCategorie toDto (Categorie cat) {
		DtoCategorie dto = new DtoCategorie(
				cat.getIdCategorie(),
				cat.getLibelleCategorie());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link Civilite} en {@link DtoCivilite}.
	 * @return
	 *//*
	public DtoCivilite toDto (Civilite civ) {
		DtoCivilite dto = new DtoCivilite(
				civ.getIdCivilite(),
				civ.getLibelleCivilite());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Client} en {@link DtoClient}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoClient toDto (Client client) {
		DtoClient dto = new DtoClient(
				client.getIdClient(),
				client.getDateFinActivite(),
				client.getDateNaissance(),
				toDto(client.getCivilite()), 
				toDto(client.getProfessionnel()),
				toDto(client.getUtilisateur()),
				client.getMailClient(),
				client.getNomClient(),
				client.getPrenomClient(),
				client.getTelClient());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link Commande} en {@link DtoCommande}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoCommande toDto (Commande com) {
		DtoCommande dto = new DtoCommande(
				com.getIdCommande(),
				com.getAdresseClient(),
				com.getDateCommande(),
				com.getDateLivraison(),
				com.getDateReception(),
				com.getFraisEnvoi(),
				toDto(com.getClient() ),
				toDto(com.getModeDePaiement()),
				com.getNomClient(),
				com.getPrixTotal(),
				com.getVilleClient());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link EvaluationProduit} en {@link DtoEvaluationProduit}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoEvaluationProduit toDto (EvaluationProduit evalProduit) {
		DtoEvaluationProduit dto = new DtoEvaluationProduit(
				evalProduit.getIdEvaluation(),
				evalProduit.getCommentaireProduit(),
				toDto(evalProduit.getClient()),
				toDto(evalProduit.getProduit()),
				evalProduit.getNoteProduit());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link Facture} en {@link DtoFacture}.
	 * @return
	 *//*
	public DtoFacture toDto (Facture facture) {
		DtoFacture dto = new DtoFacture(
				facture.getIdFacture(),
				toDto(facture.getCommande()));
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Format} en {@link DtoFormat}.
	 * @return
	 *//*
	public DtoFormat toDto (Format format) {
		DtoFormat dto = new DtoFormat(
				format.getIdFormat(),
				format.getLibelleFormat());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Fournisseur} en {@link DtoFournisseur}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoFournisseur toDto (Fournisseur f) {
		DtoFournisseur dto = new DtoFournisseur(
				f.getIdFournisseur(),
				f.getDateFinActivite(),
				toDto(f.getAdresse()),
				toDto(f.getCivilite()),
				toDto(f.getProduit()),
				f.getMailFournisseur(),
				f.getNomFournisseur(),
				f.getTelFournisseur());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit une {@link LigneDeCommande} en {@link DtoLigneDeCommande}.
	 * @return
	 *//*
	
	public DtoLigneDeCommande toDto (LigneDeCommande lc,Commande commande) {
		DtoLigneDeCommande dto = new DtoLigneDeCommande(
				lc.getIdLigneCommande(),
				toDto(lc.getProduit()),
				lc.getQuantiteProduit(),
				lc.getTva(),
				toDto(commande)
				);
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link ModeDePaiement} en {@link DtoModeDePaiement}.
	 * @return
	 *//*
	public DtoModeDePaiement toDto (ModeDePaiement mp) {
		DtoModeDePaiement dto = new DtoModeDePaiement(
				mp.getIdModePaiement(),
				mp.getLibelleModePaiement());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Pays} en {@link DtoPays}.
	 * @return
	 *//*
	public DtoPays toDto (Pays pays) {
		DtoPays dto = new DtoPays(
				pays.getIdPays(),
				pays.getLibellePays());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Admin} en {@link DtoAdmin}.
	 * @return
	 *//*
	//TODO recuperer les autres tableaux
	public DtoProduit toDto (Produit p) {
		DtoProduit dto = new DtoProduit(
				p.getIdProduit(),
				p.getDateDebutDeVente(),
				p.getDateFinDeVente(),
				p.getDescriptionProduit(),
				toDto(p.getCategorie()),
				toDto(p.getFormat()),
				toDto(p.getTva()),
				p.getImageProduit(),
				p.getLibelleProduit(),
				p.getNomArtiste(),
				p.getPrixProduit(),
				p.getStock());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Professionnel} en {@link DtoProfessionnel}.
	 * @return
	 *//*
	public DtoProfessionnel toDto (Professionnel pro) {
		DtoProfessionnel dto = new DtoProfessionnel(
				pro.getIdProfessionnel(),
				pro.getNumSiret());
		return dto;
	}
	
	*//**
	 * M�thode qui convertit un {@link Role} en {@link DtoRole}.
	 * @return
	 *//*
	public DtoRole toDto (Role r) {
		DtoRole dto = new DtoRole(
				r.getIdRole(),
				r.getLibelleRole(),
				r.getNiveauRole());
		return dto;
	}
	
	//conversion de JPA vers DTO
	*//**
	 * Méthode qui convertit un {@link Theme} en {@link DtoTheme}.
	 * @return
	 *//*
	public DtoTheme toDto (Theme t) {
		DtoTheme dto = new DtoTheme(
				t.getIdTheme(),
				t.getLibelleTheme());
		return dto;
	}
	
	*//**
	 * Méthode qui convertit une {@link Tva} en {@link DtoTva}.
	 * @return
	 *//*
	public DtoTva toDto (Tva tva) {
		DtoTva dto = new DtoTva(
				tva.getIdTva(),
				tva.getTauxTva());
		return dto;
	}
	
	*//**
	 * Méthode qui convertit un {@link Utilisateur} en {@link DtoUtilisateur}.
	 * @return
	 *//*
	public DtoUtilisateur toDto (Utilisateur user) {
		DtoUtilisateur dto = new DtoUtilisateur(
				user.getIdUtilisateur(),
				toDto(user.getRole()),
				user.getLogin(),
				user.getMotDePasse());
		return dto;
	}
	
	*//**
	 * Méthode qui convertit une {@link Ville} en {@link DtoVille}.
	 * @return
	 *//*
	public DtoVille toDto (Ville v) {
		DtoVille dto = new DtoVille(
				v.getIdVille(),
				v.getCodePostal(),
				v.getCommune(),
				v.getDepartement(),
				v.getInsee());
		return dto;
	}

}
*/