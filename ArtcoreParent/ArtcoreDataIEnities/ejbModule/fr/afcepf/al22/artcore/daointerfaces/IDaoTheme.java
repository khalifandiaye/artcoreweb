package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.entities.Theme;

@Remote
public interface IDaoTheme {
	
	/**
	 * Méthode qui prend un int en paramètre 
	 * et qui renvoie le thème qui correspond à cet id.
	 * @param id
	 * @return
	 */
	public Theme themeParId (int id);
	
	/**
	 * Méthode qui renvoie la liste de tous les {@link Theme} de la base.
	 * @return
	 */
	public List<Theme> listeTousThemes () ;

}
