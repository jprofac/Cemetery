package Model;

public class Complain {
	private int id;
	private Person complainer;
	private String reason;
	
	public Complain(int id, Person complainer, String reason) {
		super();
		this.id = id;
		this.complainer = complainer;
		this.reason = reason;
	}	

	public Person getComplainer() {
		return complainer;
	}

	public void setComplainer(Person complainer) {
		this.complainer = complainer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
