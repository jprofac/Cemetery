package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class ResponseGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public ResponseGUI() {
		setTitle("Raspuns");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new MigLayout("", "[378px][]", "[391px][][36px][13px][50px]"));
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Nume Proprietar");
		contentPane.add(lblNewLabel, "flowx,cell 0 1,alignx left,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,alignx center,aligny bottom");
		textField.setColumns(10);
		
		JButton button = new JButton("Trimite Raspuns");
		contentPane.add(button, "cell 0 4,alignx center,growy");
		setVisible(true);
	}
}
