package fr.afcepf.al22.morphia.client;

import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.entity.AdresseGalerie;
import fr.afcepf.al22.morphia.entity.Artiste;
import fr.afcepf.al22.morphia.entity.Exposition;

public class ExpoClient {
    
    
    public static void main(String[] args) {
	MongoClient mongo = null;
	
	try {
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    mongo = new MongoClient("localhost");
	    Morphia morphia = new Morphia();
	    ExpositionDao dao = new ExpositionDao(mongo, morphia);
	    Date debut = new Date ();
	    Date fin = new Date ();
	    List<Artiste> listArtiste = new ArrayList<>();
	    try {
		 debut = sdf.parse("15/02/2014");
		 fin = sdf.parse("15/12/2012");
	    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    
	  Artiste artisteTest = new Artiste("toto","toto@toto.fr","jaimepasfacedebouk","twitteralarigueur","passageobliger");
	   double[] cordonnée = {12.56,15.2};
	   listArtiste.add(artisteTest);
	   
	
	  Exposition expoTest = new Exposition(1L, null, "hohoho", "jesaispas", debut, fin, listArtiste);
	  
	    dao.save(expoTest);
	    List<Exposition> Expositions  = dao.findAll();
		for (Exposition f : Expositions){
			System.out.println("Exposition: "+f);
		}
		
		Exposition exposition2 = dao.get(new Long(1));
		System.out.println(exposition2);
	} catch (UnknownHostException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	
	
    }
}
