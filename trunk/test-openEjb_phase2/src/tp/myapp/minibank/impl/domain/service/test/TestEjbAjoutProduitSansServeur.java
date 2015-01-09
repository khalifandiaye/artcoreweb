package tp.myapp.minibank.impl.domain.service.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.afcepf.al22.artcore.businessinterfaces.IBusinessProduit;
import fr.afcepf.al22.artcore.daointerfaces.IDaoCategorie;
import fr.afcepf.al22.artcore.daointerfaces.IDaoFormat;
import fr.afcepf.al22.artcore.daointerfaces.IDaoProduit;
import fr.afcepf.al22.artcore.daointerfaces.IDaoRechercherProduit;
import fr.afcepf.al22.artcore.daointerfaces.IDaoTva;
import fr.afcepf.al22.artcore.entities.Produit;

public class TestEjbAjoutProduitSansServeur extends MyAbstractOpenEjbTest {

	//service (ejb) a� tester
		private IDaoProduit daoProduit;
		private IDaoCategorie daoCategorie;
		private IDaoFormat daoFormat;
		private IDaoTva daoTva;
//		private IBusinessProduit buProduit; 
		
		  @Before
		     public void initService(){
			  if (daoProduit==null){
//		       if(buProduit==null){
		         try{
		           String openEjbJndiName="DaoProduitImpl" + "Remote";
//		           String openEjbJndiName="BusinessProduitImpl" + "Remote";
		           daoProduit= (IDaoProduit)                
			                context.lookup(openEjbJndiName);
//		           buProduit= (IBusinessProduit)                
//		                context.lookup(openEjbJndiName);
				}catch(Exception ex){ex.printStackTrace();}
			  }
		         if (daoCategorie==null){
//				       if(buProduit==null){
				         try{
				           String openEjbJndiName="DaoCategorieImpl" + "Remote";
//				           String openEjbJndiName="BusinessProduitImpl" + "Remote";
				           daoCategorie= (IDaoCategorie)                
					                context.lookup(openEjbJndiName);
//				           buProduit= (IBusinessProduit)                
//				                context.lookup(openEjbJndiName);
						}catch(Exception ex){ex.printStackTrace();}
		         }
				         if (daoFormat==null){
//						 if(buProduit==null){
						         try{
						           String openEjbJndiName="DaoFormatImpl" + "Remote";
//						           String openEjbJndiName="BusinessProduitImpl" + "Remote";
						           daoFormat= (IDaoFormat)                
							                context.lookup(openEjbJndiName);
//						           buProduit= (IBusinessProduit)                
//						                context.lookup(openEjbJndiName);
								}catch(Exception ex){ex.printStackTrace();}
				         }
						         if (daoTva==null){
//								       if(buProduit==null){
								         try{
								           String openEjbJndiName="DaoTvaImpl" + "Remote";
//								           String openEjbJndiName="BusinessProduitImpl" + "Remote";
								           daoTva= (IDaoTva)                
									                context.lookup(openEjbJndiName);
//								           buProduit= (IBusinessProduit)                
//								                context.lookup(openEjbJndiName);
										}catch(Exception ex){ex.printStackTrace();
										}
										}
						       
		      }
		
		
		@Test
		public void testGetClientByNum(){
			try {
				
				Produit testDaoProduit = new Produit();
				testDaoProduit.setLibelleProduit("test");
				testDaoProduit.setCategorie(daoCategorie.categorieParId(1));
				testDaoProduit.setFormat(daoFormat.formatParId(1));
				testDaoProduit.setTva(daoTva.tvaParId(1));
				testDaoProduit.setPrixProduit(BigDecimal.valueOf(1500));
				testDaoProduit.setDescriptionProduit("produit test d'ajout");
				testDaoProduit.setImageProduit("imageProduit");
				testDaoProduit.setNomArtiste("artiste");
				testDaoProduit.setStock(1);
				Produit p = daoProduit.creer(testDaoProduit);
						//methode creer avec date debut de vente = new date
				Assert.assertTrue(p != null);
				

			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
		}
		
		
		
		
		
	}
