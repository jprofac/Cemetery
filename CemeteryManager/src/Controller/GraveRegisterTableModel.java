package Controller;

import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Cemetery;
import Model.Contract;
import Model.Deceased;
import Model.Grave;
import Model.Observation;
import Model.Owner;
import Model.Parcel;
import Repository.Repository;

public class GraveRegisterTableModel extends AbstractTableModel {
	private Repository repo;
	private String[] cols = { "Cimitir", "Parcela", "Nr Mormantului",
			"Detinator", "Domiciliu", "Chitanta", "Decedat", "Data inhumarii", "Suprafata","Constructie", "Nr Modificare",
			"Fotografia" };

	public GraveRegisterTableModel(Repository repo) {
		this.repo = repo;
	}

	public String getColumnName(int column) {
		return cols[column];
	}

	public int getRowCount() {
		return repo.contractRepo.getAllContract().size();
	}

	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		List<Contract> list=repo.contractRepo.getAllContract();
        switch (columnIndex){
           case 0: return repo.cemeteryRepo.getCemeteryById(repo.parcelRepo.getParcelById(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getParcelId()).getCemeteryId()).getName();

           case 1: return  repo.parcelRepo.getParcelById(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getParcelId()).getCode();
           case 2: return  Integer.toString(list.get(rowIndex).getGraveId());              
           case 3: return  repo.ownerRepo.getOwnerById(list.get(rowIndex).getOwnerId()).getFirstName() + " " + repo.ownerRepo.getOwnerById(list.get(rowIndex).getOwnerId()).getLastName();
           case 4: return  repo.ownerRepo.getOwnerById(list.get(rowIndex).getOwnerId()).getDomicile();           
           case 5: return  Integer.toString(list.get(rowIndex).getReceipt());
           case 6: return  repo.deceasedRepo.getDeceasedByGrave(list.get(rowIndex).getGraveId()).getFirstName() + " "+ repo.deceasedRepo.getDeceasedByGrave(list.get(rowIndex).getGraveId()).getLastName();
           case 7: return  repo.deceasedRepo.getDeceasedByGrave(list.get(rowIndex).getGraveId()).getBurialDate();
           case 8: return  Integer.toString(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getSurface());
           case 9: if (repo.observationRepo.getObservationById(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getObservationId()).isTomb())
        		   return "Da";
           else return "Nu";
           case 10: return Integer.toString(repo.observationRepo.getObservationById(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getObservationId()).getModificationNr());
           case 11: repo.observationRepo.getObservationById(repo.graveRepo.getGraveById(list.get(rowIndex).getGraveId()).getObservationId()).getPhotography();
        }
        return null;  
	}
}
