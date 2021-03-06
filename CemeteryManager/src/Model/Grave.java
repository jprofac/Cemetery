package Model;

public class Grave extends MainData implements Data{
	private int id;
	private int parcelId;
	private int surface;
	private int observationId;
	private boolean isMonument;
	private boolean valid;
	
	public Grave(int id, int parcelId, int surface, int observationId, boolean isMonument, boolean valid) {
		super();
		this.id = id;
		this.parcelId = parcelId;
		this.surface = surface;
		this.observationId = observationId;
		this.isMonument = isMonument;
		this.valid = valid;
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

	public boolean getIsMonument() {
		return isMonument;
	}

	public void setIsMonument(boolean isMonument) {
		this.isMonument = isMonument;
	}

	@Override
	public boolean isValid() {
		return this.valid;
	}
	
	
	
}

	