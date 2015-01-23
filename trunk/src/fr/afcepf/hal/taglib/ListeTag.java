package fr.afcepf.hal.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ListeTag extends TagSupport{
	private String type;
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print(
					"<ol type='"+type+"'>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print(
					"</ol>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
