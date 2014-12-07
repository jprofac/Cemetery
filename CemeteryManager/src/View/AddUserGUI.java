package View;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Choice;
import java.awt.Button;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class AddUserGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;



	/**
	 * Create the frame.
	 */
	public AddUserGUI(int userID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nume:");
		label.setBounds(45, 97, 73, 39);
		contentPane.add(label);
		
		JLabel lblLastName = new JLabel("Prenume:");
		lblLastName.setBounds(45, 132, 73, 39);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Nume Utilizator:");
		lblUsername.setBounds(45, 168, 103, 34);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Parola:");
		lblPassword.setBounds(45, 198, 60, 39);
		contentPane.add(lblPassword);
		
		JLabel lblType = new JLabel("Tip utilizator:");
		lblType.setBounds(45, 224, 88, 50);
		contentPane.add(lblType);
		
		textField = new JTextField();
		textField.setBounds(145, 105, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 140, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 174, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(145, 206, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(145, 242, 116, 22);
		choice.add("inspector");
		choice.add("registratura primariei");
		choice.add("relatii cu publicul");
		contentPane.add(choice);
		
		JButton btnSave = new JButton("Salveaza");
		btnSave.setBounds(114, 322, 97, 25);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//TODO add or update user
			}
		});
		contentPane.add(btnSave);
		
		setVisible(true);
	}
}
