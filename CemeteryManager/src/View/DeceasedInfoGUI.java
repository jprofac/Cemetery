package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JButton;


public class DeceasedInfoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the frame.
	 */
	public DeceasedInfoGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCnp = new JLabel("CNP: ");
		lblCnp.setBounds(43, 84, 32, 16);
		contentPane.add(lblCnp);
		
		JLabel lblNume = new JLabel("Nume:");
		lblNume.setBounds(43, 113, 56, 16);
		contentPane.add(lblNume);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		lblPrenume.setBounds(43, 142, 56, 16);
		contentPane.add(lblPrenume);
		
		JLabel lblReligia = new JLabel("Religia:");
		lblReligia.setBounds(43, 171, 56, 16);
		contentPane.add(lblReligia);
		
		JLabel lblTimpulInhumarii = new JLabel("Timpul Inhumarii:");
		lblTimpulInhumarii.setBounds(43, 234, 115, 16);
		contentPane.add(lblTimpulInhumarii);
		
		textField = new JTextField();
		textField.setBounds(176, 82, 115, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 111, 115, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 142, 115, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 171, 115, 18);
		contentPane.add(textField_3);
			
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(170, 234, 149, 39);
		contentPane.add(datePicker);
		
		JButton button = new JButton("Salveaza");
		button.setBounds(43, 304, 91, 25);
		contentPane.add(button);
		
		JLabel lblNrMormint = new JLabel("Nr. Mormint");
		lblNrMormint.setBounds(43, 200, 91, 16);
		contentPane.add(lblNrMormint);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(176, 201, 115, 18);
		contentPane.add(textField_4);
		
		setVisible(true);
	}
}
