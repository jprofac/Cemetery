package Model;

public class Owner {
	private int id;
	private String firstName;
	private String lastName;
	private String domicile;
	private int receipt; // chitanta de plata

	public Owner(int id, String firstName, String lastName, String domicile,
			int receipt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.domicile = domicile;
		this.receipt = receipt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
