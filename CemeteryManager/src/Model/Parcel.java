package Model;

public class Parcel extends MainData implements Data{
	int id;
	String code;		//ex. A1 or B3
	int cemeteryId;
		
	
	public Parcel(int id, String code, int cemeteryId) {
		super();
		this.id = id;
		this.code = code;
		this.cemeteryId = cemeteryId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCemeteryId() {
		return cemeteryId;
	}
	public void setCemeteryId(int cemeteryId) {
		this.cemeteryId = cemeteryId;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}
}
