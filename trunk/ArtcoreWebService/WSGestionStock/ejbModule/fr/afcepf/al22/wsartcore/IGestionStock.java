package fr.afcepf.al22.wsartcore;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al22.entities.Produit;

@WebService
@Remote //pour les ejb fonctionne avec stateless
public interface IGestionStock {
	@WebMethod(operationName="rechercherNbProduitDisponible")
	int rechercherNbProduitDisponibleParId (@WebParam(name="idProduit")int id);

}
