package fr.afcepf.al22.morphia.client;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.dao.GalerieDao;
import fr.afcepf.al22.morphia.entity.Exposition;
import fr.afcepf.al22.morphia.entity.Galerie;

public class TestQueryClient {

    public static void main(String[] args) {
   	MongoClient mongo = null;
   	
   	 try {
   	    
   	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   	   
		mongo = new MongoClient("localhost");
	 
   	    Morphia morphia = new Morphia();
   	    GalerieDao daoGalerie = new GalerieDao(mongo, morphia);
   	    ExpositionDao dao = new ExpositionDao(mongo, morphia);
   	    List<Exposition> expos = new ArrayList<>();
   	 List<Galerie> galeris = new ArrayList<>();
   	    //expos = dao.findParCategorie();
   	    
   	    //galeris = daoGalerie.find().asList();
   	    //expos = dao.findProximite(2.33,48.859,0.3/6371);
   	      expos = dao.findParArtiste("Michaël F.");
   	      
   	      for (Exposition ex : expos){
   		  System.out.println(ex);
   	      }
   	    System.out.println(expos.size());
   	   } catch (UnknownHostException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		    }
    } 
}
