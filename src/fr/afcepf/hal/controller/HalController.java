package fr.afcepf.hal.controller;

import fr.afcepf.hal.action.ActionForm;
import fr.afcepf.hal.controller.util.BeanPopulate;
import fr.afcepf.hal.controller.util.ConfigUtil;
import fr.afcepf.hal.factory.HalFactory;
import fr.afcepf.hal.form.BeanForm;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Herve Alavoine
 *
 */
public class HalController extends HttpServlet {
	private String baseUrl;
	private Map<String,ContainerClass>  urlActionsForms;

	/**
	 * @return the urlForms
	 */
	public Map getUurlActionsForms() {
		return urlActionsForms;
	}

	/**
	 * @param urlForms the urlForms to set
	 */
	public void setUurlActionsForms(Map aUrlActionsForms) {
		this.urlActionsForms = aUrlActionsForms;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
//		String uri = request.getRequestURI();
//		System.out.println("uri "+uri);
//		String url = uri.substring(uri.lastIndexOf("/"));
//		System.out.println("url "+url);
//		ContainerClass action = urlActionsForms.get(url);
//		System.out.println("Action .... "+action.getActionName()+" "+action.getFormName());
//		//FIXME on populate puis on execute l'action
//		
//		HalFactory factory = new HalFactory();
//		BeanForm myForm = (BeanForm) factory.getInstance(action.getFormName());
//		if (myForm!=null) {
//			System.out.println("validate bean "+myForm.validateForm());
//			if (myForm.validateForm()) {
//				ActionForm myAction = (ActionForm) factory.getInstance( action.getActionName());
//				myAction.execute(myForm,request,response);
//			}
//		} else {
//			System.out.println("MyForm is null !!!");
//		}
		//Map<java.lang.String,java.lang.String[]> param = request.getParameterMap();
		
		//action.getForm().validate();
		
		
		
		
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("****************DO POST******************");
		String uri = request.getRequestURI();
		//System.out.println("uri "+uri);
		String url = uri.substring(uri.lastIndexOf("/"));
		System.out.println("url "+url);
		ContainerClass action = urlActionsForms.get(url);
		System.out.println("Action .... "+action.getActionName()+" "+action.getFormName());
		//FIXME on populate puis on execute l'action
		
		HalFactory factory = new HalFactory();
		Object myForm = factory.getInstance(action.getFormName());
		//System.out.println("Object myForm "+myForm);
		// Récupération des paramètres vers Map
		
		Map<String,String> param = parameterToMap(request);
		BeanPopulate pop = new BeanPopulate();
		pop.populateForm(param, myForm);
		BeanForm bean = (BeanForm)myForm;
		String redirection ="/erreur404.jsp";
		if (bean.validateForm()) {
			ActionForm myAction = (ActionForm) factory.getInstance(action.getActionName());
			redirection = myAction.execute(bean,request,response);
		};
		
		System.out.println("j'ai fais des modif");
		System.out.println("Je fais une redirection.... "+redirection);
		request.getRequestDispatcher(redirection)
		   .forward(request, response);
		
	}
	public Map<String,String> parameterToMap(HttpServletRequest request) {
		Map<String,String> ret = new HashMap<>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paramValue = request.getParameter(paramName);
			//System.out.println("ParamName : "+paramName+" ParamValue : "+paramValue);
			ret.put(paramName, paramValue);
		}
		return ret;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		
		super.destroy();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		this.urlActionsForms = new HashMap<String,ContainerClass>();
		InputStream stream  = getServletContext().getResourceAsStream("/WEB-INF/hal-config.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		ConfigUtil conf = new ConfigUtil();
		
		try {
			
			builder = factory.newDocumentBuilder();
			Document document  = builder.parse(stream);
			System.out.println("On parse Actions");
			this.urlActionsForms = conf.parseAction(document);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
			
		super.init();
	}
	
	
		
}
