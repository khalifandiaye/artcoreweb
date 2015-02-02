package fr.afcepf.al22.artcore.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="mbExposition")
@SessionScoped
public class ExpositionManagedBean {
	List<Exposition> expos;
}
