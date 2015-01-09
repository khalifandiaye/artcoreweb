
package fr.afcepf.al22.orchestration.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for produitCommande complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="produitCommande">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idProduit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="quantiteCommande" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produitCommande", propOrder = {
    "idProduit",
    "quantiteCommande"
})
public class ProduitCommande {

    protected int idProduit;
    protected int quantiteCommande;

    /**
     * Gets the value of the idProduit property.
     * 
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * Sets the value of the idProduit property.
     * 
     */
    public void setIdProduit(int value) {
        this.idProduit = value;
    }

    /**
     * Gets the value of the quantiteCommande property.
     * 
     */
    public int getQuantiteCommande() {
        return quantiteCommande;
    }

    /**
     * Sets the value of the quantiteCommande property.
     * 
     */
    public void setQuantiteCommande(int value) {
        this.quantiteCommande = value;
    }

}
