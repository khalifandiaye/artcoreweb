package fr.afcepf.al22.morphia.dao;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.entity.Galerie;

public class GalerieDao extends BasicDAO<Galerie, Integer> {
    
    public GalerieDao(MongoClient mongo,Morphia morphia){
	super(mongo,morphia,"Expositiondb");

    } 
}
