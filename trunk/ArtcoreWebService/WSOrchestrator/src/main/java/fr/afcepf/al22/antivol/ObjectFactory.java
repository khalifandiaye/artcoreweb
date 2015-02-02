
package fr.afcepf.al22.antivol;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.afcepf.al22.antivol package. 
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

    private final static QName _RechercheCBVoleeParNumero_QNAME = new QName("http://antivol.al22.afcepf.fr/", "rechercheCBVoleeParNumero");
    private final static QName _RechercheCBVoleeParNumeroResponse_QNAME = new QName("http://antivol.al22.afcepf.fr/", "rechercheCBVoleeParNumeroResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.afcepf.al22.antivol
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RechercheCBVoleeParNumeroResponse }
     * 
     */
    public RechercheCBVoleeParNumeroResponse createRechercheCBVoleeParNumeroResponse() {
        return new RechercheCBVoleeParNumeroResponse();
    }

    /**
     * Create an instance of {@link RechercheCBVoleeParNumero }
     * 
     */
    public RechercheCBVoleeParNumero createRechercheCBVoleeParNumero() {
        return new RechercheCBVoleeParNumero();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercheCBVoleeParNumero }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antivol.al22.afcepf.fr/", name = "rechercheCBVoleeParNumero")
    public JAXBElement<RechercheCBVoleeParNumero> createRechercheCBVoleeParNumero(RechercheCBVoleeParNumero value) {
        return new JAXBElement<RechercheCBVoleeParNumero>(_RechercheCBVoleeParNumero_QNAME, RechercheCBVoleeParNumero.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RechercheCBVoleeParNumeroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://antivol.al22.afcepf.fr/", name = "rechercheCBVoleeParNumeroResponse")
    public JAXBElement<RechercheCBVoleeParNumeroResponse> createRechercheCBVoleeParNumeroResponse(RechercheCBVoleeParNumeroResponse value) {
        return new JAXBElement<RechercheCBVoleeParNumeroResponse>(_RechercheCBVoleeParNumeroResponse_QNAME, RechercheCBVoleeParNumeroResponse.class, null, value);
    }

}
