package Model;
import java.sql.Date;
public class Deceased extends Person {
	private String religion;
	private int graveId;
	private Date burialDate;
	public Deceased(int id, String firstName, String lastName, String religion,
			int grave, Date burialDate) {
		super(id, firstName, lastName);
		this.religion = religion;
		this.graveId = grave;
		this.burialDate = burialDate;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public int getGrave() {
		return graveId;
	}
	public void setGrave(int grave) {
		this.graveId = grave;
	}
	public Date getBurialDate() {
		return burialDate;
	}
	public void setBurialDate(Date burialDate) {
		this.burialDate = burialDate;
	}
	
	public boolean isValid() {
		if (super.isValid() && religion.matches("[a-zA-z0-9.,]+")) {
			return true;
		}
		return false;
	}
}
