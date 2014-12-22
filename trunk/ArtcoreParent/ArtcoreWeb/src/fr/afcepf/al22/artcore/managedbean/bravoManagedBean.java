package fr.afcepf.al22.artcore.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.artcore.dto.DtoClient;

@ManagedBean
@RequestScoped
public class bravoManagedBean {

	@ManagedProperty(value="#{confirmerCmdManageBean.message}")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
