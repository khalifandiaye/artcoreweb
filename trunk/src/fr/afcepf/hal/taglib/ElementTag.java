package fr.afcepf.hal.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ElementTag extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("<li>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("</li>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
