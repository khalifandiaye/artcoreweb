package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Local;
import javax.ejb.Remote;

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
@Local
public interface IDtoToEntity {
	
	/**
	 * M�thode qui convertit un admin {@link DtoAdmin} en {@link Admin}.
	 * Elle remplit un JPA � partir d'un DTO donn� en argument.
	 * @param dto
	 */
	public Admin toJpa (DtoAdmin dto);
	
	/**
	 * M�thode qui convertit un {@link DtoAdresse} en {@link Adresse}.
//	 * 08/01 : dépréciée ;-)
//	 * Celle avec juste l'adresse est mieux.
	 * @param dto
	 */
	public Adresse toJpa (DtoAdresse dto, DtoClient dtoClient) ;
	
//	/**
//	 * Méthode qui convertit un {@link DtoAdresse} en {@link Adresse}.
//	 * LA SEULE, LA VRAIE !!!
//	 * @return
//	 */
//	public Adresse toJpa (DtoAdresse dto);
	
	/**
	 * M�thode qui convertit un {@link DtoCategorie} en {@link Categorie}.
	 * @param dto
	 */
	public Categorie toJpa (DtoCategorie dto) ;
	
	/**
	 * M�thode qui convertit une {@link DtoCivilite} en {@link Civilite}.
	 * @param dto
	 */
	public Civilite toJpa (DtoCivilite dto) ;
	
	/**
	 * M�thode qui convertit un {@link DtoClient} en {@link Client}.
	 * @param dto
	 */
	public Client toJpa (DtoClient dto) ;
	/**
	 * Méthode qui convertit un {@link DtoClientAdressePK} en un {@link ClientAdressePK}.
	 * @param dto
	 * @return
	 */
	
	public Commande toJpa (DtoCommande dto) ;
	
	/**
	 * M�thode qui convertit une {@link DtoEvaluationProduit} en {@link EvaluationProduit}.
	 * @param dto
	 */
	public EvaluationProduit toJpa (DtoEvaluationProduit dto) ;
	
	/**
	 * M�thode qui convertit une {@link DtoFacture} en {@link Facture}.
	 * @param dto
	 */
	public Facture toJpa (DtoFacture dto);
	
	/**
	 * M�thode qui convertit un {@link DtoFormat} en {@link Format}.
	 * @param dto
	 */
	public Format toJpa (DtoFormat dto) ;
	
	/**
	 * M�thode qui convertit un {@link DtoFournisseur} en {@link Fournisseur}.
	 * @param dto
	 */
	public Fournisseur toJpa (DtoFournisseur dto) ;
	
	/**
	 * M�thode qui convertit une {@link DtoLigneDeCommande} en {@link LigneDeCommande}.
	 * @param dto
	 */
	public LigneDeCommande toJpa (DtoLigneDeCommande dto, DtoCommande dtoCommande) ;
	
	/**
	 * M�thode qui convertit un {@link DtoModeDePaiement} en {@link ModeDePaiement}.
	 * @param dto
	 */
	public ModeDePaiement toJpa (DtoModeDePaiement dto) ;
	
	/**
	 * M�thode qui convertit un {@link DtoPays} en {@link Pays}.
	 * @param dto
	 */
	public Pays toJpa (DtoPays dto) ;
	
	/**
	 * M�thode qui convertit un admin {@link DtoAdmin} en {@link Admin}.
	 * @param dto
	 */
	public Produit toJpa (DtoProduit dto) ;
	
	/**
	 * M�thode qui convertit un {@link DtoProfessionnel} en {@link Professionnel}.
	 * @param dto
	 */
	public Professionnel toJpa (DtoProfessionnel dto) ;
	
	/**
	 * M�thode qui convertit un {@link DtoRole} en {@link Role}.
	 * @param dto
	 */
	public Role toJpa (DtoRole dto) ;
	
	/**
	 * Méthode qui convertit un {@link DtoTheme} en {@link Theme}.
	 * @param dto
	 */
	public Theme toJpa (DtoTheme dto) ;
	
	/**
	 * Méthode qui convertit une {@link DtoTva} en {@link Tva}.
	 * @param dto
	 */
	public Tva toJpa (DtoTva dto) ;
	
	/**
	 * Méthode qui convertit un {@link DtoUtilisateur} en {@link Utilisateur}.
	 * @param dto
	 */
	public Utilisateur toJpa (DtoUtilisateur dto) ;
	
	/**
	 * Méthode qui convertit une {@link DtoVille} en {@link Ville}.
	 * @param dto
	 */
	public Ville toJpa (DtoVille dto) ;

}
