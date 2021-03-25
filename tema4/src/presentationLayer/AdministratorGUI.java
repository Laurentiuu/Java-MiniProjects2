package presentationLayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import buisnessLayer.MenuItem;
import buisnessLayer.Order;
import modelLayer.Administrator;

/**
 * Clasa in care se genereaza interfata grafica pentru Administrator
 * @author laurg
 *
 */
public class AdministratorGUI {

	private JButton b1 = new JButton("Create new item");
	private JButton b2 = new JButton("Delete item");
	private JButton b3 = new JButton("Edit item");

	private JLabel label1 = new JLabel("Number: ");
	private JLabel label2 = new JLabel("Nume: ");
	private JLabel label3 = new JLabel("Ingrediente: ");
	private JLabel label4 = new JLabel("*Stergerea si editarea se face prin selectarea randului");
	private JLabel label5 = new JLabel("*Ctrl + click: selectarea mai multor retete simultan");

	private static JTextField text1 = new JTextField("");
	private static JTextField text2 = new JTextField("");
	private static JTextField text3 = new JTextField("");

	private static String[] data = new String[] { "", "", "" };
	private String[] columnNames = { "Nr.", "Nume", "Ingrediente" };

	private static JTable table;
	static DefaultTableModel model = new DefaultTableModel();

	View view;

	public AdministratorGUI() {

	}
	
	/*
	 * Metoda in care se genereaza butoanele,text field-urile, etc
	 */
	public AdministratorGUI(View view) {
		this.view = view;
		model.addColumn(columnNames[0]);
		model.addColumn(columnNames[1]);
		model.addColumn(columnNames[2]);

		table = new JTable(model);
		table.setModel(model);

		view.addAdministratorListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.removeAll();

				b1.setBounds(20, 120, 300, 30);
				b1.setFont(new Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b1);

				b2.setBounds(20, 170, 300, 30);
				b2.setFont(new Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b2);

				b3.setBounds(20, 220, 300, 30);
				b3.setFont(new Font("SansSerif", Font.BOLD, 20));
				view.addButtons(b3);

				label1.setBounds(13, 213, 100, 200);
				view.addButtons(label1);
				text1.setBounds(90, 300, 200, 25);
				view.addButtons(text1);

				label2.setBounds(15, 263, 100, 200);
				view.addButtons(label2);
				text2.setBounds(90, 350, 200, 25);
				view.addButtons(text2);

				label3.setBounds(13, 313, 100, 200);
				view.addButtons(label3);
				text3.setBounds(90, 400, 200, 25);
				view.addButtons(text3);

				label4.setBounds(13, 400, 500, 200);
				view.addButtons(label4);
				
				label5.setBounds(13, 450, 500, 200);
				view.addButtons(label5);

				JScrollPane sp = new JScrollPane(table);
				view.addTable(sp);

			}
		});
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nr = AdministratorGUI.getText1();
				String nume = AdministratorGUI.getText2();
				String ingrediente = AdministratorGUI.getText3();

				Administrator a = new Administrator(nr, nume, ingrediente);
				AdministratorGUI.insertTable(a.getItem());
				a.getItem().ingrediente.clear();
			}
		});

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nr = AdministratorGUI.getText1();
				String nume = AdministratorGUI.getText2();
				String ingrediente = AdministratorGUI.getText3();

				Administrator a = new Administrator(nr, nume, ingrediente);
				AdministratorGUI.deleteFromTable();
				a.getItem().ingrediente.clear();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nr = AdministratorGUI.getText1();
				String nume = AdministratorGUI.getText2();
				String ingrediente = AdministratorGUI.getText3();

				Administrator a = new Administrator(nr, nume, ingrediente);
				AdministratorGUI.editFromTable(a.getItem());
				a.getItem().ingrediente.clear();
			}
		});

	}
	
	/**
	 * Operatia de adugare unei retete in tabel
	 */
	public static void insertTable(MenuItem item) {

		data[0] = item.nr;
		data[1] = item.nume;

		for (String i : item.ingrediente) {
			data[2] += i + ", ";
		}

		model.addRow(new Object[] { data[0], data[1], data[2] });
		Order.addItem(item);
		data[0] = "";
		data[1] = "";
		data[2] = "";
	}
	
	/**
	 * Operatia de stergere a unei retete in tabel
	 */
	public static void deleteFromTable() {

		MenuItem item = new MenuItem();

		item.nr = (String) table.getValueAt(table.getSelectedRow(), 0);

		int numRows = table.getSelectedRows().length;
		for (int i = 0; i < numRows; i++) {
			model.removeRow(table.getSelectedRow());
		}
		Order.removeItem(item);
	}
	
	/**
	 * Operatia de modificare a unei retete in tabel
	 */
	public static void editFromTable(MenuItem item) {

		MenuItem item1 = new MenuItem();
		item1.nr = (String) table.getValueAt(table.getSelectedRow(), 0);

		data[0] = item.nr;
		data[1] = item.nume;

		for (String i : item.ingrediente) {
			data[2] += i + ", ";
		}

		model.setValueAt(data[0], table.getSelectedRow(), 0);
		model.setValueAt(data[1], table.getSelectedRow(), 1);
		model.setValueAt(data[2], table.getSelectedRow(), 2);
		Order.editItem(item, item1);
		data[2] = "";
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public static String getText1() {
		return text1.getText();
	}

	public static String getText2() {
		return text2.getText();
	}

	public static String getText3() {
		return text3.getText();
	}

	public static JTable getTable() {
		return table;
	}

}