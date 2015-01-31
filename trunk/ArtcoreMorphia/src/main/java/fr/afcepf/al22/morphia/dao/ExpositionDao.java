package fr.afcepf.al22.morphia.dao;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.entity.Artiste;
import fr.afcepf.al22.morphia.entity.Exposition;

public class ExpositionDao extends BasicDAO<Exposition, Long> {
    
    public ExpositionDao(MongoClient mongo,Morphia morphia){
	super(mongo,morphia,"Expositiondb");
	
}
    public List<Exposition> findAll(){
	
	return getDs().find(Exposition.class).asList();
	
}
    public List<Exposition> findExpoByCategorie(String categorie){
    	   	
    	return getDs().find(Exposition.class).filter("categorie = ", categorie).order("categorie").asList();
    }
    
    //A revoir parce que artistes n'est pas bon
    public List<Exposition> findExpoParArtistes(List<Artiste> artistes){
    	List<Exposition> exposRetour = new ArrayList<>();
    	List<Exposition> expoParUnArtiste = new ArrayList<>();
    	for(Artiste a: artistes){
    		expoParUnArtiste = getDs().find(Exposition.class).filter("artiste=", a).order("artiste").asList();
    		for(Exposition e : expoParUnArtiste){
    			exposRetour.add(e);
    			
    		}
    	}
    	return exposRetour;
    }
    
    public List<Exposition> findExpoParNomArtiste(String nomArtiste){
    	List<Exposition> exposRetour = new ArrayList<>();
    	List<Artiste> artistesParExpo = new ArrayList<>();
    	for(Exposition e: this.findAll()){
    		artistesParExpo = getDs().find(Artiste.class).asList();
    		for(Artiste a : artistesParExpo){
    			if(a.getSpeudo() == nomArtiste){
    				exposRetour.add(e);
    			}
    		}
    	}
    	return exposRetour;
    }
    
    //Manque rechercher Expo par secteur car pas encore mis en place
}
