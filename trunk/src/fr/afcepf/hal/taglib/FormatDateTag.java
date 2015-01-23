package fr.afcepf.hal.taglib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FormatDateTag extends TagSupport{
	private Date monAtttr;
	@Override
	public int doStartTag() throws JspException {
		String formatedDate ="pas glop";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (monAtttr!=null) {
			formatedDate = sdf.format(monAtttr);
		} else {
			System.out.println("mon attr est null "+monAtttr);
		}
		try {
			pageContext.getOut().print(formatedDate);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public Date getMonAtttr() {
		return monAtttr;
	}
	public void setMonAtttr(Date value) {
		this.monAtttr = value;
	}
}
