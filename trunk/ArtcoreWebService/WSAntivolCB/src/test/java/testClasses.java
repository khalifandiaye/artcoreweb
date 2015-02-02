import fr.afcepf.al22.antivol.AntivolCBImpl;
import fr.afcepf.al22.antivol.IAntivolCB;


public class testClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IAntivolCB antivol = new AntivolCBImpl();
		boolean b = antivol.rechercheCBVoleeParNumero("1234123412341234");
	}

}
