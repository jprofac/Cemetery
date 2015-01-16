package Model;

import java.util.Date;

public class Contract extends MainData implements Data{
	private int id;
	private int ownerId;
	private int graveId;
	private Date date;
	private int period;
	private int receipt;	//numarul chitantei de plata

	public Contract(int id, int ownerId, int graveId, Date date, int period,
			int receipt) {
		super();
		this.id = id;
		this.ownerId = ownerId;
		this.graveId = graveId;
		this.date = date;
		this.receipt = receipt;
		this.period = period;
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

	public int getReceipt() {
		return receipt;
	}

	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}


}