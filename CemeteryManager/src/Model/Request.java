package Model;

import java.util.Date;

public class Request extends MainData implements Data{
	private int id;
	private Date date;
	private int infocet;
	private boolean completed; // stadiu de solutionare

	public Request(int id, Date date, int infocet, boolean completed) {
		super();
		this.id = id;
		this.date = date;
		this.infocet = infocet;
		this.completed = completed;
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

	public int getInfocet() {
		return infocet;
	}

	public void setInfocet(int infocet) {
		this.infocet = infocet;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean comleted) {
		this.completed = comleted;
	}


	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
