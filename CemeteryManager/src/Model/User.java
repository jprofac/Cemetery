package Model;

public class User extends Person {
	String username;
	String password;
	String type;
	
	public User(int id, String firstName, String lastName, String username,
			String password, String type) {
		super(id, firstName, lastName);
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
