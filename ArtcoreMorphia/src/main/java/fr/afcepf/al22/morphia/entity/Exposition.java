package fr.afcepf.al22.morphia.entity;

import java.util.Date;
import java.util.List;

import org.mongodb.morphia.annotations.Id;

public class Exposition {

    @Id
    private Long id;
    
    private Galerie galerie;
    private String intule;
    private String categorie;
    private Date debut;
    private Date fin;
    private List<Artiste> listArtiste;
    
    
   
    public Date getDebut() {
        return debut;
    }
    public void setDebut(Date debut) {
        this.debut = debut;
    }
    public Date getFin() {
        return fin;
    }
    public void setFin(Date fin) {
        this.fin = fin;
    }

    
    public Galerie getGalerie() {
        return galerie;
    }
    public void setGalerie(Galerie galerie) {
        this.galerie = galerie;
    }
    public String getIntule() {
        return intule;
    }
    public void setIntule(String intule) {
        this.intule = intule;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
   
    public List<Artiste> getListArtiste() {
        return listArtiste;
    }
    public void setListArtiste(List<Artiste> listArtiste) {
        this.listArtiste = listArtiste;
    }
    
   
    
    public Exposition() {
	super();
   
    }
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    public Exposition(Long id, String intule, String categorie, Date debut,
	    Date fin, List<Artiste> listArtiste) {
	super();
	this.id = id;
	this.intule = intule;
	this.categorie = categorie;
	this.debut = debut;
	this.fin = fin;
	this.listArtiste = listArtiste;
    }
    public Exposition(Long id, Galerie galerie, String intule,
	    String categorie, Date debut, Date fin, List<Artiste> listArtiste) {
	super();
	this.id = id;
	this.galerie = galerie;
	this.intule = intule;
	this.categorie = categorie;
	this.debut = debut;
	this.fin = fin;
	this.listArtiste = listArtiste;
    }
    @Override
    public String toString() {
	return "Exposition [id=" + id + ", galerie=" + galerie + ", intule="
		+ intule + ", categorie=" + categorie + ", debut=" + debut
		+ ", fin=" + fin + ", listArtiste=" + listArtiste + "]";
    } 
    
}
