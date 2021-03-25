package buisnessLayer;

import presentationLayer.AdministratorGUI;
import presentationLayer.View;
import presentationLayer.WaiterGUI;

/**
 * Clasa Main
 * @author laurg
 *
 */
public class MainClass {

	public static void main(String[] args) {
		//java -jar PT2020_30226_Galis_Laurentiu_Assignment_4.jar
		View view=new View();
		new AdministratorGUI(view);
		new BaseProduct();
		new WaiterGUI(view);
		
	}
}
