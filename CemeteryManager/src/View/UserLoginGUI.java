package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;

public class UserLoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLoginGUI frame = new UserLoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserLoginGUI() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(206, 81, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Nume Utilizator:");
		lblUsername.setBounds(99, 83, 108, 19);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Parola:");
		lblNewLabel.setBounds(99, 123, 64, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnLogIn = new JButton("Autentificare");
		btnLogIn.setBounds(161, 186, 116, 25);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO verify type of the user and display the appropriate window
				
				new AdministratorGUI();
				new InspectorGUI();
			}
		});
		contentPane.add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 120, 116, 22);
		contentPane.add(passwordField);
	}
}
