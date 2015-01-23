/**
 * 
 */
package test.controleur.util;

import fr.afcepf.hal.controller.ContainerClass;
import fr.afcepf.hal.controller.util.ConfigUtil;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Stagiaire
 *
 */
public class TestXml {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		ConfigUtil conf = new ConfigUtil();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
	
			Document document  = builder.parse("src/hal-config.xml");
			System.out.println("On parse Actions");
			Map<String,ContainerClass> action = conf.parseAction(document);
//			System.out.println("On parse forms");
//			Map<String,String> forms = conf.parseForm(document);
			System.out.println("****************************print action Map**********************");
			for (Map.Entry<String,ContainerClass> entry : action.entrySet()) {
			    String key = entry.getKey();
			    ContainerClass value = entry.getValue();
			    System.out.println("action : "+key+" "+value.getActionName()+" "+value.getFormName());
			}
//			System.out.println("****************************print form Map**********************");
//			for (Map.Entry<String,String> entry : forms.entrySet()) {
//			    String key = entry.getKey();
//			    String value = entry.getValue();
//			    System.out.println("form : "+key+" "+value);
//			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
