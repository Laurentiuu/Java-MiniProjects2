package buisnessLayer;

import java.util.ArrayList;

/**
 * Clasa care creeaza o comanda si face operatii pe aceasta(insert, edit, delete)
 * Este formata din id, data si un ArrayList in care sunt stocate retetele(items)
 * @author laurg
 *
 */
public class Order {

	private String orderID;
	private String date;
	private static ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	public static int pretComanda=0;

	/**
	 * Metoda ce adauga o reteta
	 * @param item
	 */
	public static void addItem(MenuItem item) {
		items.add(item);
	}

	/**
	 * Metoda ce sterge o reteta
	 * @param item
	 */
	public static void removeItem(MenuItem item) {
		int j = 0;
		for (MenuItem i : items) {
			if (i.nr == item.nr) {
				items.remove(j);
				break;
			}
			j++;
		}
	}
	
	/**
	 * Metoda ce modifica o reteta
	 * @param item
	 * @param item1
	 */
	public static void editItem(MenuItem item, MenuItem item1) {
		int j = 0;
		for (MenuItem i : items) {
			if (i.nr == item1.nr) {
				items.set(j, item);
				break;
			}
			j++;
		}
	}

	public String getOrderID() {
		return orderID;
	}

	public String getDate() {
		return date;
	}

	public static ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static void setItems(ArrayList<MenuItem> items) {
		Order.items = items;
	}
	
	
}
