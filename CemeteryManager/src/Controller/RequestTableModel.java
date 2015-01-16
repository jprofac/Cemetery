package Controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Deceased;
import Model.Grave;
import Model.Parcel;
import Model.Request;
import Repository.Repository;

public class RequestTableModel extends AbstractTableModel {
	private Repository repo;
	private String[] cols = {"Nr","Data","Nr Infocet", "Stadiu de solutionare" };

	public RequestTableModel(Repository repo) {
		this.repo = repo;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return repo.requestRepo.getAllRequest().size();
	}

	public int getColumnCount() {
		return cols.length;
	}

	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Request> list=repo.requestRepo.getAllRequest();
		Repository r=new Repository();
		for (Request x : r.requestRepo.getAllRequest())
			System.out.println(x.getDate());
        switch (columnIndex){
           case 0: return rowIndex+1;
           case 1: return list.get(rowIndex).getDate();
           case 2: return list.get(rowIndex).getInfocet();
           case 3: if (list.get(rowIndex).isCompleted())
        	   return "Terminat";
           else
        	   return "In curs";
        }
        return null;  
    }
}
