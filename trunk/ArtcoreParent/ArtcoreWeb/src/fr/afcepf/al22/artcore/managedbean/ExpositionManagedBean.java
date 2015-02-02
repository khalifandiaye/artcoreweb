package fr.afcepf.al22.artcore.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al22.morphia.entity.Exposition;

@ManagedBean(name="mbExposition")
@SessionScoped
public class ExpositionManagedBean {
	List<Exposition> expos;
}
