package fr.afcepf.al22.artcore.businessinterfaces;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoTva;

@Remote
public interface IBusinessTva {
	
	/**
	 * Méthode qui retourne un {@link DtoTva} en fonction de l'id passé en argument.
	 * @param id
	 * @return
	 */
	public DtoTva tvaParId(int id);

}
