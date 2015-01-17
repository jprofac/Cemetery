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
import net.miginfocom.swing.MigLayout;

public class ObsGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public ObsGUI() {
		setTitle("Observatii");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[131px][20px][108px]", "[27px][27px][27px][50px]"));
		this.setLocationRelativeTo(null);
		JButton btnSalveaza = new JButton("Salveaza");
		contentPane.add(btnSalveaza, "cell 0 3 3 1,grow");
		
		JLabel lblConstructiiFunerare = new JLabel("Constructii Funerare:");
		contentPane.add(lblConstructiiFunerare, "cell 0 0,grow");
		
		Choice choice = new Choice();
		choice.add("Da");
		choice.add("Nu");		
		contentPane.add(choice, "cell 2 0,growx,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 1,growx,aligny center");
		textField.setColumns(10);
		
		JLabel lblAdaugaImagine = new JLabel("Adauga imagine:");
		contentPane.add(lblAdaugaImagine, "cell 0 2,growx,aligny center");
		
		JLabel label_1 = new JLabel("Nr. Actului Modificarii:");
		contentPane.add(label_1, "cell 0 1,grow");
		
		JButton btnCauta = new JButton("Cauta");
		contentPane.add(btnCauta, "cell 2 2,grow");
		setVisible(true);
	}
}
