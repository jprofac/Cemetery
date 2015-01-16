package Controller;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Cemetery;
import Model.Deceased;
import Model.Grave;
import Model.Parcel;
import Repository.Repository;

public class BurialRegisterTableModel extends AbstractTableModel {
	private Repository repo;
	private int year;
	private String[] cols = { "Nume", "Prenume", "Religia",
			"Locul inmormantarii", "Data inmormantarii" };

	public BurialRegisterTableModel(Repository repo, int year) {
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
		List<Deceased> list = repo.deceasedRepo.getDeceasedByYear(year);
		switch (columnIndex) {
		case 0:
			return list.get(rowIndex).getLastName();
		case 1:
			return list.get(rowIndex).getFirstName();
		case 2:
			return list.get(rowIndex).getReligion();
		case 3: {
			Grave g = repo.graveRepo
					.getGraveById(list.get(rowIndex).getGrave());
			Parcel p = repo.parcelRepo.getParcelById(g.getParcelId());
			return p.getCode();
		}
		case 4:
			return list.get(rowIndex).getBurialDate().toString();
		}
		return null;
	}
}
