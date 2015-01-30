package fr.afcepf.al22.morphia.client;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.entity.Artiste;
import fr.afcepf.al22.morphia.entity.Exposition;

public class RemplirBaseExpoClient {

    public static void main(String[] args) {
	MongoClient mongo = null;
	
	
	    
	    try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mongo = new MongoClient("localhost");
		Morphia morphia = new Morphia();
		ExpositionDao dao = new ExpositionDao(mongo, morphia);
		Date debut = new Date ();
		Date fin = new Date ();
		int mois = 12;
		int jour = 15;
		int ann�e = 2014;
		List<Date> listeDate = new ArrayList<>();
		
		for(int i=0; i< 100 ; i++){
		    if(mois>12){
			mois = 1;
			ann�e++;
		    }
		    try {
			listeDate.add(sdf.parse(jour+"/"+mois+"/"+ann�e));
			System.out.println(sdf.parse(jour+"/"+mois+"/"+ann�e));
		    } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			mois++;
		}
		// liste artiste
		List<Artiste> listeArtiste = new ArrayList<>();
		listeArtiste.add(new Artiste("Anonymous P.","Anonymous@Pari.fr","fr-fr.facebook.com/AnonymousP","#AnonymousP","AnonymousP")) ;
		listeArtiste.add(new Artiste("Micha�l F.","MichaelF@gmail.fr","fr-fr.facebook.com/MichaelF","#MichaelF","MichaelF")) ;
		listeArtiste.add(new Artiste("C. Aguilera","Caguilera@gmail.fr","fr-fr.facebook.com/Caguilera","#Caguilera","Caguilera")) ;
		listeArtiste.add(new Artiste("B. Gaulin","BGaulin@yahoo.fr","fr-fr.facebook.com/BGaulin","#BGaulin","BGaulin")) ;
		listeArtiste.add(new Artiste("John Doe","JohnDoe@hotmail.fr","fr-fr.facebook.com/JohnDoe","#JohnDoe","JohnDoe")) ;
		listeArtiste.add(new Artiste("Michel Anonymous","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		// liste cat�gorie
		List<String> listeCategorie = new ArrayList<>();
		listeCategorie.add("Photographie");
		listeCategorie.add("Textes");
		listeCategorie.add("Peinture");
		listeCategorie.add("Sculture");
		//liste Intitule
		List<String> listeIntitule = new ArrayList<>();
		listeIntitule.add("beaucoup de saintes");
		listeIntitule.add("passion apocalyptique");
		listeIntitule.add("la farce sans en avoir les moyens");
		listeIntitule.add("s�journe sous les pav�s");
		listeIntitule.add("le quignon de pain et les h�pitaux");
		listeIntitule.add("les lueurs aux h�riti�res");
		listeIntitule.add("Une f�e au bord du suicide");
		listeIntitule.add("pirates pessimistes");
		listeIntitule.add("le d�fi en carton");
		listeIntitule.add("chapeaux � Stockholm");
		listeIntitule.add("Les contribuables candides");
		listeIntitule.add("des silhouettes au braqueur de banques");
		listeIntitule.add("code Javascript");
		listeIntitule.add("l'armure en forme de coeur");
		listeIntitule.add("violoncellistes en mission");
		listeIntitule.add("des usag�res chauves");
		listeIntitule.add("une rang�e de cause");
		listeIntitule.add("La danseuse un peu coinc�e");
		listeIntitule.add("la p�che tubulaire");
		listeIntitule.add("une valeur sans le vouloir");
		
		for(long i = 1 ; i<1000001; i++){
		//random pour artiste
		int artisteChoisi1 = (int)(Math.random()*listeArtiste.size());
		int artisteChoisi2 = (int)(Math.random()*listeArtiste.size());
		List<Artiste> listeArtisteChoisi = new ArrayList<>();
		listeArtisteChoisi.add(listeArtiste.get(artisteChoisi1));
		listeArtisteChoisi.add(listeArtiste.get(artisteChoisi2));
		
		//random pour intuler
		int intuleChoisi= (int)(Math.random()*(listeIntitule.size()));
		
		//random pour cat�gorie
		int categorieChoisi= (int)(Math.random()*(listeCategorie.size()));
		
		//random pour date 
		int dateDebutChoisi= (int)(Math.random()*(listeDate.size()-1));
		
		dao.save(new Exposition(i, listeIntitule.get(intuleChoisi), listeCategorie.get(categorieChoisi), listeDate.get(dateDebutChoisi), listeDate.get(dateDebutChoisi+1), listeArtisteChoisi));
		}
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

