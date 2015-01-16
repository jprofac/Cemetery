package Model;

public class Grave extends MainData implements Data{
	private int id;
	private int parcelId;
	private int surface;
	private int observationId;
	private String type;
	
	public Grave(int id, int parcelId, int surface, int observationId, String type) {
		super();
		this.id = id;
		this.parcelId = parcelId;
		this.surface = surface;
		this.observationId = observationId;
		this.type = type;
	}

	public int getId() {
		return id;
	}


	public int getParcelId() {
		return parcelId;
	}

	public void setParcelId(int parcelId) {
		this.parcelId = parcelId;
	}


	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
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

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}

	