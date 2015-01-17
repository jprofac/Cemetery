package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

import Controller.Controller;
import Model.Deceased;
import Model.Grave;
import Repository.Repository;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;

public class InspectorGUI extends JFrame {
	private Repository repo = new Repository();
	private Controller controller;
	private ArrayList<Deceased> deceased = new ArrayList<Deceased>();
	private ArrayList<Grave> grave= new ArrayList<Grave>();
	private DefaultTableModel modelDeceased;
	private DefaultTableModel modelGrave;
	private JTabbedPane tabbedPane;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InspectorGUI() {
		controller = new Controller(repo);
		setTitle("Inspector\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 737, 521);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[180px][91px][140px][79px][160px]", "[336px][50px]"));
			
		String[] columnDeceasedNames = {"CNP", "First Name", "Last Name", "Religion", "GraveID", "burialDate"};
		String[] columnGraveNames = {"ID", "ParcelId", "Surface", "ObservationId", "isMonument", "isValid"};
		modelDeceased = new DefaultTableModel(columnDeceasedNames,0);
		modelGrave = new DefaultTableModel(columnGraveNames,0);
		   	    
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		final JTable decedati = new JTable(modelDeceased);
		final JTable morminte = new JTable(modelGrave);
		final JTable monumente = new JTable(modelGrave);
		tabbedPane.addTab("Decedati", new JScrollPane(decedati));
		tabbedPane.addTab("Morminte", new JScrollPane(morminte));
		tabbedPane.addTab("Monumente", new JScrollPane(monumente));

		
		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");

		
		print();
		 tabbedPane.addChangeListener(new ChangeListener() {
		        public void stateChanged(ChangeEvent e) {		 
		        	print();
		        } 
		    }); 
		
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO separate Adauga button for the different tabs 
				
		        int selectedIndex = tabbedPane.getSelectedIndex();		        
		        if (selectedIndex == 0){
		        	new DeceasedInfoGUI();
		        	print();
		        }else if (selectedIndex == 1){
		        	new GraveInfoGUI();
		        	print();
		        }else if (selectedIndex == 2){
		        	new GraveInfoGUI();
		        	print();
		        }
			}
		});
		contentPane.add(btnAdauga, "cell 0 1,grow");
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				int selectedIndex = tabbedPane.getSelectedIndex();
				 if (selectedIndex == 0){					
					int row = decedati.getSelectedRow();
					int id = (int) decedati.getValueAt(row, 0);
			        new DeceasedInfoGUI().modifica(id);
			        print();
			        	
			        }else if (selectedIndex == 1){
			        	int row = morminte.getSelectedRow();
						int id = (int) morminte.getValueAt(row, 0);
				        new GraveInfoGUI().modifica(id);
				        print();
			        }else if (selectedIndex == 2){
			        	int row = monumente.getSelectedRow();
						int id = (int) monumente.getValueAt(row, 0);
				        new GraveInfoGUI().modifica(id);
				        print();
			        }
			}
		});
		contentPane.add(btnModifica, "cell 2 1,grow");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				int selectedIndex = tabbedPane.getSelectedIndex();
				 if (selectedIndex == 0){					
					int row = decedati.getSelectedRow();
					int id = (int) decedati.getValueAt(row, 0);
			        controller.deleteDeceased(id);
			        	
			        }else if (selectedIndex == 1){
			        	int row = morminte.getSelectedRow();
						int id = (int) morminte.getValueAt(row, 0);
				        controller.deleteGrave(id);
			        }else if (selectedIndex == 2){
			        	int row = monumente.getSelectedRow();
						int id = (int) monumente.getValueAt(row, 0);
				        controller.deleteGrave(id);
			        }
				 print();
			}
		});
		contentPane.add(btnDelete, "cell 4 1,grow");
		setVisible(true);
	}
	
	public void print(){
		int selectedIndex = tabbedPane.getSelectedIndex();
    	
		if (selectedIndex == 0){
			modelDeceased.setRowCount(0);
        	deceased = (ArrayList<Deceased>) controller.getAllDeceased();
        	if (deceased != null)
        		for (Deceased d : deceased){
        			Object[] data = {d.getId(),d.getFirstName(),d.getLastName(),d.getReligion(),d.getGrave(),d.getBurialDate(),d.getValid()};
        			modelDeceased.addRow(data);
        		}
           
        }else if (selectedIndex == 1){
        	modelGrave.setRowCount(0);
        	grave = controller.getAllGrave();        		 
        	if (grave != null)
        		for (Grave g : grave){
        			Object[] data = {g.getId(),g.getParcelId(), g.getSurface(), g.getObservationId(), g.getIsMonument(), g.isValid()};
        			modelGrave.addRow(data);
        		}
        	
        }else if (selectedIndex == 2){
        	modelGrave.setRowCount(0);
        	grave = (ArrayList<Grave>) controller.getAllGrave();        		 
        	if (grave != null)
        		for (Grave g : grave){
        			if (g.getIsMonument()){
        				Object[] data = {g.getId(),g.getParcelId(), g.getSurface(), g.getObservationId(), g.getIsMonument(), g.isValid()};
        				modelGrave.addRow(data);
        			}
        		}
        }
	}
}
