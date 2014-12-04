package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cemetery;
import Model.Data;
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
		ArrayList<Request> list = new ArrayList<Request>();
		for (Data d : DataBase.getInstance().getAll(DataBase.REQUEST)){
			list.add((Request) d);
		}
		return list;
	}

	public void addRequest(Request g) throws SQLException {
		DataBase.getInstance().addData(g);
	}

	public void updateRequest(Request g) throws SQLException {
		DataBase.getInstance().updateData(g);
	}

	public void deleteRequest(Request g) throws SQLException {
		DataBase.getInstance().deleteData(g);
	}

	public Request getRequestById(int id) {
		return (Request)DataBase.getInstance().getDataById(id, DataBase.REQUEST);
	}

	public List<Request> searchRequest(String s) {
		/*List<Request> searchResult = new ArrayList<Request>();
		for (Request request : allRequest) {
			String infocet = Integer.toString(request.getInfocet());
			String date = request.getDate().toString();
			if (date.contains(s) || infocet.contains(s)) {
				searchResult.add(request);
			}
		}*/
		return null;
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
