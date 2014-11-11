package Model;

import java.util.Date;

public class Deceased extends Person {
	private String religion;
	private Grave grave;
	private Date burialDate;	
	
	public Deceased(int id, String firstName, String lastName, String religion,
			Grave grave, Date burialDate) {
		super(id, firstName, lastName);
		this.religion = religion;
		this.grave = grave;
		this.burialDate = burialDate;
	}
	
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public Grave getGrave() {
		return grave;
	}
	public void setGrave(Grave grave) {
		this.grave = grave;
	}
	public Date getBurialDate() {
		return burialDate;
	}
	public void setBurialDate(Date burialDate) {
		this.burialDate = burialDate;
	}
	
	
}
