package Model;

public class Complainer extends Person  implements Data{
	private String reason;

	public Complainer(int id, String firstName, String lastName, String reason) {
		super(id, firstName, lastName);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public boolean isValid(){
		if (reason != null && reason.length()>0){
			return super.isValid();
		} else {
			return false;
		}
	}

}
