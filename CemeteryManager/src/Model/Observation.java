package Model;

public class Observation extends MainData implements Data{
	private int id;
	private boolean tomb; // existenta/inexistenta constructiilor funerare
	private int modificationNr; // nrActuluiModificari
	private String photography;

	public Observation(int id, boolean tomb, int modificationNr,
			String photography) {
		super();
		this.id = id;
		this.tomb = tomb;
		this.modificationNr = modificationNr;
		this.photography = photography;
	}

	public int getId() {
		return id;
	}

	public boolean isTomb() {
		return tomb;
	}

	public void setTomb(boolean tomb) {
		this.tomb = tomb;
	}

	public int getModificationNr() {
		return modificationNr;
	}

	public void setModificationNr(int modificationNr) {
		this.modificationNr = modificationNr;
	}

	public String getPhotography() {
		return photography;
	}

	public void setPhotography(String photography) {
		this.photography = photography;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
