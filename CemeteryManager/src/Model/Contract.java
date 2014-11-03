package Model;

import java.util.Date;

public class Contract {
	private int id;
	private Date date;
	private String lastName;
	private String firstName;
	private String address;

	public Contract(int id, Date date, String lastName, String firstName,
			String address) {
		super();
		this.id = id;
		this.date = date;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
