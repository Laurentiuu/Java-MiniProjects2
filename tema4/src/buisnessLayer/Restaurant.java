package buisnessLayer;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Clasa in care se afla comenzile de la utilizatori
 * Comenzile sut stocate intr-o tabela de dispersie pentru acces mai rapid(HashMap)
 */
public class Restaurant {

	private static HashMap<Order, ArrayList<MenuItem>> order = new HashMap<Order, ArrayList<MenuItem>>();

	public static void addOrder(Order o, ArrayList<MenuItem> i) {
		order.put(o, i);
	}

}
