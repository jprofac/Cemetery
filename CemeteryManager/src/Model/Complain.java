package Model;

public class Complain {
	private int id;
	private String complainer;
	private String reason;

	public Complain(int id, String complainer, String reason) {
		super();
		this.id = id;
		this.complainer = complainer;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplainer() {
		return complainer;
	}

	public void setComplainer(String complainer) {
		this.complainer = complainer;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
