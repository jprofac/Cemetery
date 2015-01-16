package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import Model.Deceased;
import Model.Owner;
import Model.Person;

public class OwnerRepo {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private List<Owner> allOwner = null;

	public OwnerRepo() throws ClassNotFoundException, SQLException {
		connectToDB();
		getAllOwner();
		
	}
	
	public List<Owner> getAllOwner() throws SQLException{
		allOwner = new ArrayList<Owner>();
		resultSet = statement.executeQuery("select * from owner");
		while (resultSet.next()){
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String domicile = resultSet.getString("domicile");
			Owner o = new Owner(id, firstName, lastName, domicile);
			allOwner.add(o);
		}
       return allOwner;
	}

	public void addOwner(Owner o) throws SQLException {
		if (getOwnerById(o.getId()) == null
				&& isValid(o.getFirstName(), o.getLastName())) {
			preparedStatement = connect
					.prepareStatement("insert into owner values (?, ?, ?, ?)");
			preparedStatement.setInt(1, o.getId());
			preparedStatement.setString(2, o.getFirstName());
			preparedStatement.setString(3, o.getLastName());
			preparedStatement.setString(4, o.getDomicile());
			preparedStatement.executeUpdate();
			allOwner.add(o);
		}
	
	}
	public void updateOwner(Owner o) throws SQLException {
		if (getOwnerById(o.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("update owner set firstName = ?, lastName = ?, domicile = ? where id = ?");
			preparedStatement.setString(1, o.getFirstName());
			preparedStatement.setString(2, o.getLastName());
			preparedStatement.setString(3, o.getDomicile());
			preparedStatement.setInt(4, o.getId());
			preparedStatement.executeUpdate();

			for (Owner owner : allOwner) {
				if (owner.getId() == o.getId()) {
					owner.setFirstName(o.getFirstName());
					owner.setLastName(o.getLastName());
					owner.setDomicile(o.getDomicile());
				}
			}
		}
	}

	public void deletOwner(Owner o) throws SQLException {
		if (getOwnerById(o.getId()) != null) {
			preparedStatement = connect
					.prepareStatement("delete from owner where id = ?");
			preparedStatement.setInt(1, o.getId());
			preparedStatement.executeUpdate();
			allOwner.remove(o);
		}
	}

	public Owner getOwnerById(int id){
		for (Owner o : allOwner)
			if (o.getId() == id)
				return o;
		return null;
	}

	public List<Owner> searchOwner(String s){
		List<Owner> searchResult = new ArrayList<Owner>();
		for (Owner o : allOwner){
			String firstName = o.getFirstName();
			String lastName = o.getLastName();
			String domicile = o.getDomicile();
			if (firstName.contains(s) || lastName.contains(s) || domicile.contains(s))
				searchResult.add(o);
		}
		return searchResult;
	}

	private boolean isValid(String firstName, String lastName) {
		if (firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+") ) {
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
