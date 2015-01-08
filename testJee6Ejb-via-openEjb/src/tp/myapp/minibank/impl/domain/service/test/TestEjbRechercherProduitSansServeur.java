package tp.myapp.minibank.impl.domain.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessRechercherProduit;
import fr.afcepf.al22.artcore.daointerfaces.IDaoConnexion;
import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.dto.DtoProduit;
import fr.afcepf.al22.artcore.entities.Produit;
import fr.afcepf.al22.artcore.entities.Utilisateur;



public class TestEjbRechercherProduitSansServeur extends MyAbstractOpenEjbTest{
	
    //service (ejb) a� tester
	private IDaoRechercherProduit daoProduit;
//	private IBusinessRechercherProduit buProduit;
	
	  @Before
	     public void initService(){
		  if (daoProduit==null){
//	       if(buProduit==null){
	         try{
	           String openEjbJndiName="DaoRechercherProduitImpl" + "Remote";
//	           String openEjbJndiName="BusinessRechercherProduitImpl" + "Remote";
	           daoProduit= (IDaoRechercherProduit)                
		                context.lookup(openEjbJndiName);
//	           buProduit= (IBusinessRechercherProduit)                
//	                context.lookup(openEjbJndiName);
			}catch(Exception ex){ex.printStackTrace();}
		}
	      }
	
	
	@Test
	public void testGetClientByNum(){
		try {
//			List<DtoProduit> listeTestBusiness = buProduit.produitsMultiCriteres("", "", 1, 1, true, true, true);
//			for (DtoProduit dtoProduit : listeTestBusiness) {
//				System.out.println("produit : " + dtoProduit.getLibelleProduit());
//			}
//			Assert.assertTrue(listeTestBusiness != null);
//			Assert.assertTrue(listeTestBusiness.size()> 0);
			
//			List<DtoProduit> listeTestCategorie = buProduit.produitsParCategorie(1);
//			for (DtoProduit dtoProduit : listeTestCategorie) {
//				System.out.println("produit : " + dtoProduit.getLibelleProduit());
//			}
//			Assert.assertTrue(listeTestCategorie != null);
//			Assert.assertTrue(listeTestCategorie.size()> 0);
			
			List<Produit> listeTestDao = daoProduit.produitsMultiCriteres("o", "i", 1, 1);
			for (Produit produit : listeTestDao) {
				System.out.println("produit : " + produit.getLibelleProduit());
			}
			Assert.assertTrue(listeTestDao != null);//résultat : ma liste n'est pas nulle
			Assert.assertTrue(listeTestDao.size() >0);//c'est ok

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	
	
}
