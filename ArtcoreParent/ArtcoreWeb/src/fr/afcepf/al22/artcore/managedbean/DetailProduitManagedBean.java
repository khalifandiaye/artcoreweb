package fr.afcepf.al22.artcore.managedbean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.artcore.dto.DtoProduit;

@ManagedBean(name="mbDetailPdt")
@RequestScoped
public class DetailProduitManagedBean { 

@ManagedProperty(value="#{mbCatalogue.produit}")
private DtoProduit produit;

@ManagedProperty(value="#{mbIndex.produit}")
private DtoProduit produit2;

public DtoProduit getProduit() {
	if (produit != null) {
		return produit;
	}
	else {
		return produit2;
	}

}
public void setProduit(DtoProduit produit) {
	this.produit = produit;
}

private String AjouterAuPanier () {
	return "";
}
public DtoProduit getProduit2() {
	return produit2;
}
public void setProduit2(DtoProduit produit2) {
	this.produit2 = produit2;
}

}
