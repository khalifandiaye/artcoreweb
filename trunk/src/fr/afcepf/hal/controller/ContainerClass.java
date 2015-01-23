/**
 * 
 */
package fr.afcepf.hal.controller;

/**
 * @author Stagiaire
 *
 */
public class ContainerClass {
	private String actionName;
	private Class action;
	private String formName;
	private Class form;
	
	
	/**
	 * @return the url
	 */
	public String getActionName() {
		return actionName;
	}
	/**
	 * @param url the url to set
	 */
	public void setActionName(String url) {
		this.actionName = url;
	}
	/**
	 * @return the action
	 */
	public Class getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(Class action) {
		this.action = action;
	}
	/**
	 * @return the formName
	 */
	public String getFormName() {
		return formName;
	}
	/**
	 * @param formName the formName to set
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}
	/**
	 * @return the form
	 */
	public Class getForm() {
		return form;
	}
	/**
	 * @param form the form to set
	 */
	public void setForm(Class form) {
		this.form = form;
	}
	
}
