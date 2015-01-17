package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import Model.User;
import Repository.Repository;

public class AdministratorGUI extends JFrame {

    private JPanel contentPane;

    private ScrollPane scroll;

    private JTable table_1;

    private JTextField textField_3;


    private String[] cols = {"Nr", "firstname", "lastname", "user", "type"};

    DefaultTableModel model;


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
        final JFrame view = this;
        final WindowListener listener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                view.setVisible(false);
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                view.setVisible(true);
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        };
        JButton btnAddUser = new JButton("Adauga Utilizator");
        btnAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddUserGUI().addWindowListener(listener);
            }
        });
        contentPane.setLayout(new MigLayout("", "[205px][25px][140px][89px][140px]", "[302px][25px][50px]"));
        contentPane.add(btnAddUser, "cell 0 2,alignx left,growy");
        textField_3 = new JTextField();
        contentPane.add(textField_3, "cell 0 1,growx,aligny top");
        textField_3.setColumns(10);
        model = new DefaultTableModel(cols, 0);
        table_1 = new JTable(model);
        scroll = new ScrollPane();
        scroll.add(table_1);
        contentPane.add(scroll, "cell 0 0 5 1,grow");
        //contentPane.add(table_1, "cell 0 0 5 1,grow");
        reload();


        JButton btnSearch = new JButton("Cauta Utilizator");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reload();
            }
        });
        contentPane.add(btnSearch, "cell 2 1,growx,aligny top");
        JButton btnModify = new JButton("Modifica Utilizator");
        btnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO userId for the selected item from table
                new AddUserGUI().addWindowListener(listener);
            }
        });
        contentPane.add(btnModify, "cell 2 2,grow");

        JButton btnDelete = new JButton("Sterge");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO delete selected user
                Repository.getInstance().userRepo.deleteUser(Repository.getInstance().userRepo.getUserById((int) model.getValueAt(table_1.getSelectedRow(), 0)));
                reload();
            }
        });
        contentPane.add(btnDelete, "cell 4 2,grow");
        setVisible(true);
    }

    private void reload() {
        model = new DefaultTableModel(cols, 0);
        scroll.remove(table_1);
        table_1 = new JTable(model);
        scroll.add(table_1);
        contentPane.add(scroll, "cell 0 0 5 1,grow");
        for (User u : Repository.getInstance().userRepo.searchUser(textField_3.getText())) {
            model.addRow(new Object[]{u.getId(), u.getFirstName(), u.getLastName(), u.getUsername(), u.getType()});
        }
    }
}
