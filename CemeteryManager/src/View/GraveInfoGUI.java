package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.Controller;
import Model.Grave;
import Repository.Repository;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.miginfocom.swing.MigLayout;

public class GraveInfoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JButton button_1;
	private JButton button_2;
	private Controller controller;
	private JTextField textField_2;
	private JLabel lblMonument;
	private JLabel lblNrObservatii;
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public GraveInfoGUI() {
		controller = new Controller(new Repository());
		setTitle("Informatii Mormant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[86px][][1px][123px,grow]", "[18px][18px][18px][18px][18px][][][25px][][50px]"));
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Nr. Mormant:");
		contentPane.add(lblNewLabel, "cell 0 0,growx,aligny center");
		this.setLocationRelativeTo(null);
		JLabel label_1 = new JLabel("Parcela:");
		contentPane.add(label_1, "cell 0 2,alignx left,aligny bottom");
		
		JLabel label_3 = new JLabel("Suprafata:");
		contentPane.add(label_3, "cell 0 4,growx,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 3 0,alignx left,growy");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 3 2,alignx left,growy");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "flowy,cell 3 4");
		textField_2.setColumns(10);
		
		lblMonument = new JLabel("Monument:");
		contentPane.add(lblMonument, "cell 0 6");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		contentPane.add(textField_3, "cell 3 6,alignx left,growy");
		
		JButton btnObservatii = new JButton("Observatii");
		btnObservatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ObsGUI();
			}
		});
		
		lblNrObservatii = new JLabel("Nr. observatii:");
		contentPane.add(lblNrObservatii, "cell 0 7");
		
		textField_4 = new JTextField();
		contentPane.add(textField_4, "cell 3 7,growx");
		textField_4.setColumns(10);
		contentPane.add(btnObservatii, "cell 3 8,alignx center,aligny top");
		
		button_1 = new JButton("Salveaza");
		contentPane.add(button_1, "flowx,cell 0 9 4 1,grow");
		button_2 = new JButton("Modifica");
		contentPane.add(button_2, "cell 0 9 4 1,grow");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textField.getText());
				String monument = textField_3.getText();
				boolean isMonument;
				if (monument.equalsIgnoreCase("true"))
					isMonument = true;
					else
						isMonument = false;
				int observationId = Integer.parseInt(textField_4.getText());
				int parcelId = Integer.parseInt(textField_1.getText());
				int surface = Integer.parseInt(textField_2.getText());
				boolean valid = true;
				     
				controller.addGrave(id, parcelId, surface, observationId, isMonument, valid);
			}
		});
		setVisible(true);
	}
	
	
	public void modifica(final int id){
		textField.setText(String.valueOf(id));
		button_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				String monument = textField_3.getText();
				boolean isMonument;
				if (monument.equalsIgnoreCase("true"))
					isMonument = true;
					else
						isMonument = false;
				
				int observationId = Integer.parseInt(textField_4.getText());
				int parcelId = Integer.parseInt(textField_1.getText());
				int surface = Integer.parseInt(textField_2.getText());
				boolean valid = true;
				     
				controller.updateGrave(id, parcelId, surface, observationId, isMonument, valid);;
			}
		});
		
	}

}
