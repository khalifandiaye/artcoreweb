package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;


import fr.afcepf.al22.artcore.dto.DtoCivilite;

@Remote
public interface IBusinessCivilite {
	
	public List<DtoCivilite> listeToutesCivilites () ;
	
}
