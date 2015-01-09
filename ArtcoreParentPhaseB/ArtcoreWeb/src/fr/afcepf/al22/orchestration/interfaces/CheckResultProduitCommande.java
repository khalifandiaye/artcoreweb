
package fr.afcepf.al22.orchestration.interfaces;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkResultProduitCommande complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkResultProduitCommande">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alerteCB" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="alertePolice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listeProduits" type="{http://interfaces.orchestration.al22.afcepf.fr/}produitCommande" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkResultProduitCommande", propOrder = {
    "alerteCB",
    "alertePolice",
    "listeProduits"
})
public class CheckResultProduitCommande {

    protected boolean alerteCB;
    protected String alertePolice;
    @XmlElement(nillable = true)
    protected List<ProduitCommande> listeProduits;

    /**
     * Gets the value of the alerteCB property.
     * 
     */
    public boolean isAlerteCB() {
        return alerteCB;
    }

    /**
     * Sets the value of the alerteCB property.
     * 
     */
    public void setAlerteCB(boolean value) {
        this.alerteCB = value;
    }

    /**
     * Gets the value of the alertePolice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlertePolice() {
        return alertePolice;
    }

    /**
     * Sets the value of the alertePolice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlertePolice(String value) {
        this.alertePolice = value;
    }

    /**
     * Gets the value of the listeProduits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeProduits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeProduits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProduitCommande }
     * 
     * 
     */
    public List<ProduitCommande> getListeProduits() {
        if (listeProduits == null) {
            listeProduits = new ArrayList<ProduitCommande>();
        }
        return this.listeProduits;
    }

}
