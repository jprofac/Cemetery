package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nr. Mormant:");
		lblNewLabel.setBounds(50, 101, 86, 16);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("Cimitirul:");
		label.setBounds(50, 130, 56, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Parcela:");
		label_1.setBounds(50, 161, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Detinator:");
		label_2.setBounds(50, 190, 75, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Suprafata:");
		label_3.setBounds(50, 219, 75, 16);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(137, 100, 105, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 130, 105, 18);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 159, 105, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 188, 105, 18);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 219, 105, 18);
		contentPane.add(textField_4);
		
		JButton btnObservatii = new JButton("Observatii");
		btnObservatii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ObsGUI();
			}
		});
		btnObservatii.setBounds(93, 260, 94, 25);
		contentPane.add(btnObservatii);
		
		button_1 = new JButton("Salveaza");
		button_1.setBounds(60, 375, 200, 50);
		contentPane.add(button_1);
		setVisible(true);
	}

}
