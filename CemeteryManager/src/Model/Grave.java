package Model;

public class Grave {
	private int id;
	private String cemetery;
	private String parcel;
	private int idOwner; // daca exista
	private String surface;
	private int idObservation;
	private String type;

	public Grave(int id, String cemetery, String parcel, int idOwner,
			String surface, int idObservation, String type) {
		super();
		this.id = id;
		this.cemetery = cemetery;
		this.parcel = parcel;
		this.idOwner = idOwner;
		this.surface = surface;
		this.idObservation = idObservation;
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

	public int getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public int getIdObservation() {
		return idObservation;
	}

	public void setIdObservation(int idObservation) {
		this.idObservation = idObservation;
	}
}
