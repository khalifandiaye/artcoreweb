package fr.afcepf.al22.artcore.businessinterfaces;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.BlocProduitDto;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoClient;
import fr.afcepf.al22.artcore.dto.DtoLigneDeCommande;
import fr.afcepf.al22.artcore.dto.DtoModeDePaiement;

@Remote
public interface IBusinessCommande {

	/*
	 * valide la commande : modification des tables 
	 */
	public boolean validerCmd(List<BlocProduitDto> panier,int modePaiement,DtoClient client,DtoAdresse adresse);

	public List<DtoLigneDeCommande> rechercherLignesCommandes();

	public List<DtoModeDePaiement> getModesPaiements();

	public BigDecimal prixTotal();

	public DtoAdresse rechercherAdresse(int id);
}
