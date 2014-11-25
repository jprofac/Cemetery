package Model;

import java.util.Date;

public class Contract {
	private int id;
	private int ownerId;
	private int graveId;
	private Date date;
	
	public Contract(int id, int ownerId, int graveId, Date date) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.graveId = graveId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getGraveId() {
		return graveId;
	}

	public void setGraveId(int graveId) {
		this.graveId = graveId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
