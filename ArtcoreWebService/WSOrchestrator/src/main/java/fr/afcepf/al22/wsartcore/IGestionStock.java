
package fr.afcepf.al22.wsartcore;

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
@WebService(name = "IGestionStock", targetNamespace = "http://wsartcore.al22.afcepf.fr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IGestionStock {


    /**
     * 
     * @param idProduit
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "rechercherNbProduitDisponible", targetNamespace = "http://wsartcore.al22.afcepf.fr/", className = "fr.afcepf.al22.wsartcore.RechercherNbProduitDisponible")
    @ResponseWrapper(localName = "rechercherNbProduitDisponibleResponse", targetNamespace = "http://wsartcore.al22.afcepf.fr/", className = "fr.afcepf.al22.wsartcore.RechercherNbProduitDisponibleResponse")
    public int rechercherNbProduitDisponible(
        @WebParam(name = "idProduit", targetNamespace = "")
        int idProduit);

}
