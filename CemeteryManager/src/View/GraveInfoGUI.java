package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Model.Grave;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class GraveInfoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button_1;

	/**
	 * Create the frame.
	 */
	public GraveInfoGUI() {
		setTitle("Informatii Mormant");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 271, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[86px][1px][123px]", "[18px][18px][18px][18px][18px][25px][50px]"));
		
		JLabel lblNewLabel = new JLabel("Nr. Mormant:");
		contentPane.add(lblNewLabel, "cell 0 0,growx,aligny center");
		
		JLabel label = new JLabel("Cimitirul:");
		contentPane.add(label, "cell 0 1,alignx left,aligny top");
		
		JLabel label_1 = new JLabel("Parcela:");
		contentPane.add(label_1, "cell 0 2,alignx left,aligny bottom");
		
		JLabel label_2 = new JLabel("Detinator:");
		contentPane.add(label_2, "cell 0 3,growx,aligny bottom");
		
		JLabel label_3 = new JLabel("Suprafata:");
		contentPane.add(label_3, "cell 0 4,growx,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 0,alignx left,growy");
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 2 1,alignx left,growy");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		contentPane.add(textField_2, "cell 2 2,alignx left,growy");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		contentPane.add(textField_3, "cell 2 3,alignx left,growy");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		contentPane.add(textField_4, "cell 2 4,alignx left,growy");
		
		JButton btnObservatii = new JButton("Observatii");
		btnObservatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ObsGUI();
			}
		});
		contentPane.add(btnObservatii, "cell 0 5 3 1,alignx center,aligny top");
		
		button_1 = new JButton("Salveaza");
		contentPane.add(button_1, "cell 0 6 3 1,grow");
		setVisible(true);
	}
	
	
	public void modifica(Grave grave){
		//TODO 
		
		textField.setText(String.valueOf(grave.getId()));
		//textField_1.setText(String.valueOf(grave.getType()));
		textField_2.setText(String.valueOf(grave.getParcelId()));
		//textField_3.setText(grave.);
		//textField_4.setText(grave.getGrave());
	}

}
