package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;


import fr.afcepf.al22.artcore.entities.Pays;

@Remote
public interface IDaoPays {
	
	public List<Pays> listeTousPays ();
	public Pays paysParId (int id);
}
