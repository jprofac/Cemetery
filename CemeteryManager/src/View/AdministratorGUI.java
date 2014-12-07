package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class AdministratorGUI extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField_3;


	/**
	 * Create the frame.
	 */
	public AdministratorGUI() {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAddUser = new JButton("Adauga Utilizator");
		btnAddUser.setBounds(56, 405, 141, 25);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new AddUserGUI(-1);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnAddUser);
		
		table_1 = new JTable();
		table_1.setBounds(46, 47, 594, 302);
		contentPane.add(table_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(46, 362, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSearch = new JButton("Cauta Utilizator");
		btnSearch.setBounds(174, 361, 119, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO search for users in table
			}
		});
		contentPane.add(btnSearch);
		
		JButton btnModify = new JButton("Modifica Utilizator");
		btnModify.setBounds(287, 405, 133, 25);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO userId for the selected item from table
				int userId=1;
				new AddUserGUI(userId);
			}
		});
		contentPane.add(btnModify);
		
		JButton btnDelete = new JButton("Sterge");
		btnDelete.setBounds(505, 405, 121, 25);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO delete selected user
			}
		});
		contentPane.add(btnDelete);
		
		setVisible(true);
	}
}
