package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cemetery;

import com.mysql.jdbc.Statement;

public class CemeteryRepo {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<Cemetery> allCemetery = null;

	public CemeteryRepo() throws ClassNotFoundException, SQLException {
		connectToDB();
		getAllCemetery();
	}

	public List<Cemetery> getAllCemetery() throws SQLException {
		allCemetery = new ArrayList<Cemetery>();
		resultSet = statement.executeQuery("select * from cemetery");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String address = resultSet.getString("address");
			Cemetery newCemetery = new Cemetery(id, name, address);
			allCemetery.add(newCemetery);
		}
		return allCemetery;
	}

	public void addCemetery(Cemetery g) throws SQLException {
		if (getCemeteryById(g.getId()) == null
				&& isValid(g.getName(), g.getAddress())) {
			preparedStatement = connect
					.prepareStatement("insert into  cemetery values (? , ?, ?)");
			preparedStatement.setInt(1, g.getId());
			preparedStatement.setString(2, g.getName());
			preparedStatement.setString(3, g.getAddress());
			preparedStatement.executeUpdate();
			allCemetery.add(g);
		}
	}

	public void updateCemetery(Cemetery g) throws SQLException {
		if (isValid(g.getName(), g.getAddress())) {
			preparedStatement = connect
					.prepareStatement("update cemetery set name = ?, address = ? where id = ?");
			preparedStatement.setString(1, g.getName());
			preparedStatement.setString(2, g.getAddress());
			preparedStatement.setInt(3, g.getId());
			preparedStatement.executeUpdate();

			for (Cemetery cemetery : allCemetery) {
				if (cemetery.getId() == g.getId()) {
					cemetery.setName(g.getName());
					cemetery.setAddress(g.getAddress());
				}
			}
		}
	}

	public void deleteCemetery(Cemetery g) throws SQLException {
		if (getCemeteryById(g.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("delete from cemetery where id = ?");
			preparedStatement.setInt(1, g.getId());
			preparedStatement.executeUpdate();
			allCemetery.remove(g);
		}

	}

	public Cemetery getCemeteryById(int id) {
		for (Cemetery cemetery : allCemetery) {
			if (cemetery.getId() == id) {
				return cemetery;
			}
		}
		return null;
	}

	public List<Cemetery> searchCemetery(String s) {
		List<Cemetery> searchResult = new ArrayList<Cemetery>();
		for (Cemetery cemetery : allCemetery) {
			if (cemetery.getName().contains(s)
					|| cemetery.getAddress().contains(s)) {
				searchResult.add(cemetery);
			}
		}
		return searchResult;
	}

	private boolean isValid(String name, String address) {
		if (name.matches("[a-zA-Z]+") && address.matches("[a-zA-z0-9.,]+")) {
			return true;
		}
		return false;
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
