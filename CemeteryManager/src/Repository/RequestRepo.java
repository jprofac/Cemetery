package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Request;

import com.mysql.jdbc.Statement;

public class RequestRepo {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<Request> allRequest = null;

	public RequestRepo() throws ClassNotFoundException, SQLException {
		connectToDB();
		getAllRequest();
	}

	public List<Request> getAllRequest() throws SQLException {
		allRequest = new ArrayList<Request>();
		resultSet = statement.executeQuery("select * from request");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			Date date = resultSet.getDate("date");
			int infocet = resultSet.getInt("infocet");
			boolean completed = resultSet.getBoolean("completed");
			Request newRequest = new Request(id, date, infocet, completed);
			allRequest.add(newRequest);
		}
		return allRequest;
	}

	public void addRequest(Request g) throws SQLException {
		if (getRequestById(g.getId()) == null) {
			preparedStatement = connect
					.prepareStatement("insert into  request values (?, ?, ?, ?)");
			preparedStatement.setInt(1, g.getId());
			preparedStatement.setDate(2, (Date) g.getDate());
			preparedStatement.setInt(3, g.getInfocet());
			preparedStatement.setBoolean(4, g.isCompleted());
			preparedStatement.executeUpdate();
			allRequest.add(g);
		}
	}

	public void updateRequest(Request g) throws SQLException {
		if (getRequestById(g.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("update request set date = ?, infocet = ?, completed = ? where id = ?");
			preparedStatement.setDate(1, (Date) g.getDate());
			preparedStatement.setInt(2, g.getInfocet());
			preparedStatement.setBoolean(3, g.isCompleted());
			preparedStatement.setInt(4, g.getId());
			preparedStatement.executeUpdate();

			for (Request request : allRequest) {
				if (request.getId() == g.getId()) {
					request.setDate(g.getDate());
					request.setInfocet(g.getInfocet());
					request.setCompleted(g.isCompleted());
				}
			}
		}
	}

	public void deleteRequest(Request g) throws SQLException {
		if (getRequestById(g.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("delete from request where id = ?");
			preparedStatement.setInt(1, g.getId());
			preparedStatement.executeUpdate();
			allRequest.remove(g);
		}
	}

	public Request getRequestById(int id) {
		for (Request request : allRequest) {
			if (request.getId() == id) {
				return request;
			}
		}
		return null;
	}

	public List<Request> searchRequest(String s) {
		List<Request> searchResult = new ArrayList<Request>();
		for (Request request : allRequest) {
			String infocet = Integer.toString(request.getInfocet());
			String date = request.getDate().toString();
			if (date.contains(s) || infocet.contains(s)) {
				searchResult.add(request);
			}
		}
		return searchResult;
	}

	private void connectToDB() throws ClassNotFoundException, SQLException {
		// this will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		// setup the connection with the DB.
		connect = DriverManager
				.getConnection("jdbc:mysql://localhost/proiectcolectiv?"
						+ "user=root&password=root");

		// statements allow to issue SQL queries to the database
		statement = (Statement) connect.createStatement();
	}
}
