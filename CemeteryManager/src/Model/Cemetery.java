package Model;

public class Cemetery extends MainData  implements Data{
	int id;
	String name;
	String address;
	int valid=1;
	
	public Cemetery(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


	@Override
	public boolean isValid() {
		if (name.matches("[a-zA-Z]+") && address.matches("[a-zA-z0-9.,]+")) {
			return true;
		}
		return false;
	}
	
	
}
