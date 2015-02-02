package fr.afcepf.al22.morphia.client;

import java.io.ObjectInputStream.GetField;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import fr.afcepf.al22.morphia.dao.ExpositionDao;
import fr.afcepf.al22.morphia.dao.GalerieDao;
import fr.afcepf.al22.morphia.entity.Artiste;
import fr.afcepf.al22.morphia.entity.Exposition;
import fr.afcepf.al22.morphia.entity.Galerie;

public class RemplirBaseExpoClient {

    public static void main(String[] args) {
	MongoClient mongo = null;
	
	
	    
	    try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mongo = new MongoClient("localhost");
		Morphia morphia = new Morphia();
		GalerieDao daoGalerie = new GalerieDao(mongo, morphia);
		ExpositionDao dao = new ExpositionDao(mongo, morphia);
		Date debut = new Date ();
		Date fin = new Date ();
		int mois = 12;
		int jour = 15;
		int ann�e = 2014;
		List<Date> listeDate = new ArrayList<>();
		
		for(int i=0; i< 1000 ; i++){
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
		listeArtiste.add(new Artiste("Castor Joviale","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Gaston Lagaffe","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Pentoufle dor��","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("la reponse D","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Tout PourMoi","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Petit Pousset","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Grand Loup","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Michel Anonymous","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Marche Oupas","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Arthur","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("le roi du monde","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("l'aveugle","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Moi","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Nombril du monde","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Tristan Fortier","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Charlie","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Marsupilamoue","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		listeArtiste.add(new Artiste("Entonv","Manonymous@gmail.fr","fr-fr.facebook.com/Manonymous","#Manonymous","Manonymous")) ;
		// liste cat�gorie
		List<String> listeCategorie = new ArrayList<>();
		listeCategorie.add("Photographie");
		listeCategorie.add("Textes");
		listeCategorie.add("Peinture");
		listeCategorie.add("Sculture");
		listeCategorie.add("Performance");
		listeCategorie.add("Poesie");
		listeCategorie.add("Musique");
		listeCategorie.add("StreetArt");
		listeCategorie.add("Danse");
		listeCategorie.add("Cinema");
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
		listeIntitule.add("un cloporte avec le colonel");
		listeIntitule.add("L'employ� du mois");
		listeIntitule.add("nos cachalots � ces canc�rologues");
		listeIntitule.add("le clou �tranger");
		listeIntitule.add("Cinq mille cinq cents travestis");
		listeIntitule.add("l'�ruption du Krakatoa");
		listeIntitule.add("Le roi de la piste");
		listeIntitule.add("des calculs avec difficult�");
		listeIntitule.add("La qu�becoise veille");
		listeIntitule.add("Des passagers aux intentions");
		listeIntitule.add("Vingt et un mannequins");
		listeIntitule.add("Le coiffeur de Pancho Villa ");
		listeIntitule.add("Robin des bois");
		listeIntitule.add("l'arabesque clout�e aux sommets");
		listeIntitule.add("Le glandeur hilare");
		listeIntitule.add("Les pr�lats inconnus");
		listeIntitule.add("le bon de r�duction");
		listeIntitule.add("objets m�talliques");
		listeIntitule.add("Un galopin");
		listeIntitule.add("la coupe et les chauffeurs routiers");
		listeIntitule.add("une poutrelle de chantier fondamentale");
		listeIntitule.add("Un plombier cire");
		listeIntitule.add("la lunette de secours");
		listeIntitule.add("la magicienne en personne");
		listeIntitule.add("Les terroristes v�g�tariens");
		listeIntitule.add("rudes mol�cules");
	
		//liste Galerie
		List<Galerie> listeGalerie = new ArrayList<>();
		listeGalerie = daoGalerie.find().asList();
		
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
		
		//random pour galerie
		int galerieChoisi = (int)(Math.random()*(listeGalerie.size()));
		
		dao.save(new Exposition(i,listeGalerie.get(galerieChoisi),listeIntitule.get(intuleChoisi), listeCategorie.get(categorieChoisi), listeDate.get(dateDebutChoisi), listeDate.get(dateDebutChoisi+1), listeArtisteChoisi));
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

