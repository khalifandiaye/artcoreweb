/**
 * 
 */
package fr.afcepf.hal.controller.util;

import fr.afcepf.hal.controller.ContainerClass;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Hervé Alavoine
 *
 */
public class ConfigUtil {

		/**
		 * @param doc
		 * @return
		 */
		public Map parseAction(Document doc) {
			Map<String,ContainerClass> actionsMap = new HashMap<String, ContainerClass>();
			Map<String,String> listeForms =null;
			
			//retrieving from Map
			listeForms = parseForm(doc);
			//getting first Element dof XML
			Element root = doc.getDocumentElement();
			//on recupère les tags <action>
			NodeList nodeActions = root.getElementsByTagName("action");
			
			Node anAction= null;
			ContainerClass container = null;
			//pour chaque <action>
			for (int i = 0 ; i<nodeActions.getLength();i++) {
				anAction = nodeActions.item(i);
				/** on recupère les nodes sous l'action*/
				NodeList urlAction = anAction.getChildNodes();
				//on parse les nodes action-name url-pattern et form-name
				String actionName=null;
				String url=null;
				String formName=null;
				for (int j= 0 ; j<urlAction.getLength();j++) {
					Node tag = urlAction.item(j);
//					System.out.println("parsing tag "+tag.getNodeName()+" "+tag.getTextContent());
					if ("action-name".equalsIgnoreCase(tag.getNodeName())) {
//						System.out.println("action-name : "+tag.getTextContent());
						actionName = tag.getTextContent();
					} else if ("url-pattern".equalsIgnoreCase(tag.getNodeName())) {
//						System.out.println("url-pattern : "+tag.getTextContent());
						url = tag.getTextContent();
					} else if ("form-name".equalsIgnoreCase(tag.getNodeName())) {
//						System.out.println("form-name : "+tag.getTextContent());
						formName = tag.getTextContent();
					}			
				}
				if (url!=null) {
					container = new ContainerClass();
					container.setActionName(actionName);
//					System.out.println("retrive form-class  form-name "+listeForms.get(formName));
					container.setFormName(listeForms.get(formName));
					
					actionsMap.put(url, container);
				}
				
			}//fin for actions
			
			return actionsMap;
		}
		
		
		/**
		 * @param doc
		 * @return
		 */
		public Map parseForm(Document doc) {
			Map<String,String> formsMap = new HashMap<String, String>();
			Element root = doc.getDocumentElement();
			//on recupère les tags <action>
			NodeList nodeForms = root.getElementsByTagName("form");
			Node aForm= null;
			//pour chaque <action>
			for (int i = 0 ; i<nodeForms.getLength();i++) {
				aForm = nodeForms.item(i);
				/** on recupère les nodes sous form */
				NodeList formDef = aForm.getChildNodes();
				//on parse les nodes action-name url-pattern et form-name
				String formClass=null;
				String formName=null;
				for (int j= 0 ; j<formDef.getLength();j++) {
					Node tag = formDef.item(j);
//					System.out.println("parsing tag "+tag.getNodeName()+" "+tag.getTextContent());
					if ("form-class".equalsIgnoreCase(tag.getNodeName())) {
//						System.out.println("form-class : "+tag.getTextContent());
						formClass = tag.getTextContent();
					} else if("form-name".equalsIgnoreCase(tag.getNodeName())){
//						System.out.println("form-name : "+tag.getTextContent());
						formName = tag.getTextContent();
					}			
				}
				if (formClass!=null) {
					formsMap.put(formName,formClass);
				}
				
			}//fin for actions
			
			return formsMap;

		}
}
