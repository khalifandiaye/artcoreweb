package fr.afcepf.hal.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class BoucleTag extends BodyTagSupport{
	private int nb;
	private int cpt;
	@Override
	public int doStartTag() throws JspException {
		cpt = 0;
		return Tag.EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		if(++cpt < nb) {
			return IterationTag.EVAL_BODY_AGAIN;
		}
		return Tag.SKIP_BODY;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	
}
