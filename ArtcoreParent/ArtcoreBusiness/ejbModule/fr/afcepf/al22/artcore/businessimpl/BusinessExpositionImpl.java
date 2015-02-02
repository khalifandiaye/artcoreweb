package fr.afcepf.al22.artcore.businessimpl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessExposition;
import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.dao.GalerieDao;
import fr.afcepf.al22.morphia.entity.Exposition;
@Stateless
public class BusinessExpositionImpl implements IBusinessExposition {

	@EJB
	private ExpositionDao daoExpo;
	
	@Override
	public List<Exposition> toutesLesExpos() {
		
		return daoExpo.findAll();
	}

	@Override
	public List<Exposition> rechercherExposParPseudoArtiste(String pseudo) {
		// TODO Auto-generated method stub
		return daoExpo.findParArtiste(pseudo);
	}

	@Override
	public List<Exposition> rechercherExposParLibelleCategorie(String categorie) {
		// TODO Auto-generated method stub
		return daoExpo.findParCategorie(categorie);
	}

	@Override
	public List<Exposition> rechercherExposParProximiteLatLongiRadius(
			double lat, double longi, double radius) {
		// TODO Auto-generated method stub
		return daoExpo.findProximite(lat, longi, radius);
	}

	public ExpositionDao getDaoExpo() {
		return daoExpo;
	}

	public void setDaoExpo(ExpositionDao daoExpo) {
		this.daoExpo = daoExpo;
	}
	

}
