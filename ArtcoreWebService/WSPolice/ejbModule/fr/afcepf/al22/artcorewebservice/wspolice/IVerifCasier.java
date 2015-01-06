/**
 * Vérification du casier et renvoie le statut du casier si present.
 */
package fr.afcepf.al22.artcorewebservice.wspolice;

import javax.ejb.Remote;
import javax.jws.WebParam;
import javax.jws.WebService;

/**Interface du webService pour la verification dans le fichier de police.
 * @author Stagiaire
 *
 */
@Remote
@WebService
public interface IVerifCasier {

		/**
		 * @param nom
		 * @param prenom
		 * @param birthday 
		 * @return 
		 */
		public String verifCasier(@WebParam(name="nom")String nom,
				@WebParam(name="prenom")String prenom,
				@WebParam(name="birthday")String birthday );
}
