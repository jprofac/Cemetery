package Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.TableModel;

import Model.Cemetery;
import Model.Contract;
import Model.Deceased;
import Model.Grave;
import Model.Observation;
import Model.Owner;
import Model.Parcel;
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
	
	//numÄƒrul chitantei cu care s-a facut plata si data emiterii	
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
	public void generateReciept(String ownerId){}								//contractul de concesiune cand e cazul
	
	// contractul de concesiune
		public void generateContract(String contractId) {
			Contract c = repo.contractRepo.getContractById(Integer
					.parseInt(contractId));
			Owner o = repo.ownerRepo.getOwnerById(Integer.parseInt(contractId));
			Grave g = repo.graveRepo.getGraveById(Integer.parseInt(contractId));
			Parcel p = repo.parcelRepo.getParcelById(g.getParcelId());
			Cemetery cem = repo.cemeteryRepo.getCemeteryById(p.getCemeteryId());
			Observation obs = repo.observationRepo.getObservationById(g.getId());
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar
					.getInstance().getTime());
			Calendar cal = Calendar.getInstance();
			cal.setTime(c.getDate());
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			year += c.getPeriod();
			String s = "\t\tCONTRACT DE CONCESIUNE\n\t\tNR. "
					+ c.getId()
					+ " din "
					+ timeStamp
					+ "\n\nI. Partile contractante\n"
					+ "\tArt. 1. Municipiul CLUJ - NAPOCA prin Serviciul Administrare Cimitire\n"
					+ "Domeniul Public cu sediul in municipiul Cluj – Napoca, str. Avram Iancu nr.\n"
					+ "26-28, telefon 0264.454.421, reprezentant de primar Emil Boc in calitate de\n"
					+ "concedent,  pe de o parte, si D-nul/D-na "
					+ o.getLastName()
					+ " "
					+ o.getFirstName()
					+ " cu domiciliul in "
					+ o.getDomicile()
					+ "\nin calitate de concesionar pe de alta parte.\n"
					+ "In temeiul OUG nr. 54/2006 privind regimul contractelor de concesiune de bunuri\n"
					+ "proprietate publica, aprobata cu modificari prin Legea nr. 22/2007 si in conformitate\n"
					+ "cu HCL nr.300/2014 s-a incheiat prezentul contract de concesiune in urmatoarele conditii:\n"
					+ "II. Obiectul contractului de concesiune\n"
					+ "\tArt. 2. Obiectul contractului este concesionarea locului de inhumare situat in\n"
					+ cem.getName()
					+ ", parcela "
					+ p.getCode()
					+ ", nr. "
					+ g.getId()
					+ ", avand fiecare suprafata de "
					+ g.getSurface()
					+ " mp\n"
					+ "III. Termenul"
					+ "\n\tArt. 3. Durata concesiunii este de "
					+ c.getPeriod()
					+ " de ani, pentru perioada "
					+ getPaidPeriod(Integer.toString(g.getId()))
					+ "\n\tArt. 4. Durata contractului de concesiune poate fi prelungita, prin act aditional,\n"
					+ "In favoarea concesionarului sau a mostenitorilor acestuia pentru o perioada de inca "
					+ c.getPeriod() + " de ani,\n"
					+ "cu plata taxei de reconcesionare pana in data de " + year
					+ "-" + month + "-" + day
					+ " a anului urmator anului incare \n"
					+ "expira durata contractului.";
			String filename = "Contract_" + c.getId()+".txt";
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new FileWriter(filename));
				writer.write(s);

			} catch (IOException e) {
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (IOException e) {
				}
			}

		}

}
