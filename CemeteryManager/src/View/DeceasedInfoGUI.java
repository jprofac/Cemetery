package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import Controller.Controller;
import Repository.Repository;


public class DeceasedInfoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JDatePickerImpl datePicker;
	private Controller controller;
	private JButton button1;


	/**
	 * Create the frame.
	 */
	public DeceasedInfoGUI() {
		controller = new Controller(new Repository());
		setTitle("Date Decedat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 363, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[146px][12px][149px]", "[18px][18px][18px][18px][19px][39px][50px]"));
		this.setLocationRelativeTo(null);
		JLabel lblCnp = new JLabel("CNP: ");
		contentPane.add(lblCnp, "cell 0 0,alignx center,aligny bottom");
		
		JLabel lblNume = new JLabel("Nume:");
		contentPane.add(lblNume, "cell 0 1,alignx center,aligny bottom");
		
		JLabel lblPrenume = new JLabel("Prenume:");
		contentPane.add(lblPrenume, "cell 0 2,alignx center,aligny top");
		
		JLabel lblReligia = new JLabel("Religia:");
		contentPane.add(lblReligia, "cell 0 3,alignx center,aligny top");
		
		JLabel lblTimpulInhumarii = new JLabel("Timpul Inhumarii:");
		contentPane.add(lblTimpulInhumarii, "cell 0 5,alignx right,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 0,alignx left,growy");
		textField.setColumns(10);

		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 2 1,alignx left,growy");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		contentPane.add(textField_2, "cell 2 2,alignx left,growy");		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		contentPane.add(textField_3, "cell 2 3,alignx left,growy");		
			
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		contentPane.add(datePicker, "cell 2 5,grow");
		
		JLabel lblNrMormint = new JLabel("Nr. Mormant");
		contentPane.add(lblNrMormint, "cell 0 4,alignx center,aligny top");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		contentPane.add(textField_4, "cell 2 4,alignx left,growy");
		
		JButton button = new JButton("Salveaza");
		contentPane.add(button, "cell 0 6 3 1,grow");
		
		button1 = new JButton("Modifica");
		contentPane.add(button1, "cell 0 6 3 1,grow");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName = textField_1.getText();
				String lastName = textField_2.getText();
				String religion = textField_3.getText();
				int grave = Integer.parseInt(textField_4.getText());
				java.util.Date utilDate = (Date) datePicker.getModel().getValue();
				
				java.sql.Date date = new java.sql.Date(utilDate.getTime());				   
				    
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				controller.addDeceased(-1, firstName, lastName, religion, grave, date);;
			}
		});
		
		setVisible(true);
	}
	
	public void modifica(final int id){
		textField.setText(String.valueOf(id));
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				String firstName = textField_1.getText();
				String lastName = textField_2.getText();
				String religion = textField_3.getText();
				int grave = Integer.parseInt(textField_4.getText());
				java.util.Date utilDate =  (Date) datePicker.getModel().getValue();
				
				java.sql.Date date = new java.sql.Date(utilDate.getTime());				   
				    
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); 
				String reportDate = df.format(utilDate); 
				controller.updateDeceased(id, firstName, lastName, religion, grave, date);;
				System.out.println("Saved");
			}
		});
		
	}
}

