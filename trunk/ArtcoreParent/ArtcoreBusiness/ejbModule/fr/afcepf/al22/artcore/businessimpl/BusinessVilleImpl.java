/**
 * 
 */
package fr.afcepf.al22.artcore.businessimpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessVille;
import fr.afcepf.al22.artcore.businessinterfaces.IDtoToEntity;
import fr.afcepf.al22.artcore.businessinterfaces.IEntityToDto;
import fr.afcepf.al22.artcore.daointerfaces.IDaoVille;
import fr.afcepf.al22.artcore.dto.DtoVille;
import fr.afcepf.al22.artcore.entities.Ville;

/**
 * @author Ing
 *
 */
@Stateless
public class BusinessVilleImpl implements IBusinessVille {
	
	@EJB
	private IDaoVille dao;
	@EJB
	IEntityToDto classeToDto;
	@EJB
	IDtoToEntity classeToEntity;

	/* (non-Javadoc)
	 * @see fr.afcepf.al22.artcore.businessinterfaces.IBusinessVille#villeParId(int)
	 */
	@Override
	public DtoVille villeParId(int id) {
		Ville v = dao.villeParId(id);
		DtoVille vdto = classeToDto.toDto(v);
		return vdto;
	}

}
