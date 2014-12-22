package fr.afcepf.al22.artcore.businessinterfaces;

import java.util.List;

import javax.ejb.Remote;




import fr.afcepf.al22.artcore.dto.DtoCivilite;
import fr.afcepf.al22.artcore.dto.DtoPays;
import fr.afcepf.al22.artcore.entities.Pays;

@Remote
public interface IBusinessPays {
	
	public List<DtoPays> listeTousPays () ;
	public Pays paysParId(int id) ;
}

