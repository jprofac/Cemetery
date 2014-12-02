package Model;

/**
 * @author Maria Gligor The class responsible for Exceptions
 */
public class MyException extends Exception {
	/**
	 * @uml.property  name="message"
	 */
	private String message = null;

	// Default constructor
	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
		this.message = msg;
	}

	public MyException(Throwable ex) {
		super(ex);
	}

	/**
	 * @return
	 * @uml.property name="message"
	 */
	@Override
	public String getMessage() {
		return this.message;
	}
}
