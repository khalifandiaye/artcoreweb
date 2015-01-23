/**
 * 
 */
package fr.afcepf.hal.factory;


/**
 * @author Stagiaire
 *
 */
public class HalFactory {

	public Object getInstance(String classeName) {
		System.out.println("Je suis dans la factory");
		Class aClass=null;
		Object aObject= null;
		try {
			aClass = Class.forName(classeName);
		} catch (ClassNotFoundException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			 aObject = aClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return aObject;
	}
}
