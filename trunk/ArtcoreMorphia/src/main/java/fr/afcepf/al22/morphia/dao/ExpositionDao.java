package fr.afcepf.al22.morphia.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.entity.Exposition;

public class ExpositionDao extends BasicDAO<Exposition, Long> {
    
    public ExpositionDao(MongoClient mongo,Morphia morphia){
	super(mongo,morphia,"Expositiondb");
	
}
    public List<Exposition> findAll(){
	
	return getDs().find(Exposition.class).asList();
    }
    public List<Exposition> findParCategorie(String categorie){
	//Calendar calendar = Calendar.getInstance();
	//calendar.add(Calendar.MONTH, 1);
	
	return getDs().find(Exposition.class, "categorie" , categorie).field("fin").greaterThan(new Date()).field("debut").lessThan(new Date()).asList();
    }
    public List<Exposition> findParArtiste(String artiste){
	//Calendar calendar = Calendar.getInstance();
	//calendar.add(Calendar.MONTH, 1);
	
	return getDs().find(Exposition.class, "listArtiste.speudo" , artiste).field("fin").greaterThan(new Date()).field("debut").lessThan(new Date()).asList();
    }
    
    public List<Exposition> findProximite(double lat, double longi,double radius){
	
	
	return getDs().find(Exposition.class).field("fin").greaterThan(new Date()).field("debut").lessThan(new Date()).field("galerie.loc").near(lat, longi, radius, true).asList();
    }
}
    
    

