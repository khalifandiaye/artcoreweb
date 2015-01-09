package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al22.artcore.dto.DtoPays;

@Remote
public interface IBusinessPays {
	
	public List<DtoPays> listeTousPays () ;
	public DtoPays paysParId(int id) ;
}

