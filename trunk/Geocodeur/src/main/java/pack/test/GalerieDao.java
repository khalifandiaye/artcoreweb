package pack.test;

import java.util.List;

import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Shape;
import org.mongodb.morphia.query.Shape.Point;

import com.mongodb.MongoClient;

public class GalerieDao extends BasicDAO<GalerieEntity,Integer> {

	protected GalerieDao(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}
	
	public List<GalerieEntity> findGPS(double lng,double lat,double radian) {
		Point centre = new Point(lng,lat);
		//2.33,48.859
		return findGPS(centre, radian);
	}
	public List<GalerieEntity> findGPS(Point centre,double radian) {
//		getDatastore().find(GalerieEntity.class).field("loc").near(0,0,true).asList();
		//0.5/6371
		Shape center = Shape.centerSphere(centre, radian);
		System.out.println("create shape "+center.getGeometry());
		return getDatastore().find(GalerieEntity.class).field("loc").within(center).asList();
		//[2.33,48.859],0.5/6371
		//return getDs().find(GalerieEntity.class).filter("label = ", label).order("label").asList();		
	}
	public List<GalerieEntity> nearGps(double lng , double lat,int limit) {
		 return getDatastore().find(GalerieEntity.class).field("loc").near(lng, lat).limit(limit).asList();
	}
	public List<GalerieEntity> nearGps(double lng , double lat,double radian) {
//		  long r = getDatastore().find(GalerieEntity.class).field("loc").near(lng, lat,radian,true).countAll();
//		  System.out.println("r = "+r);
		  return getDatastore().find(GalerieEntity.class).field("loc").near(lng, lat,radian,true).asList();
	}
	
}
