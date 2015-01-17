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

import javax.swing.JLabel;
import javax.swing.JTextField;

public class BuyingContractGUI extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public BuyingContractGUI() {
		setTitle("Contract cumparare");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[376px]", "[391px][50px]"));
		this.setLocationRelativeTo(null);
		textPane = new JTextPane();
		contentPane.add(textPane, "cell 0 0,grow");
		
		JButton button = new JButton("Salveaza Cerere");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Writer writer = null;
				 try {
					 if (!textField.getText().isEmpty() && !textPane.getText().isEmpty()){
				     writer = new BufferedWriter(new OutputStreamWriter(
				           new FileOutputStream("Ordin/"+textField.getText() + ".txt"), "utf-8"));
				     writer.write(textPane.getText());
					 dispose();
					 } else{
						 JOptionPane.showMessageDialog(contentPane, "Field can't be empty");
					 }
				     
				 } catch (IOException ex) {
				   // report
				 } finally {
				    try {writer.close();} catch (Exception ex) {}
				 }
			}
		});
		
		lblNewLabel = new JLabel("Nume cumparator:");
		contentPane.add(lblNewLabel, "flowx,cell 0 1");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1");
		textField.setColumns(10);
		contentPane.add(button, "cell 0 1,alignx center,growy");
		setVisible(true);
	}

}
