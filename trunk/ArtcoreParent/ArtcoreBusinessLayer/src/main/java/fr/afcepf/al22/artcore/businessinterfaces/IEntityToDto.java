package fr.afcepf.al22.artcore.businessinterfaces;

import java.math.BigDecimal;

import javax.ejb.Local;

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
public interface IEntityToDto {
	
	/**
	 * Méthode qui convertit un {@link Admin} en {@link DtoAdmin}.
	 * A partir de ce JPA, elle remplit un objet DTO.
	 * @return
	 */
	public DtoAdmin toDto (Admin admin) ;
	
	/**
	 * M�thode qui convertit un {@link Adresse} en {@link DtoAdresse}.
	 * @return
	 */
	public DtoAdresse toDto (Adresse adresse) ;
	
	/**
	 * M�thode qui convertit une {@link Categorie} en {@link DtoCategorie}.
	 * @return
	 */
	public DtoCategorie toDto (Categorie cat) ;
	
	/**
	 * M�thode qui convertit une {@link Civilite} en {@link DtoCivilite}.
	 * @return
	 */
	public DtoCivilite toDto (Civilite civ) ;
	
	/**
	 * M�thode qui convertit un {@link Client} en {@link DtoClient}.
	 * @return
	 */
	public DtoClient toDto (Client client) ;
	/**
	 * Methode qui convertit un {@link ClientAdressePK} en un {@link DtoClientAdressePK}.
	 * @param cliAdr
	 * @return
	 */
	
	public DtoCommande toDto (Commande com) ;
	
	/**
	 * M�thode qui convertit une {@link EvaluationProduit} en {@link DtoEvaluationProduit}.
	 * @return
	 */
	public DtoEvaluationProduit toDto (EvaluationProduit evalProduit) ;
	
	/**
	 * M�thode qui convertit une {@link Facture} en {@link DtoFacture}.
	 * @return
	 */
	public DtoFacture toDto (Facture facture) ;
	
	/**
	 * M�thode qui convertit un {@link Format} en {@link DtoFormat}.
	 * @return
	 */
	public DtoFormat toDto (Format format) ;
	
	/**
	 * M�thode qui convertit un {@link Fournisseur} en {@link DtoFournisseur}.
	 * @return
	 */
	public DtoFournisseur toDto (Fournisseur f) ;
	
	/**
	 * M�thode qui convertit une {@link LigneDeCommande} en {@link DtoLigneDeCommande}.
	 * @return
	 */
	public DtoLigneDeCommande toDto (LigneDeCommande lc) ;
	
	/**
	 * M�thode qui convertit un {@link ModeDePaiement} en {@link DtoModeDePaiement}.
	 * @return
	 */
	public DtoModeDePaiement toDto (ModeDePaiement mp) ;
	
	/**
	 * M�thode qui convertit un {@link Pays} en {@link DtoPays}.
	 * @return
	 */
	public DtoPays toDto (Pays pays) ;
	
	/**
	 * M�thode qui convertit un {@link Admin} en {@link DtoAdmin}.
	 * @return
	 */
	public DtoProduit toDto (Produit p) ;
	
	/**
	 * M�thode qui convertit un {@link Professionnel} en {@link DtoProfessionnel}.
	 * @return
	 */
	public DtoProfessionnel toDto (Professionnel pro) ;
	
	/**
	 * M�thode qui convertit un {@link Role} en {@link DtoRole}.
	 * @return
	 */
	public DtoRole toDto (Role r) ;
	
	//conversion de JPA vers DTO
	/**
	 * Méthode qui convertit un {@link Theme} en {@link DtoTheme}.
	 * @return
	 */
	public DtoTheme toDto (Theme t) ;
	
	/**
	 * Méthode qui convertit une {@link Tva} en {@link DtoTva}.
	 * @return
	 */
	public DtoTva toDto (Tva tva) ;
	
	/**
	 * Méthode qui convertit un {@link Utilisateur} en {@link DtoUtilisateur}.
	 * @return
	 */
	public DtoUtilisateur toDto (Utilisateur user) ;
	
	/**
	 * Méthode qui convertit une {@link Ville} en {@link DtoVille}.
	 * @return
	 */
	public DtoVille toDto (Ville v) ;

}
