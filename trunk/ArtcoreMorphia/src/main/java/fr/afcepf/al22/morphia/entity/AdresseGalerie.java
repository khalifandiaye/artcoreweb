package fr.afcepf.al22.morphia.entity;

import java.util.Arrays;

public class AdresseGalerie {
 
    //attribut
    private String rue;
    private String codePostal;
    private String ville;
    private double[] coordonn�e ;
    
    
    //construteur
    public AdresseGalerie() {
	super();
    }
    public AdresseGalerie(String rue, String codePostal, String ville, double[] coordonn�e) {
	super();
	this.rue = rue;
	this.codePostal = codePostal;
	this.ville = ville;
	this.coordonn�e = coordonn�e;
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
    public double[] getCoordonn�e() {
        return coordonn�e;
    }
    public void setCoordonn�e(double[] coordonn�e) {
        this.coordonn�e = coordonn�e;
    }
    @Override
    public String toString() {
	return "AdresseGalerie [rue=" + rue + ", codePostal=" + codePostal
		+ ", ville=" + ville + ", coordonn�e="
		+ Arrays.toString(coordonn�e) + "]";
    }
    
    
    
}
