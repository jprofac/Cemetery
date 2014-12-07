package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JTextField;

public class ObsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public ObsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalveaza = new JButton("Salveaza");
		btnSalveaza.setBounds(46, 337, 200, 50);
		contentPane.add(btnSalveaza);
		
		JLabel lblConstructiiFunerare = new JLabel("Constructii Funerare:");
		lblConstructiiFunerare.setBounds(10, 105, 131, 27);
		contentPane.add(lblConstructiiFunerare);
		
		Choice choice = new Choice();
		choice.setBounds(161, 105, 91, 27);
		choice.add("Da");
		choice.add("Nu");		
		contentPane.add(choice);
		
		textField = new JTextField();
		textField.setBounds(161, 154, 91, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAdaugaImagine = new JLabel("Adauga imagine:");
		lblAdaugaImagine.setBounds(10, 207, 129, 16);
		contentPane.add(lblAdaugaImagine);
		
		JLabel label_1 = new JLabel("Nr. Actului Modificarii:");
		label_1.setBounds(10, 152, 131, 27);
		contentPane.add(label_1);
		
		JButton btnCauta = new JButton("Cauta");
		btnCauta.setBounds(161, 202, 108, 27);
		contentPane.add(btnCauta);
		setVisible(true);
	}
}
