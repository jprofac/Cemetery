package Repository;

public class Repository {
	
	
	//the main repository hold the sub repositories as public fields
	// we can access the through a Repository object in the controller
	// such as rep.cemeteryRepo.*method*(*params*);
	public CemeteryRepo cemeteryRepo;
	public ComplainerRepo complainerRepo;
	public ContractRepo contractRepo;
	public DeceasedRepo deceasedRepo;
	public GraveRepo graveRepo;
	public ObservationRepo observationRepo;
	public RequestRepo requestRepo;
	public UserRepo userRepo;
	public ParcelRepo parcelRepo;
	public OwnerRepo ownerRepo;
	
	public Repository(){
		try {
		cemeteryRepo = new CemeteryRepo();
		complainerRepo = new ComplainerRepo();
		contractRepo = new ContractRepo();
		deceasedRepo = new DeceasedRepo();
		graveRepo = new GraveRepo();
		observationRepo = new ObservationRepo();
		requestRepo = new RequestRepo();
		userRepo = new UserRepo();
		parcelRepo = new ParcelRepo();
		ownerRepo = new OwnerRepo();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*private List<Deceased> deceased;
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
	public List<User> searchUser(String s){return null;}*/
	
}
