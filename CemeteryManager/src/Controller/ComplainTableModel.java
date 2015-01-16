package Controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Complainer;
import Model.Deceased;
import Model.Grave;
import Model.Parcel;
import Repository.Repository;

public class ComplainTableModel extends AbstractTableModel {
	private Repository repo;
	private String[] cols = { "Nume", "Prenume", "Reclamatia" };

	public ComplainTableModel(Repository repo) {
		this.repo = repo;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return repo.complainerRepo.getAllComplainer().size();
	}

	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Complainer> list = repo.complainerRepo.getAllComplainer();
		switch (columnIndex) {
		case 0:
			return list.get(rowIndex).getLastName();
		case 1:
			return list.get(rowIndex).getFirstName();
		case 2:
			return list.get(rowIndex).getReason();
		}
		return null;

	}
}
