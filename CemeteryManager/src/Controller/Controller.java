package Controller;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.swing.table.TableModel;

import Model.Deceased;
import Model.Grave;
import Model.Observation;
import Model.Request;
import Model.User;
import Repository.Repository;

public class Controller {
	private Repository repo;
	
	public Controller(Repository repo){
		this.repo=repo;
	}
	
	//GENERAL
	public TableModel getBurialRegister(int year) {	
		return new BurialRegisterTableModel(repo,year);
	} 		
	
	public TableModel getGraveRegister(){			 
		return new GraveRegisterTableModel(repo);
	}	
	
	
	public TableModel getDeceasedRegister(int year){
		return new DeceasedRegisterTableModel(repo, year);	
	}
	
	public TableModel getRequests(){
		return new RequestTableModel(repo);
	}	
	
	public TableModel getContracts(int year){		
		return new ContractTableModel(repo,year);
		
	}					
	public TableModel getComplains(){
		return new ComplainTableModel(repo);
	}	
	
	//ALTE FUNCTIONALITATI
	public TableModel getExpiredGravesByYear(int year){
		return new GraveTableModel(repo.graveRepo.getExpiring(year));
	}		
	
	public TableModel getExpiringGraves() {
		return new GraveTableModel(repo.graveRepo.getExpiring(Calendar.getInstance().get(Calendar.YEAR)));
	}
	
	//numărul chitantei cu care s-a facut plata si data emiterii	
	public String getReceiptNumber(String graveId) {	
		return "Chitanta: "+repo.contractRepo.getContractByGrave(Integer.parseInt(graveId)).getReceipt()+"\nData: "
				+repo.contractRepo.getContractByGrave(Integer.parseInt(graveId)).getDate();
	}	
	
	//intervalul de timp pentru care s-a emis plata
	public String getPaidPeriod(String graveId) {
		Date date1= repo.contractRepo.getContractByGrave(Integer.parseInt(graveId)).getDate();
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date1);
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    year+=repo.contractRepo.getContractByGrave(Integer.parseInt(graveId)).getPeriod();
	    return "Intervalul platit: "+date1+" - "+year+"-"+month+"-"+day;
	}
		
	public TableModel getAllPaidGraves() {return new GraveTableModel(repo.graveRepo.getPaid());}		
	
	
	//ADMIN
	public TableModel getAllUser(){return null;}
	public void addUser(String id, String firstName, String lastName, String username, String password, String type){}
	public void updateUser(String id, String firstName, String lastName, String username, String password, String type){}
	public void deleteUser(String id){}
	public TableModel searchUser(String s){return null;}
	
	
	
	//INSPECTOR
	public ArrayList<Grave> getAllGrave(){return repo.graveRepo.getAllGrave();}
	public void addGrave(int id, int parcelId, int surface, int observationId, boolean isMonument, boolean valid){
		repo.graveRepo.addGrave(new Grave(id,parcelId,surface,observationId,isMonument,valid));
	}
	//public void updateGrave(String id, String cemetery, String parcel, Owner owner, String surface, String observation, String type){
	public void updateGrave(int id, int parcelId, int surface, int observationId, boolean isMonument, boolean valid){
		repo.graveRepo.updateGrave(new Grave(id,parcelId,surface,observationId,isMonument,valid));
	}
	public void deleteGrave(int id){repo.graveRepo.deleteGrave(
			repo.graveRepo.getGraveById(id));
	}
	public TableModel searchGrave(String s){return null;}
	
	public TableModel getAllObservation(){return null;}
	public void addObservation(String id, boolean tomb, String modificationNr, String photography){}
	public void updateObservation(String id, boolean tomb, String modificationNr, String photography){}
	public void deleteObservation(String id){}
	public TableModel searchObservation(String s){return null;}
	
	public TableModel getAllOwner(){return null;}
	public void addOwner(String id, String firstName, String lastName, String domicile, String receipt, String period){}
	public void updateOwner(String id, String firstName, String lastName, String domicile, String receipt, String period){}
	public void deleteOwner(String id){}
	public TableModel searchOwner(String s){return null;}
	
	public ArrayList<Deceased>  getAllDeceased(){return repo.deceasedRepo.getAllDeceased();}
	public void addDeceased(int id, String firstName, String lastName, String religion, int graveId, Date burialDate){
		
		repo.deceasedRepo.addDeceased(new Deceased(id, firstName, lastName, religion, graveId,burialDate));
		}
	public void updateDeceased(int id, String firstName, String lastName, String religion, int graveId, Date burialDate){
		repo.deceasedRepo.updateDeceased(new Deceased(id, firstName, lastName, religion, graveId,burialDate));
	}
	public void deleteDeceased(int id){repo.deceasedRepo.deleteDeceased(repo.deceasedRepo.getDeceasedById(id));}
	public TableModel searchDeceased(String s){return null;}
	
	
	
	//Registratura primariei
	public TableModel getAllRequest(){return null;}
	public void addRequest(String id, String date, String infocet, boolean completed){}
	public void updateRequest(String id, String date, String infocet, boolean completed){}
	public void deleteRequest(String id){}
	public TableModel searchRequest(String s){return null;}
	
	public void sendRequest(Request r){}
	public void changeRequestStatus(int requestId, boolean status){}
	
	
	
	//Relatii cu publicul
	public void generateDiggingCommand(String graveId){}					//comanda sapat grapa catre RADP
	public void generateDeceasedDocument(String deceasedId){}				//act pentru preot
	public void generateReciept(String ownerId){}							//dispozitia de plata a cheltuielilor aferente
	public void generateContract(String ownerId){}							//contractul de concesiune cand e cazul

}
