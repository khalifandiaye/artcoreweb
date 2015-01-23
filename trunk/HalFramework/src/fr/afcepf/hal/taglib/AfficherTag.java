package fr.afcepf.hal.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AfficherTag extends TagSupport{
	private String attribute;
	@Override
	public int doStartTag() throws JspException {
		String valeur = "";
		try {
			valeur =
				pageContext.getRequest()
				.getAttribute(attribute).toString();
			pageContext.getOut().print(valeur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
