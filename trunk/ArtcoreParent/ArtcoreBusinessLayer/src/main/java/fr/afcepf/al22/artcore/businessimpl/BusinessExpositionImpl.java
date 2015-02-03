package fr.afcepf.al22.artcore.businessimpl;

import java.net.UnknownHostException;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.logging.Logger;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessExposition;
import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.entity.Exposition;
@Stateless
public class BusinessExpositionImpl implements IBusinessExposition {

	private Logger log =Logger.getLogger(getClass());
	private ExpositionDao daoExpo;
	
	@Override
	public List<Exposition> toutesLesExpos() {
		
		return daoExpo.findAll();
	}

	@Override
	public List<Exposition> rechercherExposParPseudoArtiste(String pseudo) {
	    log.debug("categorie = "+pseudo);
	    System.out.println("-----"+ pseudo);
	    try {
		MongoClient mongo = new MongoClient("localhost");
		 Morphia morphia = new Morphia();
		 daoExpo = new ExpositionDao(mongo, morphia);
	    } catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		 
   	   
	    List<Exposition> listesExpo = daoExpo.findParArtiste(pseudo);
	    System.out.println("artiste "+listesExpo);
		return listesExpo;
	}

	@Override
	public List<Exposition> rechercherExposParLibelleCategorie(String categorie) {
	    log.debug("categorie = "+categorie);
	    System.out.println("-----"+ categorie);
	    try {
		MongoClient mongo = new MongoClient("localhost");
		 Morphia morphia = new Morphia();
		 daoExpo = new ExpositionDao(mongo, morphia);
	    } catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
		 
   	   
	    List<Exposition> listesExpo = daoExpo.findParCategorie(categorie);
	    System.out.println(listesExpo);
	    return listesExpo;
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
