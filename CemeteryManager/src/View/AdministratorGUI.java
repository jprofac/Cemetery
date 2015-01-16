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
import net.miginfocom.swing.MigLayout;
import Repository.Repository;

public class AdministratorGUI extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField textField_3;


	/**
	 * Create the frame.
	 */
	public AdministratorGUI() {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 667, 502);
		setContentPane(contentPane);
		
		JButton btnAddUser = new JButton("Adauga Utilizator");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				new AddUserGUI();
			}
		});
		contentPane.setLayout(new MigLayout("", "[205px][25px][140px][89px][140px]", "[302px][25px][50px]"));
		contentPane.add(btnAddUser, "cell 0 2,alignx left,growy");
		
		table_1 = new JTable();
		contentPane.add(table_1, "cell 0 0 5 1,grow");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 0 1,growx,aligny top");
		textField_3.setColumns(10);
		
		JButton btnSearch = new JButton("Cauta Utilizator");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository.getInstance().userRepo.searchUser(textField_3.getText());
			}
		});
		contentPane.add(btnSearch, "cell 2 1,growx,aligny top");
		
		JButton btnModify = new JButton("Modifica Utilizator");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO userId for the selected item from table
				int userId=1;
				new AddUserGUI();
			}
		});
		contentPane.add(btnModify, "cell 2 2,grow");
		
		JButton btnDelete = new JButton("Sterge");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO delete selected user
			}
		});
		contentPane.add(btnDelete, "cell 4 2,grow");
		
		setVisible(true);
	}
}
