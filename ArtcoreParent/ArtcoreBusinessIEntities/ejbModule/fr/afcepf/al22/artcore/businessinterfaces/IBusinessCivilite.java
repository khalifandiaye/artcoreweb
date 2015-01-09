package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;


import fr.afcepf.al22.artcore.dto.DtoCivilite;

@Remote
public interface IBusinessCivilite {
	
	public List<DtoCivilite> listeToutesCivilites () ;
	
	/**
	 * Méthode pour retrouver la civilité par id qui appelle la méthode du dao
	 * sans règle de gestion.
	 * @param id
	 * @return
	 */
	public DtoCivilite civiliteParId(int id);
	
}
