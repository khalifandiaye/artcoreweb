package pack.test;

import java.net.UnknownHostException;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class FindMongo {
	public static void main(String[] args) {
		MongoClient mongo = null;
		List<GalerieEntity> lines = null;
		GalerieDao dao = null;
		try {
			mongo = new MongoClient("localhost");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Morphia morphia = new Morphia();
		dao = new GalerieDao(mongo,morphia,"galerie3db");
		System.out.println("*****recherche par within 2.33,48.859,0.8/6371 *****");
		lines = dao.findGPS(2.33,48.859,0.8/6371);
		
		System.out.println("lines size "+lines.size());
		for(GalerieEntity ge : lines) {
			System.out.println("line : "+ge.getId()+" "+ge.getLoc()[0]+" "+ge.getLoc()[1]+" "+ge.getNomGalerie()+" "+ge.getFormattedAdresse());
		}
		System.out.println("*****recherche par near *****");
		lines = dao.nearGps(2.33,48.859,0.8/6371);
		
		System.out.println("lines size "+lines.size());
		for(GalerieEntity ge : lines) {
			System.out.println("line : "+ge.getId()+" "+ge.getLoc()[0]+" "+ge.getLoc()[1]+" "+ge.getNomGalerie()+" "+ge.getFormattedAdresse());
		}
	}
}
