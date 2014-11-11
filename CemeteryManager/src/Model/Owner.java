package Model;

public class Owner extends Person {
	private String domicile;
	private int receipt; // chitanta de plata
	private String period;
	
	
	public Owner(int id, String firstName, String lastName, String domicile,
			int receipt, String period) {
		super(id, firstName, lastName);
		this.domicile = domicile;
		this.receipt = receipt;
		this.period = period;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	public int getReceipt() {
		return receipt;
	}

	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}	
	
}
