package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class CreateRequestGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public CreateRequestGUI() {
		setTitle("Creaza Cerere");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 422, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[378px]", "[391px][50px][]"));
		this.setLocationRelativeTo(null);
		textPane = new JTextPane();
		contentPane.add(textPane, "cell 0 0,grow");
		
		label = new JLabel("Nume fisier:");
		contentPane.add(label, "flowx,cell 0 1");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1");
		textField.setColumns(10);
		
		JButton button = new JButton("Salveaza Cerere");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Writer writer = null;
				 try {
					if (!textField.getText().isEmpty()
							&& !textPane.getText().isEmpty()) {
				     writer = new BufferedWriter(new OutputStreamWriter(
				           new FileOutputStream("Cereri/" + textField.getText() + ".txt"), "utf-8"));
				     writer.write(textPane.getText());
				     dispose();
					 }else{
						 JOptionPane.showMessageDialog(contentPane, "Field can't be empty");
					 }
				 } catch (IOException ex) {
				   // report
				 } finally {
				    try {writer.close();} catch (Exception ex) {}
				 }
			}
		});
		contentPane.add(button, "cell 0 1,alignx center,growy");
		setVisible(true);
	}
}
