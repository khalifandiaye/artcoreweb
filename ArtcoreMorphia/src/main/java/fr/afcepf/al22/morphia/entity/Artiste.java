package fr.afcepf.al22.morphia.entity;

public class Artiste {
    //atttibut
    private String speudo;
    private String email;
    private String faceDeBouk;
    private String twitter;
    private String instgram;
    
    
    //constructeurs
    public Artiste() {
	super();
    }
    
    public Artiste(String speudo, String email, String faceDeBouk,
	    String twitter, String instgram) {
	super();
	this.speudo = speudo;
	this.email = email;
	this.faceDeBouk = faceDeBouk;
	this.twitter = twitter;
	this.instgram = instgram;
    }
    
    //getter and setter
    public String getSpeudo() {
        return speudo;
    }
    public void setSpeudo(String speudo) {
        this.speudo = speudo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFaceDeBouk() {
        return faceDeBouk;
    }
    public void setFaceDeBouk(String faceDeBouk) {
        this.faceDeBouk = faceDeBouk;
    }
    public String getTwitter() {
        return twitter;
    }
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    public String getInstgram() {
        return instgram;
    }
    public void setInstgram(String instgram) {
        this.instgram = instgram;
    }
    
    //ToString
    @Override
    public String toString() {
	return "artiste [speudo=" + speudo + ", email=" + email
		+ ", faceDeBouk=" + faceDeBouk + ", twitter=" + twitter
		+ ", instgram=" + instgram + "]";
    }
    
    
}
