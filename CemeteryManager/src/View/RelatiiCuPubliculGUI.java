package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatiiCuPubliculGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public RelatiiCuPubliculGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 809, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[205px][55px][175px][100px][153px]", "[468px][25px][27px][50px]"));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JTable morminte = new JTable();
	
		tabbedPane.addTab("Morminte", morminte);
		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");
		JTable decedati = new JTable();
		tabbedPane.addTab("Decedati", decedati);
		JTable monumente = new JTable();
		tabbedPane.addTab("Monumente", monumente);
		
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField, "cell 0 1,growx,aligny center");
		
		JButton button = new JButton("Cauta Loc Disponibil");
		contentPane.add(button, "cell 2 1,growx,aligny top");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 0 2,growx,aligny top");
		
		JButton button_1 = new JButton("Cauta Dupa Nume");
		contentPane.add(button_1, "cell 2 2,growx,aligny bottom");
		
		JButton button_2 = new JButton("Ordin Deschidere Mormant");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderGUI();
			}
		});
		contentPane.add(button_2, "cell 0 3,alignx center,growy");
		
		JButton button_3 = new JButton("Certificat Deces");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeathCertificateGUI();
			}
		});
		contentPane.add(button_3, "cell 2 3,grow");
		
		JButton button_4 = new JButton("Contract Cumparare loc de Veci");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuyingContractGUI();
			}
		});
		contentPane.add(button_4, "cell 4 3,grow");
		
		setVisible(true);
		
	}

}
