package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ResponseGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;


	/**
	 * Create the frame.
	 */
	public ResponseGUI() {
		setTitle("Raspuns");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new MigLayout("", "[378px][]", "[391px][][36px][13px][50px]"));
		
		textPane = new JTextPane();
		contentPane.add(textPane, "cell 0 0,grow");
		
		JLabel lblNewLabel = new JLabel("Nume Proprietar");
		contentPane.add(lblNewLabel, "flowx,cell 0 1,alignx left,aligny top");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 0 1,alignx center,aligny bottom");
		textField.setColumns(10);
		
		JButton button = new JButton("Trimite Raspuns");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Writer writer = null;
				 try {
					 if (!textField.getText().isEmpty()
								&& !textPane.getText().isEmpty()) {
				     writer = new BufferedWriter(new OutputStreamWriter(
				     new FileOutputStream("Raspunsuri/"+textField.getText() + ".txt"), "utf-8"));
				     writer.write(textPane.getText());
				     dispose();
					 }else{
						 JOptionPane.showMessageDialog(contentPane,
									"Field can't be empty");
					 }
				 } catch (IOException ex) {
				   // report
				 } finally {
				    try {writer.close();} catch (Exception ex) {}
				 }	
			}
		});
		contentPane.add(button, "cell 0 4,alignx center,growy");
		setVisible(true);
	}
}
