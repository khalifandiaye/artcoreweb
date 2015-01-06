
package fr.afcepf.al22.artcorewebservice.wspolice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "VerifCasierImplService", targetNamespace = "http://wspolice.artcorewebservice.al22.afcepf.fr/", wsdlLocation = "http://localhost:9090/WSPolice/VerifCasierImpl?wsdl")
public class VerifCasierImplService
    extends Service
{

    private final static URL VERIFCASIERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException VERIFCASIERIMPLSERVICE_EXCEPTION;
    private final static QName VERIFCASIERIMPLSERVICE_QNAME = new QName("http://wspolice.artcorewebservice.al22.afcepf.fr/", "VerifCasierImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/WSPolice/VerifCasierImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        VERIFCASIERIMPLSERVICE_WSDL_LOCATION = url;
        VERIFCASIERIMPLSERVICE_EXCEPTION = e;
    }

    public VerifCasierImplService() {
        super(__getWsdlLocation(), VERIFCASIERIMPLSERVICE_QNAME);
    }

    public VerifCasierImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), VERIFCASIERIMPLSERVICE_QNAME, features);
    }

    public VerifCasierImplService(URL wsdlLocation) {
        super(wsdlLocation, VERIFCASIERIMPLSERVICE_QNAME);
    }

    public VerifCasierImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, VERIFCASIERIMPLSERVICE_QNAME, features);
    }

    public VerifCasierImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VerifCasierImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IVerifCasier
     */
    @WebEndpoint(name = "VerifCasierImplPort")
    public IVerifCasier getVerifCasierImplPort() {
        return super.getPort(new QName("http://wspolice.artcorewebservice.al22.afcepf.fr/", "VerifCasierImplPort"), IVerifCasier.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IVerifCasier
     */
    @WebEndpoint(name = "VerifCasierImplPort")
    public IVerifCasier getVerifCasierImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wspolice.artcorewebservice.al22.afcepf.fr/", "VerifCasierImplPort"), IVerifCasier.class, features);
    }

    private static URL __getWsdlLocation() {
        if (VERIFCASIERIMPLSERVICE_EXCEPTION!= null) {
            throw VERIFCASIERIMPLSERVICE_EXCEPTION;
        }
        return VERIFCASIERIMPLSERVICE_WSDL_LOCATION;
    }

}
