
package fr.afcepf.al22.wsartcore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al22.wsartcore package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RechercherNbProduitDisponible_QNAME = new QName("http://wsartcore.al22.afcepf.fr/", "rechercherNbProduitDisponible");
    private final static QName _RechercherNbProduitDisponibleResponse_QNAME = new QName("http://wsartcore.al22.afcepf.fr/", "rechercherNbProduitDisponibleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al22.wsartcore
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RechercherNbProduitDisponibleResponse }
     * 
     */
    public RechercherNbProduitDisponibleResponse createRechercherNbProduitDisponibleResponse() {
        return new RechercherNbProduitDisponibleResponse();
    }

    /**
     * Create an instance of {@link RechercherNbProduitDisponible }
     * 
     */
    public RechercherNbProduitDisponible createRechercherNbProduitDisponible() {
        return new RechercherNbProduitDisponible();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherNbProduitDisponible }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsartcore.al22.afcepf.fr/", name = "rechercherNbProduitDisponible")
    public JAXBElement<RechercherNbProduitDisponible> createRechercherNbProduitDisponible(RechercherNbProduitDisponible value) {
        return new JAXBElement<RechercherNbProduitDisponible>(_RechercherNbProduitDisponible_QNAME, RechercherNbProduitDisponible.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercherNbProduitDisponibleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsartcore.al22.afcepf.fr/", name = "rechercherNbProduitDisponibleResponse")
    public JAXBElement<RechercherNbProduitDisponibleResponse> createRechercherNbProduitDisponibleResponse(RechercherNbProduitDisponibleResponse value) {
        return new JAXBElement<RechercherNbProduitDisponibleResponse>(_RechercherNbProduitDisponibleResponse_QNAME, RechercherNbProduitDisponibleResponse.class, null, value);
    }

}
