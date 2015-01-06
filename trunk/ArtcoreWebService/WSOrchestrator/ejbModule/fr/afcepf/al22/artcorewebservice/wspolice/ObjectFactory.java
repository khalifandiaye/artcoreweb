
package fr.afcepf.al22.artcorewebservice.wspolice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al22.artcorewebservice.wspolice package. 
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

    private final static QName _VerifCasierResponse_QNAME = new QName("http://wspolice.artcorewebservice.al22.afcepf.fr/", "verifCasierResponse");
    private final static QName _VerifCasier_QNAME = new QName("http://wspolice.artcorewebservice.al22.afcepf.fr/", "verifCasier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al22.artcorewebservice.wspolice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifCasierResponse }
     * 
     */
    public VerifCasierResponse createVerifCasierResponse() {
        return new VerifCasierResponse();
    }

    /**
     * Create an instance of {@link VerifCasier }
     * 
     */
    public VerifCasier createVerifCasier() {
        return new VerifCasier();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifCasierResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspolice.artcorewebservice.al22.afcepf.fr/", name = "verifCasierResponse")
    public JAXBElement<VerifCasierResponse> createVerifCasierResponse(VerifCasierResponse value) {
        return new JAXBElement<VerifCasierResponse>(_VerifCasierResponse_QNAME, VerifCasierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifCasier }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspolice.artcorewebservice.al22.afcepf.fr/", name = "verifCasier")
    public JAXBElement<VerifCasier> createVerifCasier(VerifCasier value) {
        return new JAXBElement<VerifCasier>(_VerifCasier_QNAME, VerifCasier.class, null, value);
    }

}
