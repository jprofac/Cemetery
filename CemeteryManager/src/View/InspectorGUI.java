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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InspectorGUI extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InspectorGUI() {
		setTitle("Inspector\r\n");
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
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO separate Adauga button for the different tabs 
				new DeceasedInfoGUI();
				new GraveInfoGUI();
			}
		});
		btnAdauga.setBounds(60, 409, 97, 25);
		contentPane.add(btnAdauga);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(291, 409, 97, 25);
		contentPane.add(btnModifica);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(510, 409, 97, 25);
		contentPane.add(btnDelete);
		setVisible(true);
	}
}
