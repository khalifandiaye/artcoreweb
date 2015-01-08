package tp.myapp.minibank.impl.domain.service.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.BeforeClass;

public abstract class MyAbstractOpenEjbTest {
	
	protected static Context context; // jndi context for open-ejb
	
	private static final String TEST_OPENEJB_DS="java:jboss/datasources/artcore";//"App1DS";
	//private static final String TEST_OPENEJB_DS="java:/MinibankDS"; //le prefixe java:/ de jboss pose problème à OpenEJB
	
	/* equivalent dans standalone.xml : 
		<datasource jndi-name="java:jboss/datasources/App1DS" pool-name="App1DS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/app1</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                        <password>afcepf</password>
                    </security>
                </datasource>
	 */
	
	
	@BeforeClass
	public static void initializeEmbeddedContainer() throws Exception {
	    Properties properties = new Properties();
	    properties.setProperty(Context.INITIAL_CONTEXT_FACTORY,
	        "org.apache.openejb.client.LocalInitialContextFactory");

	    properties.put(TEST_OPENEJB_DS, "new://Resource?type=DataSource");
	    
	    properties.put(TEST_OPENEJB_DS+".JdbcDriver", "com.mysql.jdbc.Driver");
	    properties
	        .put(TEST_OPENEJB_DS+".JdbcUrl", "jdbc:mysql://localhost:3306/artcore");
	    properties.put(TEST_OPENEJB_DS+".username", "root");
	    properties.put(TEST_OPENEJB_DS+".password", "root");//afcepf ou root, en fonction du pc
	    //properties.put("produits_db_TestDS.JtaManaged", "false");
	    

	    
	    properties.put("openejb.embedded.initialcontext.close", "destroy");

	    context = new InitialContext(properties);
	  }
	
	  public abstract void initService();


}
