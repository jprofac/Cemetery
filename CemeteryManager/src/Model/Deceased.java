package Model;

import java.util.Date;

public class Deceased {
	private int id;
	private String firstName;
	private String lastName;
	private String religion;
	private int idGrave;
	private Date burialDate;

	public Deceased(int id, String firstName, String lastName, String religion,
			int idGrave, Date burialDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.religion = religion;
		this.idGrave = idGrave;
		this.burialDate = burialDate;
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

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public int getIdGrave() {
		return idGrave;
	}

	public void setIdGrave(int idGrave) {
		this.idGrave = idGrave;
	}

	public Date getBurialDate() {
		return burialDate;
	}

	public void setBurialDate(Date burialDate) {
		this.burialDate = burialDate;
	}

}
