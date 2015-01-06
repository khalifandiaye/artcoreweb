
package fr.afcepf.al22.antivol;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rechercheCBVoleeParNumero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rechercheCBVoleeParNumero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbDeCarte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rechercheCBVoleeParNumero", propOrder = {
    "nbDeCarte"
})
public class RechercheCBVoleeParNumero {

    protected String nbDeCarte;

    /**
     * Gets the value of the nbDeCarte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbDeCarte() {
        return nbDeCarte;
    }

    /**
     * Sets the value of the nbDeCarte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbDeCarte(String value) {
        this.nbDeCarte = value;
    }

}
