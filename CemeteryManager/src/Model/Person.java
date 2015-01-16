package Model;

public class Person extends MainData implements Data{
	int id;
	String firstName;
	String lastName;
	
	public Person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public boolean isValid() {
		if (id <=0 && firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
