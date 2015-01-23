/**
 * 
 */
package fr.afcepf.hal.controller.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**Depuis l'enumeration des paramaetres nom et valeur on populate les formBean par introspection.
 * @author Stagiaire
 *
 */
public class BeanPopulate {

	/**convert all field to boolean, byte, short, int, long, char, float, and double primitive fields.
	 * and set value with corresponding setter.
	 * @param parameterNames
	 * @return
	 */
	public Object populateForm(Map<String,String> parameterNames, Object myForm) {
		
		//Class c = myForm.getClass();
		
		for (Map.Entry<String,String> entry : parameterNames.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("ooooooooooooo populateForm oooooooooooooooooo");
			System.out.println("populateForm parameter key "+key+" value "+value);
			populate(key,value,myForm);

		}
		return myForm;
	}
	
	private void populate(String key,String value,Object form) {
		System.out.println("ooooooooooooo populate oooooooooooooooooo");
		System.out.println("KEY "+key+" VALUE "+value);
		Map<String,Method> mapMethode = new HashMap<String,Method>();
		try {
			Method[] listeM = form.getClass().getMethods();

			//System.out.println("pass t'on par  la ? "+listeM.length);

			for(int i=0 ; i<listeM.length ;i++) {
				//System.out.println(listeM[i].getName()+" "+listeM[i].toGenericString());
				mapMethode.put(listeM[i].getName(), listeM[i]);
			}

		} catch (SecurityException e) {
			e.printStackTrace();
		}
		if (-1==key.indexOf('.')) {
			String methode = "set"+getCamelCase(key);
			System.out.println("methode : "+methode);
			Method m = mapMethode.get(methode);
			if (m!=null) {
				Class[] parameterTypes = m.getParameterTypes();
				System.out.println("parametre 1 "+parameterTypes[0].getName());
				convertInvoke(form,m,parameterTypes[0].getName(),value);
			}
		} else {
			//System.out.println("La clef a spliter !!!!"+key);
			int index = key.indexOf('.');
			//System.out.println("index "+index);
			String keyComplex1 = key.substring(0,index); 
			String keyComplex2 = key.substring(index+1);
			System.out.println("Split key "+key+" keyComplex1 "+keyComplex1+" keyComplex2 "+keyComplex2);
			
			String methode = "get"+getCamelCase(keyComplex1);
			System.out.println("********sous methode "+methode+"*****************");
			Method m = mapMethode.get(methode);
			try {
				Object fils = m.invoke(form, null);
				System.out.println("fils est "+fils);
				if (fils!=null) {
					System.out.println("fils "+fils.getClass().getName());
					populate(keyComplex2,value,fils);
				} else {
					System.out.println("Fils est null !!!! ");
				}
				
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void convertInvoke(Object o,Method m,String attr,String value) {
		System.out.println("convertInvoke : m "+m.getName()+" attr "+attr+" value "+value + " object " + o.getClass().getName());
		try {
			switch(attr) {
			case "java.lang.String":
				m.invoke(o, new Object[] {value});
				break;
			case "java.lang.Integer":
				m.invoke(o, new Object[] {Integer.valueOf(value)});
				break;
			case "java.lang.Double":
				m.invoke(o, new Object[] {Double.valueOf(value)});
				break;
			case "java.lang.Short":
				m.invoke(o, new Object[] {Short.valueOf(value)});
				break;
			case "java.lang.Long":
				m.invoke(o, new Object[] {Long.valueOf(value)});
				break;
			case "java.lang.Float":
				m.invoke(o, new Object[] {Float.valueOf(value)});
				break;
			case "java.lang.Boolean":
				m.invoke(o, new Object[] {Boolean.valueOf(value)});
				break;
			case "int":
				m.invoke(o, new Object[]{Integer.parseInt(value)});
				break;
			case "boolean":
				m.invoke(o, new Object[]{Boolean.parseBoolean(value)});
				break;
			case "short":
				m.invoke(o, new Object[]{Short.parseShort(value)});
				break;
			case "long":
				m.invoke(o, new Object[]{Long.parseLong(value)});
				break;
			case "float":
				m.invoke(o, new Object[]{Float.parseFloat(value)});
				break;
			case "double":
				m.invoke(o, new Object[]{Double.parseDouble(value)});
				break;
			case "char":
				m.invoke(o, new Object[]{value.charAt(0)});
				break;

			}
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	private String getCamelCase(String key) {
		return key.substring(0, 1).toUpperCase() + key.substring(1);
	}
}
