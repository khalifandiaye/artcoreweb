
package fr.afcepf.al22.orchestration.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al22.orchestration.interfaces package. 
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

    private final static QName _VerifCommandeResponse_QNAME = new QName("http://interfaces.orchestration.al22.afcepf.fr/", "verifCommandeResponse");
    private final static QName _VerifCommande_QNAME = new QName("http://interfaces.orchestration.al22.afcepf.fr/", "verifCommande");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al22.orchestration.interfaces
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifCommandeResponse }
     * 
     */
    public VerifCommandeResponse createVerifCommandeResponse() {
        return new VerifCommandeResponse();
    }

    /**
     * Create an instance of {@link VerifCommande }
     * 
     */
    public VerifCommande createVerifCommande() {
        return new VerifCommande();
    }

    /**
     * Create an instance of {@link CheckResultProduitCommande }
     * 
     */
    public CheckResultProduitCommande createCheckResultProduitCommande() {
        return new CheckResultProduitCommande();
    }

    /**
     * Create an instance of {@link ProduitCommande }
     * 
     */
    public ProduitCommande createProduitCommande() {
        return new ProduitCommande();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifCommandeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.orchestration.al22.afcepf.fr/", name = "verifCommandeResponse")
    public JAXBElement<VerifCommandeResponse> createVerifCommandeResponse(VerifCommandeResponse value) {
        return new JAXBElement<VerifCommandeResponse>(_VerifCommandeResponse_QNAME, VerifCommandeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifCommande }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://interfaces.orchestration.al22.afcepf.fr/", name = "verifCommande")
    public JAXBElement<VerifCommande> createVerifCommande(VerifCommande value) {
        return new JAXBElement<VerifCommande>(_VerifCommande_QNAME, VerifCommande.class, null, value);
    }

}
