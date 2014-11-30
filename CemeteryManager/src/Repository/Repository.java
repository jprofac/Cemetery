package Repository;

import java.security.acl.Owner;
import java.util.List;

import Model.Complainer;
import Model.Contract;
import Model.Deceased;
import Model.Grave;
import Model.Observation;
import Model.Request;
import Model.User;

public class Repository {
	private List<Deceased> deceased;
	private List<Contract> contracts;
	private List<Observation> observations;
	private List<Owner> owners;
	private List<Complainer> complains;
	private List<Grave> graves;
	private List<Request> requests;
	private List<User> users;
	
	
	//DECEASED
	public List<Deceased> getAllDeceased(){return null;}
	public void addDeceased(Deceased d){}
	public void updateDeceased(Deceased d){}
	public void deleteDeceased(Deceased d){}
	public Deceased getDeceasedById(int id){return null;}
	public List<Deceased> searchDeceased(String s){return null;}
	
	//CONTRACT
	public List<Contract> getAllContract(){return null;}
	public void addContract(Contract c){}
	public void updateContract(Contract c){}
	public void deleteContract(Contract c){}
	public Contract getContractById(int id){return null;}
	public List<Contract> searchContract(String s){return null;}
	
	//OBSERVATION
	public List<Observation> getAllObservation(){return null;}
	public void addObservation(Observation o){}
	public void updateObservation(Observation o){}
	public void deleteObservation(Observation o){}
	public Observation getObservationById(int id){return null;}
	public List<Observation> searchObservation(String s){return null;}
	
	//OWNER
	public List<Owner> getAllOwner(){return null;}
	public void addOwner(Owner o){}
	public void updateOwner(Owner o){}
	public void deleteOwner(Owner o){}
	public Owner getOwnerById(int id){return null;}
	public List<Owner> searchOwner(String s){return null;}
	
	//COMPLAIN
	public List<Complainer> getAllComplain(){return null;}
	public void addComplain(Complainer c){}
	public void updateComplain(Complainer c){}
	public void deleteComplain(Complainer c){}
	public Complainer getComplainById(int id){return null;}
	public List<Complainer> searchComplain(String s){return null;}
	
	//GRAVE
	public List<Grave> getAllGrave(){return null;}
	public void addGrave(Grave g){}
	public void updateGrave(Grave g){}
	public void deleteGrave(Grave g){}
	public Grave getGraveById(int id){return null;}
	public List<Grave> searchGrave(String s){return null;}
	
	//REQUEST
	public List<Request> getAllRequest(){return null;}
	public void addRequest(Request r){}
	public void updateRequest(Request r){}
	public void deleteRequest(Request r){}
	public Request retRequestById(int id){return null;}
	public List<Request> searchRequest(String s){return null;}
	
	//USER
	public List<User> getAllUser(){return null;}
	public void addUser(User u){}
	public void updateUser(User u){}
	public void deleteUser(User u){}
	public User uetUserById(int id){return null;}
	public List<User> searchUser(String s){return null;}
	
}
