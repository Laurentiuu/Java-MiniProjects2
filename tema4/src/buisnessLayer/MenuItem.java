package buisnessLayer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clasa care creaza o reteta si genereaza pretul
 * @author laurg
 *
 */
public class MenuItem {

	public String nr;
	public String nume;
	public ArrayList<String> ingrediente;
	private static int pret=0;

	
	public MenuItem(String nr, String nume, ArrayList<String> ingrediente) {
		this.nr = nr;
		this.nume = nume;
		this.ingrediente = ingrediente;
		computePrice();
	}

	public MenuItem() {
		this.nr = "";
		this.nume = "";
	}
	
	/**
	 * metoda care genereaza pretul
	 * @return
	 */
	public int computePrice() {
		Random rand = new Random();
		
		int min=10;
		int max=100;
		pret=rand.nextInt((max - min) + 1) + min;
		Order.pretComanda+=pret;
		return pret;
		
	}

	public void removeIngr() {
		ingrediente.clear();
	}

	public static int getPret() {
		return pret;
	}	
	
	
}
