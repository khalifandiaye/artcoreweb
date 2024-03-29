
package fr.afcepf.al22.antivol;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IAntivolCB", targetNamespace = "http://antivol.al22.afcepf.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IAntivolCB {


    /**
     * 
     * @param nbDeCarte
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rechercheCBVoleeParNumero", targetNamespace = "http://antivol.al22.afcepf.fr/", className = "fr.afcepf.al22.antivol.RechercheCBVoleeParNumero")
    @ResponseWrapper(localName = "rechercheCBVoleeParNumeroResponse", targetNamespace = "http://antivol.al22.afcepf.fr/", className = "fr.afcepf.al22.antivol.RechercheCBVoleeParNumeroResponse")
    public boolean rechercheCBVoleeParNumero(
        @WebParam(name = "nbDeCarte", targetNamespace = "")
        String nbDeCarte);

}
