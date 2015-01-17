package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import Controller.Controller;
import Model.Deceased;
import Model.Grave;
import Model.User;
import Repository.DeceasedRepo;
import Repository.Repository;
import Repository.UserRepo;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class RelatiiCuPubliculGUI extends JFrame {
	private Repository repo = new Repository();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTabbedPane tabbedPane;
	
	public DeceasedRepo deceasedRepo;
	private Controller controller;
	private ArrayList<Deceased> deceased = new ArrayList<Deceased>();
	private ArrayList<Grave> grave = new ArrayList<Grave>();
	private DefaultTableModel modelDeceased;
	private DefaultTableModel modelGrave;

	/**
	 * Create the frame.
	 */
	public RelatiiCuPubliculGUI() {
		controller = new Controller(repo);
		setTitle("Relatii cu publicul");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 809, 680);
		contentPane = new JPanel();
		final JFrame view = this;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("",
				"[205px][55px][175px][100px][153px]",
				"[468px][25px][27px][50px]"));
	

		final WindowListener listener = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				view.setVisible(false);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				view.setVisible(true);

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		};
		String[] columnDeceasedNames = { "CNP", "First Name", "Last Name",
				"Religion", "GraveID", "burialDate" };
		String[] columnGraveNames = { "ID", "ParcelId", "Surface",
				"ObservationId", "isMonument", "isValid" };
		modelDeceased = new DefaultTableModel(columnDeceasedNames, 0);
		modelGrave = new DefaultTableModel(columnGraveNames, 0);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		final JTable decedati = new JTable(modelDeceased);
		final JTable morminte = new JTable(modelGrave);
		final JTable monumente = new JTable(modelGrave);
		tabbedPane.addTab("Decedati", new JScrollPane(decedati));
		tabbedPane.addTab("Morminte", new JScrollPane(morminte));
		tabbedPane.addTab("Monumente", new JScrollPane(monumente));

		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");
		textField = new JTextField();
		textField.setColumns(10);
		contentPane.add(textField, "cell 0 1,growx,aligny center");

		JButton button = new JButton("Cauta Loc Disponibil");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reload();
			}
		});
		contentPane.add(button, "cell 2 1,growx,aligny top");

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 0 2,growx,aligny top");

		print();
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				print();
			}
		});

		JButton button_1 = new JButton("Cauta Dupa Nume");
		contentPane.add(button_1, "cell 2 2,growx,aligny bottom");

		JButton button_2 = new JButton("Ordin Deschidere Mormant");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderGUI().addWindowListener(listener);
			}
		});
		contentPane.add(button_2, "cell 0 3,alignx center,growy");

		JButton button_3 = new JButton("Certificat Deces");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeathCertificateGUI().addWindowListener(listener);
			}
		});
		contentPane.add(button_3, "cell 2 3,grow");
		JButton button_4 = new JButton("Contract Cumparare loc de Veci");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuyingContractGUI().addWindowListener(listener);
			}
		});
		contentPane.add(button_4, "cell 4 3,grow");

		setVisible(true);
	}

	public void print() {
		int selectedIndex = tabbedPane.getSelectedIndex();

		if (selectedIndex == 0) {
			modelDeceased.setRowCount(0);
			deceased = controller.getAllDeceased();
			if (deceased != null)
				for (Deceased d : deceased) {
					Object[] data = { d.getId(), d.getFirstName(),
							d.getLastName(), d.getReligion(), d.getGrave(),
							d.getBurialDate(), d.getValid() };
					modelDeceased.addRow(data);
				}

		} else if (selectedIndex == 1) {
			modelGrave.setRowCount(0);
			grave = controller.getAllGrave();
			if (grave != null)
				for (Grave g : grave) {
					Object[] data = { g.getId(), g.getParcelId(),
							g.getSurface(), g.getObservationId(),
							g.getIsMonument(), g.isValid() };
					modelGrave.addRow(data);
				}

		} else if (selectedIndex == 2) {
			modelGrave.setRowCount(0);
			grave = (ArrayList<Grave>) controller.getAllGrave();
			if (grave != null)
				for (Grave g : grave) {
					if (g.getIsMonument()) {
						Object[] data = { g.getId(), g.getParcelId(),
								g.getSurface(), g.getObservationId(),
								g.getIsMonument(), g.isValid() };
						modelGrave.addRow(data);
					}
				}
		}
	}

	private void reload() {
		int selectedIndex = tabbedPane.getSelectedIndex();

		if (selectedIndex == 0) {
			modelDeceased.setRowCount(0);
			deceased = (ArrayList<Deceased>) controller.getAllDeceased();
			if (deceased != null)
				for (Deceased d : Repository.getInstance().deceasedRepo
						.searchDeceased(textField_1.getText())) {
					Object[] data = { d.getId(), d.getFirstName(),
							d.getLastName(), d.getReligion(), d.getGrave(),
							d.getBurialDate(), d.getValid() };
					modelDeceased.addRow(data);
				}

		} else if (selectedIndex == 1) {
			modelGrave.setRowCount(0);
			grave = controller.getAllGrave();
			if (grave != null)
				for (Grave g : grave) {
					Object[] data = { g.getId(), g.getParcelId(),
							g.getSurface(), g.getObservationId(),
							g.getIsMonument(), g.isValid() };
					modelGrave.addRow(data);
				}

		}

	}
}
