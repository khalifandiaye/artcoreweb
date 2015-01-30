package fr.afcepf.al22.morphia.entity;

import java.util.Arrays;

public class AdresseGalerie {
 
    //attribut
    private String rue;
    private String codePostal;
    private String ville;
    private double[] coordonnée ;
    
    
    //construteur
    public AdresseGalerie() {
	super();
    }
    public AdresseGalerie(String rue, String codePostal, String ville, double[] coordonnée) {
	super();
	this.rue = rue;
	this.codePostal = codePostal;
	this.ville = ville;
	this.coordonnée = coordonnée;
    }
    
    //getter and setter
    public String getRue() {
        return rue;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public double[] getCoordonnée() {
        return coordonnée;
    }
    public void setCoordonnée(double[] coordonnée) {
        this.coordonnée = coordonnée;
    }
    @Override
    public String toString() {
	return "AdresseGalerie [rue=" + rue + ", codePostal=" + codePostal
		+ ", ville=" + ville + ", coordonnée="
		+ Arrays.toString(coordonnée) + "]";
    }
    
    
    
}
