package presentationLayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import businessLayer.Operations;

/**
 * Clasa in care are loc citirea din fisier
 * 
 * @author laurg
 *
 */
public class ReadFromFile {

	/**
	 * In acest construtor se afiseaza calea catre fisierul de tip text si se
	 * extrage datele din el Datele sunt sub forma de instructiuni: -Insert Client,
	 * -Delete CLient, -Insert Product, -Delete Product, -Order, -Report client,
	 * Report product, Report Order
	 * 
	 * @param inputFile -numele fisierului text
	 */
	public ReadFromFile(String inputFile) {

		try {
			File f = new File(inputFile);
			String path = new String();
			if (f.exists()) {
				path = f.getAbsolutePath();
				System.out.println("File path: " + path + "\n");
			}

			File file = new File(path);
			Scanner s = new Scanner(file);
			while (s.hasNextLine()) {
				String a = s.nextLine();

				if (a.equals("Report client")) {
					PDFgenerator.reportClient();
					continue;
				}

				if (a.equals("Report product")) {
					PDFgenerator.reportProduct();
					continue;
				}

				if (a.equals("Report order")) {
					PDFgenerator.reportOrder();
					continue;
				}

				if (a.substring(0, 13).equals("Insert client")) {
					a = a.substring(15, a.length());
					String name = a.substring(0, a.indexOf(','));
					a = a.substring(a.indexOf(',') + 2, a.length());
					String address = a;
					Operations.insertClient(name, address);
					continue;
				}

				if (a.substring(0, 13).equals("Delete client")) {
					a = a.substring(15, a.length());
					String name = a.substring(0, a.indexOf(','));
					Operations.deleteClient(name);
					continue;
				}

				if (a.substring(0, 14).equals("Insert product")) {
					a = a.substring(16, a.length());
					String name = a.substring(0, a.indexOf(','));
					a = a.substring(a.indexOf(',') + 2, a.length());
					int quantity = Integer.parseInt(a.substring(0, a.indexOf(',')));
					a = a.substring(a.indexOf(',') + 2, a.length());
					double price = Double.parseDouble(a);
					Operations.insertProduct(name, quantity, price);
					continue;
				}

				if (a.substring(0, 14).equals("Delete Product")) {
					String name = a.substring(16, a.length());
					Operations.deleteProduct(name);
					continue;
				}

				if (a.substring(0, 5).equals("Order")) {
					a = a.substring(7, a.length());
					String nameC = a.substring(0, a.indexOf(','));
					a = a.substring(a.indexOf(',') + 2, a.length());
					String nameP = a.substring(0, a.indexOf(','));
					a = a.substring(a.indexOf(',') + 2, a.length());
					int quantity = Integer.parseInt(a);
					Operations.createOrders(nameC, nameP, quantity);
					PDFgenerator.createBill(nameC, nameP, quantity);
					continue;
				}

			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
}
