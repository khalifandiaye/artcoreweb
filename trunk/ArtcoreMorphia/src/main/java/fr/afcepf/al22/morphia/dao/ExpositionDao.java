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

}
