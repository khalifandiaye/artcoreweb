/**
 * 
 */
package fr.afcepf.al22.wsartcore;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Ing
 *
 */
@WebService
@Remote
public interface IAntivolCB {
	
	@WebMethod(operationName="rechercheCBVoleeParNumero")
	public boolean rechercheCBVoleeParNumero (@WebParam(name="nbDeCarte") String nbCB);

}
