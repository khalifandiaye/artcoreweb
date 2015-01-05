import fr.afcepf.al22.entities.Cartebleue;
import fr.afcepf.al22.wsartcore.AntivolCBImpl;
import fr.afcepf.al22.wsartcore.IAntivolCB;


public class testClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IAntivolCB antivol = new AntivolCBImpl();
		boolean b = antivol.rechercheCBVoleeParNumero("1234123412341234");
//		System.out.println(b);
	}

}
