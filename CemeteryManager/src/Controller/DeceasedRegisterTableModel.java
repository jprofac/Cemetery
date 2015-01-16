package Controller;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import Model.Cemetery;
import Model.Deceased;
import Model.Grave;
import Model.Parcel;
import Repository.Repository;

public class DeceasedRegisterTableModel extends AbstractTableModel {

	private Repository repo;
	private int year;
	private String[] cols = {"Nume","Prenume","Cimitir", "Parcela", "Numarul mormantului" };
	protected int[] row;

	public DeceasedRegisterTableModel(Repository repo, int year) {
		this.repo = repo;
		this.year = year;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return repo.deceasedRepo.getDeceasedByYear(year).size();
	}

	public int getColumnCount() {
		return cols.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Deceased> list=repo.deceasedRepo.getDeceasedByYear(year);
        switch (columnIndex){
           case 0: return list.get(rowIndex).getLastName();
           case 1: return list.get(rowIndex).getFirstName();
           case 2: return repo.cemeteryRepo.getCemeteryById(repo.parcelRepo.getParcelById(repo.graveRepo.getGraveById(list.get(rowIndex).getGrave()).getParcelId()).getCemeteryId()).getName();               
           case 3: return repo.parcelRepo.getParcelById(repo.graveRepo.getGraveById(list.get(rowIndex).getGrave()).getParcelId()).getCode();
           case 4: return Integer.toString(repo.graveRepo.getGraveById(list.get(rowIndex).getGrave()).getId());
        }
        return null;  
    }
	
}

