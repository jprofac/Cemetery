package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import Repository.DataBase;

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
					frame.setLocationRelativeTo(null);
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
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 453, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[64px][43px][116px]",
				"[22px][22px][25px][][][][][]"));

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

		final JFrame view = this;
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO verify type of the user and display the appropriate
				// window
				int userType = DataBase.getInstance().logIn(
						textField.getText(), passwordField.getText());
				JFrame frame = null;
				switch (userType) {
				case DataBase.USER_ADMIN:
					frame = new AdministratorGUI();
					frame.setLocationRelativeTo(null);
					break;
				case DataBase.USER_INSPECTOR:
					frame = new InspectorGUI();
					frame.setLocationRelativeTo(null);
					break;
				case DataBase.USER_REGISTRATURA:
					frame = new RegistraturaGUI();
					frame.setLocationRelativeTo(null);
					break;
				case DataBase.USER_RELATII:
					frame = new RelatiiCuPubliculGUI();
					frame.setLocationRelativeTo(null);
					break;
				default:
					JOptionPane.showMessageDialog(contentPane,
							"Wrong username or password!");
				}

				if (frame != null)
					frame.addWindowListener(new WindowListener() {
						@Override
						public void windowOpened(WindowEvent e) {

						}

						@Override
						public void windowClosing(WindowEvent e) {

						}

						@Override
						public void windowClosed(WindowEvent e) {
							view.setVisible(true);
						}

						@Override
						public void windowIconified(WindowEvent e) {

						}

						@Override
						public void windowDeiconified(WindowEvent e) {

						}

						@Override
						public void windowActivated(WindowEvent e) {

						}

						@Override
						public void windowDeactivated(WindowEvent e) {

						}
					});

				view.setVisible(false);
			}
		});
		contentPane.add(btnLogIn, "cell 2 6,alignx center,aligny top");
	}
}
