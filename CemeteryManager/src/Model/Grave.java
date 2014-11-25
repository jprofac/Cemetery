package Model;

public class Grave {
	private int id;
	private int cemeteryId;
	private int parcelId;
	private int  ownerId; // daca exista
	private String surface;
	private int observationId;
	private String type;
	
	public Grave(int id, int cemeteryId, int parcelId, int ownerId,
			String surface, int observationId, String type) {
		super();
		this.id = id;
		this.cemeteryId = cemeteryId;
		this.parcelId = parcelId;
		this.ownerId = ownerId;
		this.surface = surface;
		this.observationId = observationId;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCemeteryId() {
		return cemeteryId;
	}

	public void setCemeteryId(int cemeteryId) {
		this.cemeteryId = cemeteryId;
	}

	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	public int getObservationId() {
		return observationId;
	}

	public void setObservationId(int observationId) {
		this.observationId = observationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}

	