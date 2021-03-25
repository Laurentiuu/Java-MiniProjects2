package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import buisnessLayer.MenuItem;
import buisnessLayer.Order;
import buisnessLayer.Restaurant;

/**
 * Clasa in care se genereaza interfata grafica pentru Utilizator
 * @author laurg
 *
 */
public class WaiterGUI {
	private JButton b1 = new JButton("Create new order");
	private JButton b2 = new JButton("Generate bill");
	private JButton b3 = new JButton("View menu");
	private JButton b4 = new JButton("View orders");

	private JLabel label1 = new JLabel("Meniu -> ");

	private static String[] data = new String[] { "", "" };
	private String[] columnNames = { "ID", "Data" };

	private static JTable table;
	static DefaultTableModel model = new DefaultTableModel();

	public int id = 0;

	View view;
	
	/*
	 * Metoda in care se genereaza butoanele,text field-urile, etc
	 */
	public WaiterGUI(View view) {
		this.view = view;
		model.addColumn(columnNames[0]);
		model.addColumn(columnNames[1]);

		table = new JTable(model);
		table.setModel(model);

		view.addWaiterListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.removeAll();
				b1.setBounds(20, 120, 300, 30);
				b1.setFont(new java.awt.Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b1);

				b2.setBounds(20, 170, 300, 30);
				b2.setFont(new java.awt.Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b2);

				b3.setBounds(20, 220, 300, 30);
				b3.setFont(new java.awt.Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b3);

				b4.setBounds(20, 270, 300, 30);
				b4.setFont(new java.awt.Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b4);

				label1.setBounds(100, 0, 500, 100);
				label1.setFont(new java.awt.Font("TimesRoman", Font.BOLD | Font.ITALIC, 40));
				view.addButtons(label1);

				JScrollPane sp = new JScrollPane(AdministratorGUI.getTable());
				view.addTable(sp);

			}
		});

		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				id++;
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String data = dtf.format(now).toString();
				Order order = new Order();
				order.setDate(data);
				order.setOrderID(String.valueOf(id));
				WaiterGUI.insertTable(order);
				JOptionPane.showMessageDialog(new JFrame(), "Ai de preparat o noua comanda", "Bucatar",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int numRows = table.getSelectedRows().length;
				for (int i = 0; i < numRows; i++) {

					int id = table.getSelectedRow() + 1;

					Document document = new Document();
					try {
						PdfWriter.getInstance(document, new FileOutputStream("Factura comanda" + id + ".pdf"));

						document.open();
						Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
						Chunk chunk = new Chunk("Factura", font);
						chunk.setLineHeight(50);
						document.add(chunk);

						font = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLACK);
						Chunk chunk1 = new Chunk("\n\n\nPret total: " + Order.pretComanda, font);
						chunk1.setLineHeight(50);
						document.add(chunk1);

						document.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JScrollPane sp = new JScrollPane(AdministratorGUI.getTable());
				view.addTable(sp);

			}
		});

		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JScrollPane sp = new JScrollPane(table);
				view.addTable(sp);
			}
		});

	}
	
	/**
	 * Operatia de adugare unei comenzi in tabel
	 */
	public static void insertTable(Order order) {

		data[0] = order.getOrderID();
		data[1] = order.getDate();
		
		int numRows = AdministratorGUI.getTable().getSelectedRows().length;
		for (int i = 0; i < numRows; i++) {
			Order.pretComanda+=MenuItem.getPret();
			Restaurant.addOrder(order, Order.getItems());
		}
		
		model.addRow(new Object[] { data[0], data[1] });

		data[0] = "";
		data[1] = "";

	}

}
