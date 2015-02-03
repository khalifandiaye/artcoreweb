package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Commande;
import fr.afcepf.al22.artcore.entities.Facture;
import fr.afcepf.al22.artcore.entities.LigneDeCommande;
import fr.afcepf.al22.artcore.entities.ModeDePaiement;

@Remote
public interface IDaoCommande {
	
	/**
	 * methode de creation d'une  commande
	 * @param cmd
	 * @return
	 */
	public Commande creer (Commande cmd);
	
	/**
	 * mehtode de creation d'une nouvelle ligne de commande
	 */
	public LigneDeCommande creerLc (LigneDeCommande ligneCmd);
	
	/**
	 * methode de recherche d 'une commande grace à son id
	 */
	public Commande rechercherCmd(int id);
	
	/**
	 * methode de recherche de la liste de commandes pour une commande donnée
	 */
	public List<LigneDeCommande> rechercherLigneCmd(Commande cmd);
	
	/**
	 * methode de recherche du mode de paiement
	 */
	public ModeDePaiement rechercherModeDePaiement(int id);
	
	/**
	 * fonction de rechercher de facture 
	 * @param id
	 * @return
	 */
	public Facture rechercherFacture(int id);
	
	public List<ModeDePaiement> rechercherTousModePaiements();

}
