package presentationLayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Clasa in care se genereaza interfata grafica
 * @author laurg
 *
 */
public class View {

	private JFrame frame = new JFrame("Restaurant");
	private JLabel label1 = new JLabel("User: ");

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();

	private JButton b1 = new JButton("Administrator");
	private JButton b2 = new JButton("Waiter");

	JTable j;

	public View() {
		// Frame
		frame.setSize(800, 700);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
		
		panel1.setBackground(Color.LIGHT_GRAY);
		frame.add(panel1,BorderLayout.NORTH);
		panel2.setBackground(Color.gray);
		panel2.setLayout(null);
		frame.add(panel2,BorderLayout.CENTER);
		panel3.setBackground(Color.gray);
		frame.add(panel3,BorderLayout.EAST);

		label1.setBounds(50, 20, 150, 40);
		label1.setForeground(Color.black);
		label1.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 25));
		panel1.add(label1);

		// Butoane
		b1.setBounds(160, 20, 200, 40);
		b1.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel1.add(b1);
		b2.setBounds(450, 20, 200, 40);
		b2.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel1.add(b2);


		frame.setVisible(true);
	}

	void addAdministratorListener(ActionListener a) {
		b2.setSelected(false);
		b1.addActionListener(a);
	}

	void addWaiterListener(ActionListener a) {
		b2.setSelected(false);
		b2.addActionListener(a);
	}

	void addTable(Component a) {
		panel3.removeAll();
		frame.repaint();
		frame.setSize(802, 700);
		frame.setSize(801, 700);
		panel3.add(a);
	}
	
	void addButtons(Component a) {
		frame.repaint();
		frame.setSize(801, 700);
		panel2.add(a);
	}
	
	void removeAll() {
		panel2.removeAll();
		//panel3.removeAll();
	}

}
