package Controller;

import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Cemetery;
import Model.Deceased;
import Model.Grave;
import Model.Parcel;
import Repository.Repository;

public class BurialRegisterTableModel extends AbstractTableModel {
	private Repository repo;
	private int size;
	private int year;
	private String[] cols = {"Nume","Prenume","Religia", "Locul inmormantarii", "Data inmormantarii)" };

	public BurialRegisterTableModel(Repository repo, int year) {
		this.repo = repo;
		this.year = year;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return size;
	}

	public int getColumnCount() {
		return cols.length;
	}
	
	public void setRegistry() {
		for (Deceased d: repo.deceasedRepo.getAllDeceased()){
			Grave g=repo.graveRepo.getGraveById(d.getGrave());
			Parcel p=repo.parcelRepo.getParcelById(g.getParcelId());
			Calendar cal = Calendar.getInstance();
		    cal.setTime(d.getBurialDate());
		    int y = cal.get(Calendar.YEAR);
		    if (this.year==y){
		    	cols[0]=d.getLastName();
				cols[1]=d.getFirstName();
				cols[2]=d.getReligion();
				cols[3]=p.getCode();
				cols[4]=d.getBurialDate().toString();
		    }
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}
}
