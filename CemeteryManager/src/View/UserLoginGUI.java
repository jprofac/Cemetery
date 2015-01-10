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
import net.miginfocom.swing.MigLayout;

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
		setTitle("Log In");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[64px][43px][116px]", "[22px][22px][25px][][][][][]"));
		
		JLabel lblUsername = new JLabel("Nume Utilizator:");
		contentPane.add(lblUsername, "cell 1 2,alignx left,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 2,alignx left,aligny top");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Parola:");
		contentPane.add(lblNewLabel, "cell 1 3,growx,aligny center");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 2 3,growx,aligny top");
		
		JButton btnLogIn = new JButton("Autentificare");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO verify type of the user and display the appropriate window
				
				new AdministratorGUI();
				new InspectorGUI();
				new RelatiiCuPubliculGUI();
				new RegistraturaGUI();
				
				dispose();
			}
		});
		contentPane.add(btnLogIn, "cell 2 6,alignx center,aligny top");
	}
}
