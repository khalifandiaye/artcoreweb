package fr.afcepf.hal.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Hello Tag World !!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
