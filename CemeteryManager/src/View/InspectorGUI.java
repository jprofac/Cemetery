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
import net.miginfocom.swing.MigLayout;

public class InspectorGUI extends JFrame {


	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public InspectorGUI() {
	
		setTitle("Inspector\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[180px][91px][140px][79px][160px]", "[336px][50px]"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JTable decedati = new JTable();
		JTable morminte = new JTable();
		JTable monumente = new JTable();
		tabbedPane.addTab("Decedati", decedati);
		tabbedPane.addTab("Morminte", morminte);
		tabbedPane.addTab("Monumente", monumente);
		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO separate Adauga button for the different tabs 
				new DeceasedInfoGUI();
				new GraveInfoGUI();
			}
		});
		contentPane.add(btnAdauga, "cell 0 1,grow");
		
		JButton btnModifica = new JButton("Modifica");
		contentPane.add(btnModifica, "cell 2 1,grow");
		
		JButton btnDelete = new JButton("Delete");
		contentPane.add(btnDelete, "cell 4 1,grow");
		setVisible(true);
	}
}
