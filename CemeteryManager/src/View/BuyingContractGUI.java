package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class BuyingContractGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public BuyingContractGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[376px]", "[391px][50px]"));
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, "cell 0 0,grow");
		
		JButton button = new JButton("Salveaza Cerere");
		contentPane.add(button, "cell 0 1,alignx center,growy");
		setVisible(true);
	}

}
