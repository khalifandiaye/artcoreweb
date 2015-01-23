package fr.afcepf.al22.gestionpersonne.test;

import java.util.List;

import fr.afcepf.al22.gestionpersonne.dao.DaoPersonneImpl;
import fr.afcepf.al22.gestionpersonne.dao.IDaoPersonne;
import fr.afcepf.al22.gestionpersonne.entity.Personne;

public class TestDao {
	public static void main(String[] args) {
		Personne pers = new Personne();
		IDaoPersonne dao = new DaoPersonneImpl();
		System.out.println(dao.rechercher("C"));
		List<Personne> liste = dao.rechercher("C");
		
		for (Personne p : liste) {
			System.out.println(p.getNom());
		}
	}
}
