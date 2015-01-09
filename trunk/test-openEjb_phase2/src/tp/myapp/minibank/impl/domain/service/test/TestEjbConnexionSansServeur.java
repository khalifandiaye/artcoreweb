package tp.myapp.minibank.impl.domain.service.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al22.artcore.daointerfaces.IDaoConnexion;
import fr.afcepf.al22.artcore.entities.Utilisateur;



public class TestEjbConnexionSansServeur extends MyAbstractOpenEjbTest{
	
    //service (ejb) a� tester
	private IDaoConnexion service;
	
	  @Before
	     public void initService(){
	       if(service==null){
	         try{
	           //String openEjbJndiName="EjbApp1Impl" + "Local";
	           String openEjbJndiName="DaoConnexionImpl" + "Remote";
	           service= (IDaoConnexion)                
	                context.lookup(openEjbJndiName);
			}catch(Exception ex){ex.printStackTrace();}
		}
	      }
	
	
	@Test
	public void testGetClientByNum(){
		try {
			Utilisateur user = service.connexion("a", "a");
			System.out.println(user.toString());
			Assert.assertTrue(user != null);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}
	
	
	
	
	
}
