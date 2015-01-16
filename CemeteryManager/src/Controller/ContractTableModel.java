package Controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Contract;
import Model.Deceased;
import Model.Owner;
import Repository.Repository;

public class ContractTableModel extends AbstractTableModel {

	private Repository repo;
	private int year;
	private String[] cols = {"Nr","Nr contract","Data","Nume","Prenume","Adresa" };
	protected int[] row;

	public ContractTableModel(Repository repo, int year) {
		this.repo = repo;
		this.year = year;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return repo.contractRepo.getContractsByYear(year).size();
	}

	public int getColumnCount() {
		return cols.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Contract> list=repo.contractRepo.getContractsByYear(year);
        switch (columnIndex){
           case 0: return rowIndex+1;
           case 1: return list.get(rowIndex).getId();
           case 2: return list.get(rowIndex).getDate();
           case 3: return repo.ownerRepo.getOwnerById(list.get(rowIndex).getId()).getLastName();               
           case 4: return repo.ownerRepo.getOwnerById(list.get(rowIndex).getId()).getFirstName(); 
           case 5: return repo.ownerRepo.getOwnerById(list.get(rowIndex).getId()).getDomicile(); 
        }
        return null;  
        
    }
	
}
