package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class RegistraturaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RegistraturaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[205px][42px][156px][105px][142px]", "[336px][25px][50px]"));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JTable decedati = new JTable();
		JTable morminte = new JTable();
		JTable monumente = new JTable();
		tabbedPane.addTab("Decedati", decedati);
		tabbedPane.addTab("Morminte", morminte);
		tabbedPane.addTab("Monumente", monumente);
		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField, "cell 0 1,growx,aligny center");
		
		JButton button = new JButton("Cauta");
		contentPane.add(button, "cell 2 1,growx,aligny top");
		
		JButton button_1 = new JButton("Creaza Cerere");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateRequestGUI();
			}
		});
		contentPane.add(button_1, "cell 0 2,alignx left,growy");
		
		JButton button_2 = new JButton("Creaza Chitanta");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReceiptGUI();
			}
		});
		contentPane.add(button_2, "cell 2 2,grow");
		
		JButton button_3 = new JButton("Trimite Raspuns");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResponseGUI();
			}
		});
		contentPane.add(button_3, "cell 4 2,grow");
		
		setVisible(true);
	}
}
