package Controller;

import java.security.acl.Owner;
import java.util.Date;
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
	
	Controller(Repository repo){
		this.repo=repo;
	}
	
	//GENERAL
	public TableModel getBurialRegister(int year) {							//a) REGISTRUL ANUAL DE PROGRAMARE A INMORMANTARILOR
		return new BurialRegisterTableModel(repo,year);
	} 			
	public TableModel getGraveRegister(){return null;}						//b) REGISTRUL DE MORMINTE 
	public TableModel getMonumentRegister(){return null;}					//c) REGISTRUL DE MORMINTE-MONUMENTE FUNERARE 
	public TableModel getDeceasedRegister(int year){return null;}			//d) REGISTRUL INDEX ANUAL AL DECEDATILOR
	public TableModel getDeceasedWithoutCaregiver(int year){return null;}	//e) REGISTRUL ANUAL DE EVIDENTA A DECEDATILOR FARA APARTINATORI
	public TableModel getRequests(){return null;}							//f) REGISTRUL CU EVIDENTA CERERILOR DE ATRIBUIRE A LOCURILOR DE INHUMARE
	public TableModel getContracts(int year){return null;}					//g) REGISTRUL ANUAL DE EVIDENTA A CONTRACTELOR DE CONCESIUNE
	public TableModel getComplains(int year){return null;}					//h) REGISTRUL ANUAL CU EVIDENTA SESIZARILOR SI RECLAMATIILE CETATENILOR 
	
	
	
	//ALTE FUNCTIONALITATI
	public TableModel getExpiredGravesByYear(int year){return null;}		//locurile de veci expirate pe ani, cu toate datele de identificare 
	public TableModel getExpiringGraves() {return null;}					//locurile de veci care expira in anul in curs
	public TableModel getReceiptNumber(String graveId) {return null;}		//numărul chitantei cu care s-a facut plata si data emiterii
	public String getPaidPeriod(String graveId) {return null;}				//intervalul de timp pentru care s-a emis plata
	public TableModel getAllPaidGraves() {return null;}						//locuri de veci plătite în anul în curs cu toate datele de identificare de mai sus
	public void sendAlert(){}												// redactarea unei scrisori	catre concesionar prin care sa fie atentionat asupra situatiei platii locului de veci
	
	
	
	//ADMIN
	public TableModel getAllUser(){return null;}
	public void addUser(String id, String firstName, String lastName, String username, String password, String type){}
	public void updateUser(String id, String firstName, String lastName, String username, String password, String type){}
	public void deleteUser(String id){}
	public TableModel searchUser(String s){return null;}
	
	
	
	//INSPECTOR
	public TableModel getAllGrave(){return null;}
	public void addGrave(String id, String cemetery, String parcel, Owner owner, String surface, String observation, String type){}
	public void updateGrave(String id, String cemetery, String parcel, Owner owner, String surface, String observation, String type){}
	public void deleteGrave(String id){}
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
	
	public TableModel getAllDeceased(){return null;}
	public void addDeceased(String id, String firstName, String lastName, String religion, Grave grave, String burialDate){}
	public void updateDeceased(String id, String firstName, String lastName, String religion, Grave grave, String burialDate){}
	public void deleteDeceased(String id){}
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
