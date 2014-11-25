package Model;

public class Owner extends Person {
	private String domicile;
	
	
	public Owner(int id, String firstName, String lastName, String domicile) {
		super(id, firstName, lastName);
		this.domicile = domicile;
	}


	public String getDomicile() {
		return domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	
}
