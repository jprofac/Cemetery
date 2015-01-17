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
	Repository repo = new Repository();
	Controller controller;
	ArrayList<Deceased> deceased = new ArrayList<Deceased>();
	ArrayList<Grave> grave= new ArrayList<Grave>();
	DefaultTableModel modelDeceased;
	DefaultTableModel modelGrave;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InspectorGUI() {
		controller = new Controller(repo);
		setTitle("Inspector\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 737, 521);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[180px][91px][140px][79px][160px]", "[336px][50px]"));
			
		String[] columnDeceasedNames = {"CNP", "First Name", "Last Name", "Religion", "GraveID", "burialDate"};
		String[] columnGraveNames = {"CNP", "First Name", "Last Name", "Religion", "GraveID", "burialDate"};
		modelDeceased = new DefaultTableModel(columnDeceasedNames,0);
		modelGrave = new DefaultTableModel(columnGraveNames,0);
		   	    
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		final JTable decedati = new JTable(modelDeceased);
		final JTable morminte = new JTable(modelGrave);
		JTable monumente = new JTable();
		tabbedPane.addTab("Decedati", decedati);
		tabbedPane.addTab("Morminte", morminte);
		tabbedPane.addTab("Monumente", monumente);
		contentPane.add(tabbedPane, "cell 0 0 5 1,grow");
	
		grave.add(new Grave(1,1,1,1,false));
		
		 tabbedPane.addChangeListener(new ChangeListener() {
		        public void stateChanged(ChangeEvent e) {		        	
		        	int selectedIndex = tabbedPane.getSelectedIndex();
		        	
		    		if (selectedIndex == 0){
		            	deceased = (ArrayList<Deceased>) controller.getAllDeceased();
		            	if (deceased != null)
		            		for (Deceased d : deceased){
		            			Object[] data = {d.getId(),d.getFirstName(),d.getLastName()};
		            			modelDeceased.addRow(data);
		            		}
		               
		            }else if (selectedIndex == 1){
		            	//grave = (ArrayList<Grave>) controller.getAllGrave();
		            	modelGrave.setRowCount(0);	 
		            	if (grave != null)
		            		for (Grave g : grave){
		            			Object[] data = {g.getId(),g.getSurface(),g.getParcelId()};
		            			modelGrave.addRow(data);
		            		}
		            	
		            }else if (selectedIndex == 2){
		            	controller.getAllGrave();
		            }
		
		        }
		    }); 
		
		
		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO separate Adauga button for the different tabs 
				
		        int selectedIndex = tabbedPane.getSelectedIndex();		        
		        if (selectedIndex == 0){
		        	new DeceasedInfoGUI();
		        }else if (selectedIndex == 1){
		        	new GraveInfoGUI();
		        }else if (selectedIndex == 2){
		        	
		        }
			}
		});
		contentPane.add(btnAdauga, "cell 0 1,grow");
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				int selectedIndex = tabbedPane.getSelectedIndex();
				 if (selectedIndex == 0){
			        	new DeceasedInfoGUI();
			        }else if (selectedIndex == 1){
			        	new GraveInfoGUI();
			        }else if (selectedIndex == 2){
			        	
			        }				
			}
		});
		contentPane.add(btnModifica, "cell 2 1,grow");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				int selectedIndex = tabbedPane.getSelectedIndex();		        
		        if (selectedIndex == 0){
		  //      	new DeceasedInfoGUI();
		        }else if (selectedIndex == 1){
		    //    	new GraveInfoGUI();
		        }else if (selectedIndex == 2){
		        	
		        }
			}
		});
		contentPane.add(btnDelete, "cell 4 1,grow");
		setVisible(true);
	}
}
