package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoFormat;

@Remote
public interface IBusinessFormat {
	
	/**
	 * Méthode qui retourne une liste de {@link DtoFormat} correspondant aux formats de la base.
	 * @return
	 */
	public List<DtoFormat> listeTousFormats () ;
	
	/**
	 * Méthode qui renvoie un {@link DtoFormat} en fonction de l'id passé en argument.
	 * @param id
	 * @return
	 */
	public DtoFormat formatParId (int id);

}
