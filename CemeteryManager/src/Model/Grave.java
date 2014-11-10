package Model;

public class Grave {
	private int id;
	private String cemetery;
	private String parcel;
	private Owner  owner; // daca exista
	private String surface;
	private Observation observation;
	private String type;

	public Grave(int id, String cemetery, String parcel, Owner owner,
			String surface, Observation observation, String type) {
		super();
		this.id = id;
		this.cemetery = cemetery;
		this.parcel = parcel;
		this.owner = owner;
		this.surface = surface;
		this.observation = observation;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCemetery() {
		return cemetery;
	}

	public void setCemetery(String cemetery) {
		this.cemetery = cemetery;
	}

	public String getParcel() {
		return parcel;
	}

	public void setParcel(String parcel) {
		this.parcel = parcel;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setIdOwner(Owner owner) {
		this.owner = owner;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public Observation getObservation() {
		return observation;
	}

	public void setObservation(Observation observation) {
		this.observation = observation;
	}
}
