package Model;

import java.util.Date;

public class Request {
	public static int field = 0;
	private int id;
	private Date date;
	private String infocet;
	private boolean completed; // stadiu de solutionare

	public Request(int id, Date date, String infocet, boolean completed) {
		super();
		this.id = id;
		this.date = date;
		this.infocet = infocet;
		this.completed = completed;
	}

	public static int getField() {
		return field;
	}

	public static void setField(int field) {
		Request.field = field;
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

	public String getInfocet() {
		return infocet;
	}

	public void setInfocet(String infocet) {
		this.infocet = infocet;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean comleted) {
		this.completed = comleted;
	}
}
