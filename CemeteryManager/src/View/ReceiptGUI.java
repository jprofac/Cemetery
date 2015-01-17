package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ReceiptGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;

	/**
	 * Create the frame.
	 */
	public ReceiptGUI() {
		setTitle("Chitanta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new MigLayout("", "[378px]", "[391px][50px]"));

		textPane = new JTextPane();
		textPane.setBounds(30, 31, 378, 391);
		contentPane.add(textPane, "cell 0 0,grow");

		JLabel lblNumeChitanta = new JLabel("Nume chitanta:");
		contentPane.add(lblNumeChitanta, "flowx,cell 0 1");

		textField = new JTextField();
		contentPane.add(textField, "cell 0 1");
		textField.setColumns(10);

		JButton button = new JButton("Salveaza Chitanta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Writer writer = null;
				try {
					if (!textField.getText().isEmpty()
							&& !textPane.getText().isEmpty()) {
						writer = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("Chitante/"
										+ textField.getText() + ".txt"),
								"utf-8"));
						writer.write(textPane.getText());
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane,
								"Field can't be empty");
					}
				} catch (IOException ex) {
					// report
				} finally {
					try {
						writer.close();
					} catch (Exception ex) {
					}
				}
			}
		});
		button.setBounds(136, 484, 140, 50);
		contentPane.add(button, "cell 0 1,alignx center,growy");
		setVisible(true);
	}

}
