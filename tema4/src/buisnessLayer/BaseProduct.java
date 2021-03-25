package buisnessLayer;

import modelLayer.Administrator;
import presentationLayer.AdministratorGUI;

/**
 * Clasa care creeaza retetele de baza
 * @author laurg
 *
 */
public class BaseProduct extends MenuItem{

	public BaseProduct() {
		Administrator a = new Administrator("1", "Varza cu ciolan afumat", "varza, ciolan, fum");
		AdministratorGUI.insertTable(a.getItem());
		Administrator a1 = new Administrator("2", "Cartofi prajiti", "cartofi, ulei, sare");
		AdministratorGUI.insertTable(a1.getItem());
		Administrator a2 = new Administrator("3", "Pizza cu de toate", "de toate");
		AdministratorGUI.insertTable(a2.getItem());
		Administrator a3 = new Administrator("4", "Supa", "apa, legume");
		AdministratorGUI.insertTable(a3.getItem());
	}
	
	
}
