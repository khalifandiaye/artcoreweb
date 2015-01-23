package fr.afcepf.hal.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloWithAttributeTag extends TagSupport{
	private String name;
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hello " + name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
