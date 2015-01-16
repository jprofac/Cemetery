package Controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Grave;

public class GraveTableModel extends AbstractTableModel {
	private List<Grave> graveList;
	private String[] cols = { "ID", "ID Observatie", "ID Parcela", "Suprafata",
			"Tipul" };

	public GraveTableModel(List<Grave> graveList) {
		this.graveList = graveList;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return graveList.size();
	}

	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		for (Grave x : graveList)
			switch (columnIndex) {
			case 0:
				return graveList.get(rowIndex).getId();
			case 1:
				return graveList.get(rowIndex).getObservationId();
			case 2:
				return graveList.get(rowIndex).getParcelId();
			case 3:
				return graveList.get(rowIndex).getSurface();
			case 4:
				return graveList.get(rowIndex).getIsMonument();
			}
		return null;
	}
}
