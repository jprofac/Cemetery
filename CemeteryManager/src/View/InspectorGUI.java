package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;

public class InspectorGUI extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InspectorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 20, 650, 336);
		JTable decedati = new JTable();
		JTable morminte = new JTable();
		JTable monumente = new JTable();
		tabbedPane.addTab("Decedati", decedati);
		tabbedPane.addTab("Morminte", morminte);
		tabbedPane.addTab("Monumente", monumente);
		contentPane.add(tabbedPane);
		setVisible(true);
	}
}
