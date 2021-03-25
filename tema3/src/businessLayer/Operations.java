package businessLayer;

import java.sql.*;

import dataAccessLayer.ConnectionFactory;

/**
 * Clasa in care se afla operatiile ce vor avea loc la nivelul bazei de date
 * 
 * @author laurg
 *
 */
public class Operations {

	/**
	 * Insereaza un client in baza de date
	 * 
	 * @param name    -numele clientului
	 * @param address -adresa clientului
	 */
	public static void insertClient(String name, String address) {
		System.out.println("Inserting Client: " + name);
		Connection db = ConnectionFactory.createConnection();
		final String statementString = "INSERT INTO client VALUES('" + name + "', '" + address + "');";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Stergerea unui client din baza de date
	 * 
	 * @param name -numele clientului
	 */
	public static void deleteClient(String name) {
		System.out.println("Deleting Client: " + name);
		Connection db = ConnectionFactory.createConnection();
		final String statementString = "DELETE FROM client WHERE nameC='" + name + "';";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Inserarea unui produs in baza de date
	 * 
	 * @param name     -numele produsului
	 * @param quantity -cantitatea produsului
	 * @param price    pretul produsului
	 */
	public static void insertProduct(String name, int quantity, double price) {
		System.out.println("Inserting Product: " + name);
		Connection db = ConnectionFactory.createConnection();
		final String statementString = "INSERT INTO product VALUES('" + name + "', " + quantity + ", " + price + ");";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Stergerea unui produs din baza de date
	 * 
	 * @param name -numele produsului
	 */
	public static void deleteProduct(String name) {
		System.out.println("Deleting Product: " + name);
		Connection db = ConnectionFactory.createConnection();
		final String statementString = "DELETE FROM product WHERE nameP='" + name + "';";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generarea unei comenzi si introducerea ei in baza de date
	 * 
	 * @param nameC               -numele clientului
	 * @param nameP-numele        produsului
	 * @param quantity-cantitatea produsului
	 */
	public static void createOrders(String nameC, String nameP, int quantity) {
		System.out.println("Creating Order for " + nameC);
		Connection db = ConnectionFactory.createConnection();
		final String statementString1 = "INSERT INTO orders VALUES('" + nameC + "', '" + nameP + "', " + quantity
				+ ");";
		final String statementString2 = "UPDATE product SET quantity=quantity-" + quantity + " WHERE nameP='" + nameP
				+ "';";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString1);
			st.executeUpdate(statementString2);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Stergerea tuturor datelor din tabelele bazei de date
	 */
	public static void clearAllTables() {

		Connection db = ConnectionFactory.createConnection();
		final String statementString1 = "DELETE FROM client;";
		final String statementString2 = "DELETE FROM product;";
		final String statementString3 = "DELETE FROM orders;";

		try {
			Statement st = db.createStatement();
			st.executeUpdate(statementString1);
			st.executeUpdate(statementString2);
			st.executeUpdate(statementString3);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Tables are empty!!!");
	}

}
