/**
 * 
 */
package fr.afcepf.al22.artcore.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoAdresse;
import fr.afcepf.al22.artcore.daointerfaces.IDaoProduit;
import fr.afcepf.al22.artcore.dto.DtoAdresse;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Adresse;
import fr.afcepf.al22.artcore.entities.Pays;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Ing
 *
 */
@Stateless
public class BusinessAdresseImpl implements IBusinessAdresse {
	
	
	
	
	@EJB
	IDaoAdresse dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse#rechercherAdresse(int)
	 */
	@Override
	public Adresse rechercherAdresse(int id) {
		return dao.rechercherAdresse(id);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse#ajouterAdresse(fr.afcepf.al22.artcore.dto.DtoVille, fr.afcepf.al22.artcore.dto.DtoPays, java.lang.String)
	 */
	@Override
	public Adresse ajouterAdresse(DtoVille ville, DtoPays pays, String libelle) {
		Ville v = classeToEntity.toJpa(ville);
		Pays p = classeToEntity.toJpa(pays);
		return dao.ajouterAdresse(v, p, libelle);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse#modifierAdresse(fr.afcepf.al22.artcore.dto.DtoAdresse)
	 */
	@Override
	public Adresse modifierAdresse(DtoAdresse adresse) {
		Adresse adr = classeToEntity.toJpa(adresse, null);
		return dao.modifierAdresse(adr);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.businessinterfaces.IBusinessAdresse#ajouterLatLongALadresse(fr.afcepf.al22.artcore.dto.DtoVille, fr.afcepf.al22.artcore.dto.DtoPays, fr.afcepf.al22.artcore.dto.DtoAdresse)
	 */
	@Override
	public Adresse ajouterLatLongALadresse(DtoVille ville, DtoPays pays,
			DtoAdresse adresse) {
		Ville v = classeToEntity.toJpa(ville);
		Pays p = classeToEntity.toJpa(pays);
		Adresse ad = classeToEntity.toJpa(adresse, null);
		return dao.ajouterLatLongALadresse(v, p, ad);
	}

}
