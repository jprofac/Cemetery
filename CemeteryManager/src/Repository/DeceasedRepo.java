package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Deceased;
import Model.Owner;
import Model.Request;

import com.mysql.jdbc.Statement;

public class DeceasedRepo {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<Deceased> allDeceased = null;
	
	public DeceasedRepo() throws ClassNotFoundException, SQLException {
		connectToDB();
		getAllDeceased();
	}

	public List<Deceased> getAllDeceased() throws SQLException{
		allDeceased = new ArrayList<Deceased>();
		resultSet = statement.executeQuery("select * from deceased");
		while (resultSet.next()){
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String religion = resultSet.getString("religion");
			int graveId = resultSet.getInt("graveId");
			Date burialDate = resultSet.getDate("burialDate");
			Deceased d = new Deceased(id, firstName, lastName, religion, graveId, burialDate);
			allDeceased.add(d);
		}
       return allDeceased;
	}
	
	public void addDeceased(Deceased d) throws SQLException {
		if (getDeceasedById(d.getId()) == null
				&& isValid(d.getFirstName(), d.getLastName(), d.getReligion())) {
			preparedStatement = connect
					.prepareStatement("insert into deceased values (?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, d.getId());
			preparedStatement.setString(2, d.getFirstName());
			preparedStatement.setString(3, d.getLastName());
			preparedStatement.setString(4, d.getReligion());
			preparedStatement.setInt(5, d.getGrave());
			preparedStatement.setDate(6, (java.sql.Date) d.getBurialDate());
			preparedStatement.executeUpdate();
			allDeceased.add(d);
		}
	}
	
	public void updateDeceased(Deceased d) throws SQLException {
		if (getDeceasedById(d.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("update deceased set firstName = ?, lastName = ?, religion = ?, graveId = ?, burialDate = ? where id = ?");
			preparedStatement.setString(1, d.getFirstName());
			preparedStatement.setString(2, d.getLastName());
			preparedStatement.setString(3, d.getReligion());
			preparedStatement.setInt(4, d.getGrave());
			preparedStatement.setDate(5, (java.sql.Date) d.getBurialDate());
			preparedStatement.setInt(6, d.getId());
			preparedStatement.executeUpdate();

			for (Deceased deceased : allDeceased) {
				if (deceased.getId() == d.getId()) {
					deceased.setFirstName(d.getFirstName());
					deceased.setLastName(d.getLastName());
					deceased.setReligion(d.getReligion());
					deceased.setGrave(d.getGrave());
					deceased.setBurialDate(d.getBurialDate());
				}
			}
		}
	}

	public void deleteDeceased(Deceased d) throws SQLException {
		if (getDeceasedById(d.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("delete from deceased where id = ?");
			preparedStatement.setInt(1, d.getId());
			preparedStatement.executeUpdate();
			allDeceased.remove(d);
		}
	}

	public Deceased getDeceasedById(int id){
		for (Deceased d : allDeceased)
			if(d.getId() == id)
				return d;
		return null;
	}

	public List<Deceased> searchDeceased(String s){
		List<Deceased> searchResult = new ArrayList<Deceased>();
		for (Deceased d : allDeceased){
			String firstName = d.getFirstName();
			String lastName = d.getLastName();
			String religion = d.getReligion();
			String date = d.getBurialDate().toString();		
			if (firstName.contains(s) || lastName.contains(s) || religion.contains(s) || date.contains(s))
				searchResult.add(d);
		}
		return searchResult;
	}
	
	private boolean isValid(String firstName, String lastName, String religion) {
		if (firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+")  && religion.matches("[a-zA-z0-9.,]+")) {
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

