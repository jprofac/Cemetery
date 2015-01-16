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


	public static Repository instance;

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository();
		}
		return instance;
	}
	
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
	
}
