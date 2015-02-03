package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoTheme;

@Remote
public interface IBusinessTheme {
	
	/**
	 * Méthode qui retourne la liste de tous les {@link Theme} de la base.
	 * @return
	 */
	public List<DtoTheme> listeTousThemes ();

}
