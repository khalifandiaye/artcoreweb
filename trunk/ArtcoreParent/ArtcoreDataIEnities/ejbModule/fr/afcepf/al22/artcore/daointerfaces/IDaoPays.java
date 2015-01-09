package fr.afcepf.al22.artcore.daointerfaces;

import java.util.List;

import javax.ejb.Remote;


import fr.afcepf.al22.artcore.entities.Pays;

@Remote
public interface IDaoPays {
	
	public List<Pays> listeTousPays ();
	/**
	 * Méthode rajoutée le 08/01 qui prend en argument un int id
	 * et qui renvoie le pays correspondant à cet id.
	 * Je devrais en avoir besoin pour donner un pays à une adresse.
	 * Pour pouvoir inscrire un nouveau client.
	 * @param id l'int du pays qu'on cherche.
	 * @return le pays correspondant à l'id en paramètre.
	 */
	public Pays paysParId (int id);
}
