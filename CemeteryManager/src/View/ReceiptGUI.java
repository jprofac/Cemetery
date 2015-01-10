package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class ReceiptGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ReceiptGUI() {
		setTitle("Chitanta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new MigLayout("", "[378px]", "[391px][50px]"));
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(30, 31, 378, 391);
		contentPane.add(textPane, "cell 0 0,grow");
		
		JButton button = new JButton("Salveaza Chitanta");
		button.setBounds(136, 484, 140, 50);
		contentPane.add(button, "cell 0 1,alignx center,growy");
		setVisible(true);
	}

}
