/**
 * 
 */
package fr.afcepf.hal.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.hal.form.BeanForm;

/**
 * @author Stagiaire
 *
 */
public interface ActionForm {

	public String execute(BeanForm form,HttpServletRequest request,HttpServletResponse response);
}
