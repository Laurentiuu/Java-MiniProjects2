package presentationLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dataAccessLayer.ConnectionFactory;

/**
 * Clasa in care se genereaza fisierele PDF
 * 
 * @author laurg
 *
 */
public class PDFgenerator {

	private static int clientCount = 1;
	private static int productCount = 1;
	private static int orderCount = 1;
	private static int billCount = 1;

	/**
	 * Metoda ce genereaza un PDF pentru un client. Mai exact se citesc datele din
	 * tabelul client si se pun intr-un tabel
	 */
	public static void reportClient() {
		Document document = new Document();
		PdfPTable table = new PdfPTable(2);

		try {
			PdfWriter.getInstance(document, new FileOutputStream("Report clients " + clientCount + ".pdf"));

			document.open();

			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);

			header.setPhrase(new Phrase("Nume client"));
			table.addCell(header);

			header.setPhrase(new Phrase("Adresa"));
			table.addCell(header);

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection db = ConnectionFactory.createConnection();
		final String selectStatement = "SELECT * FROM client;";
		ResultSet rs = null;

		Statement st;
		try {
			st = db.prepareStatement(selectStatement);
			rs = st.executeQuery(selectStatement);
			while (rs.next()) {

				String nameC = rs.getString("nameC");
				String address = rs.getString("address");

				PdfPCell cell1 = new PdfPCell();
				cell1.setBorderWidth(2);
				cell1.setPhrase(new Phrase(nameC));
				table.addCell(cell1);

				PdfPCell cell2 = new PdfPCell();
				cell2.setBorderWidth(2);
				cell2.setPhrase(new Phrase(address));
				table.addCell(cell2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		clientCount++;

	}

	/**
	 * Metoda ce genereaza un PDF pentru un produs. Mai exact se citesc datele din
	 * tabelul product si se pun intr-un tabel
	 */
	public static void reportProduct() {
		Document document = new Document();
		PdfPTable table = new PdfPTable(3);

		try {
			PdfWriter.getInstance(document, new FileOutputStream("Report products " + productCount + ".pdf"));

			document.open();

			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);

			header.setPhrase(new Phrase("Nume Produs"));
			table.addCell(header);

			header.setPhrase(new Phrase("Cantitate"));
			table.addCell(header);

			header.setPhrase(new Phrase("Pret"));
			table.addCell(header);

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection db = ConnectionFactory.createConnection();
		final String selectStatement = "SELECT * FROM product;";
		ResultSet rs = null;

		Statement st;
		try {
			st = db.prepareStatement(selectStatement);
			rs = st.executeQuery(selectStatement);
			while (rs.next()) {

				String nameP = rs.getString("nameP");
				String quantity = rs.getString("quantity");
				String price = rs.getString("price");

				PdfPCell cell1 = new PdfPCell();
				cell1.setBorderWidth(2);
				cell1.setPhrase(new Phrase(nameP));
				table.addCell(cell1);

				PdfPCell cell2 = new PdfPCell();
				cell2.setBorderWidth(2);
				cell2.setPhrase(new Phrase(quantity));
				table.addCell(cell2);

				PdfPCell cell3 = new PdfPCell();
				cell3.setBorderWidth(2);
				cell3.setPhrase(new Phrase(price));
				table.addCell(cell3);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		productCount++;
	}

	/**
	 * Metoda ce genereaza un PDF pentru o comanda. Mai exact se citesc datele din
	 * tabelul order si se pun intr-un tabel
	 */
	public static void reportOrder() {
		Document document = new Document();
		PdfPTable table = new PdfPTable(3);

		try {
			PdfWriter.getInstance(document, new FileOutputStream("Report orders " + orderCount + ".pdf"));

			document.open();

			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);

			header.setPhrase(new Phrase("Nume Client"));
			table.addCell(header);

			header.setPhrase(new Phrase("Nume Produs"));
			table.addCell(header);

			header.setPhrase(new Phrase("Cantitate"));
			table.addCell(header);

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection db = ConnectionFactory.createConnection();
		final String selectStatement = "SELECT * FROM orders;";
		ResultSet rs = null;

		Statement st;
		try {
			st = db.prepareStatement(selectStatement);
			rs = st.executeQuery(selectStatement);
			while (rs.next()) {

				String nameC = rs.getString("nameC");
				String nameP = rs.getString("nameP");
				String quantity = rs.getString("quantity");

				PdfPCell cell1 = new PdfPCell();
				cell1.setBorderWidth(2);
				cell1.setPhrase(new Phrase(nameC));
				table.addCell(cell1);

				PdfPCell cell2 = new PdfPCell();
				cell2.setBorderWidth(2);
				cell2.setPhrase(new Phrase(nameP));
				table.addCell(cell2);

				PdfPCell cell3 = new PdfPCell();
				cell3.setBorderWidth(2);
				cell3.setPhrase(new Phrase(quantity));
				table.addCell(cell3);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			document.add(table);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();
		orderCount++;
	}

	/**
	 * Metoda ce genereaza o factura. Aceasta metoda afiseaza numele clientului,
	 * produsul cumparat si cantitatea Pretul total este calculat si este afisat si
	 * el
	 * 
	 */
	public static void createBill(String nameC, String nameP, int quantity) {
		Document document = new Document();
		double totalPrice = 0;

		Connection db = ConnectionFactory.createConnection();
		final String statement = "SELECT * FROM product WHERE nameP='" + nameP + "';";
		ResultSet rs = null;

		Statement st;
		try {
			st = db.prepareStatement(statement);
			rs = st.executeQuery(statement);
			rs.next();

			double price = Double.parseDouble(rs.getString("price"));
			totalPrice = price * (double) quantity;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			PdfWriter.getInstance(document, new FileOutputStream("bill" + billCount + ".pdf"));

			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Client: " + nameC + "\n" + "Produs: " + nameP + "\nCantitate: " + quantity, font);
			chunk.setLineHeight(50);
			document.add(chunk);

			font = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
			Chunk chunk1 = new Chunk("\n\n\nPret total: " + totalPrice, font);
			chunk1.setLineHeight(50);
			document.add(chunk1);

			document.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		billCount++;
	}

}
