package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cemetery;
import Model.Complainer;
import Model.Data;
import Model.Deceased;
import Model.Grave;
import Model.Request;

import com.mysql.jdbc.Statement;

public class DataBase {
	// you work with these types as the dataType parameter in the methods
	// set the correct value for the type of object you're passing
	public static final int CEMETERY = 0;
	
	public static final int COMPLAINER = 1;
	
	public static final int CONTRACT = 2;
	
	public static final int DECEASED = 3;
	
	public static final int GRAVE = 4;
	
	public static final int OBSERVATION = 5;
	
	public static final int OWNER = 6;
	
	public static final int PARCEL = 7;
	
	public static final int REQUEST = 8;
	
	public static final int USER = 9;
	

	private Connection connect = null;
	
	private Statement statement = null;
	
	private PreparedStatement preparedStatement = null;
	
	private ResultSet resultSet = null;
	
	public static DataBase instance;
	
	public static DataBase getInstance(){
		if (instance == null){
			instance = new DataBase();
		}
		return instance;
	}
	public DataBase(){
		connectToDB();
	}

	private void connectToDB() {
		// this will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// setup the connection with the DB.
			connect = DriverManager
					.getConnection("jdbc:mysql://localhost/proiectcolectiv?"
							+ "user=root&password=root");
	
			// statements allow to issue SQL queries to the database
			statement = (Statement) connect.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addData(Data data){
		try {
			if (data instanceof Cemetery) {
				if (getDataById(((Cemetery) data).getId(), CEMETERY) == null
						&& ((Cemetery) data).isValid()) {
					preparedStatement = connect
							.prepareStatement("insert into  cemetery values (? , ?, ?)");
					preparedStatement.setInt(1, ((Cemetery) data).getId());
					preparedStatement.setString(2, ((Cemetery) data).getName());
					preparedStatement.setString(3, ((Cemetery) data).getAddress());
					
				}
			} else if (data instanceof Grave){
				if (getDataById(((Grave) data).getId(), GRAVE) == null) {
					preparedStatement = connect
							.prepareStatement("insert into  grave values (?, ?, ?, ?, ?)");
					preparedStatement.setInt(1, ((Grave) data).getId());
					preparedStatement.setInt(2, ((Grave) data).getParcelId());
					preparedStatement.setInt(3, ((Grave) data).getSurface());
					preparedStatement.setInt(4, ((Grave) data).getObservationId());
					preparedStatement.setString(5, ((Grave) data).getType());
					}
				
			} else if (data instanceof Request){
				if (getDataById(((Request) data).getId(), REQUEST) == null) {
					preparedStatement = connect
							.prepareStatement("insert into  request values (?, ?, ?, ?)");
					preparedStatement.setInt(1, ((Request) data).getId());
					preparedStatement.setDate(2, (Date) ((Request) data).getDate());
					preparedStatement.setInt(3, ((Request) data).getInfocet());
					preparedStatement.setBoolean(4, ((Request) data).isCompleted());
					}
			} else if (data instanceof Deceased){
				if (getDataById(((Deceased) data).getId(), DECEASED) == null) {
					preparedStatement = connect
							.prepareStatement("insert into deceased values (?, ?, ?, ?, ?, ?)");
					preparedStatement.setInt(1, ((Deceased) data).getId());
					preparedStatement.setString(2, ((Deceased) data).getFirstName());
					preparedStatement.setString(3, ((Deceased) data).getLastName());
					preparedStatement.setString(4, ((Deceased) data).getReligion());
					preparedStatement.setInt(5, ((Deceased) data).getGrave());
					preparedStatement.setDate(6, (Date) ((Deceased) data).getBurialDate());
			}
			
			
			// else if (){...} ... treating every data type the same way
			
			preparedStatement.executeUpdate();
			}
			} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public Data getDataById(int id, int dataType){
		Data data = null;
		try {
			switch (dataType) {
			case CEMETERY:
				resultSet = statement.executeQuery("select * from cemetery where id = "+id);
				while (resultSet.next()) {
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					data = new Cemetery(id, name, address);
				}
				break;
			case REQUEST:
				resultSet = statement.executeQuery("select * from request where id = "+id);
				while (resultSet.next()) {				
					Date date = resultSet.getDate("date");
					int infocet = resultSet.getInt("infocet");
					boolean completed = resultSet.getBoolean("completed");
					data = new Request(id, date, infocet, completed);
				}
				break;
			case DECEASED:
				resultSet = statement.executeQuery("select * from deceased where id = "+id);
				while (resultSet.next()){
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String religion = resultSet.getString("religion");
					int graveId = resultSet.getInt("graveId");
					Date burialDate = resultSet.getDate("burialDate");
					Deceased d = new Deceased(id, firstName, lastName, religion, graveId, burialDate);
				}
				break;
			case GRAVE:
				resultSet = statement.executeQuery("select * from grave where id = "+id);
				while (resultSet.next()) {				
					int graveId = resultSet.getInt("id");
					int parcelId = resultSet.getInt("parcelId");
					int surface = resultSet.getInt("surface");
					int observationId = resultSet.getInt("observationId");
					String type = resultSet.getString("type");
					data = new Grave(graveId, parcelId, surface, observationId, type);
				}
				break;
			//etc
	
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return data;
	}
	public ArrayList<Data> getAll(int dataType){
		ArrayList<Data> dataList = null;
		try {
			switch (dataType) {
			case CEMETERY:
				dataList = new ArrayList<Data>();
				resultSet = statement.executeQuery("select * from cemetery");
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					Cemetery newCemetery = new Cemetery(id, name, address);
					dataList.add(newCemetery);
				}
				break;
			case REQUEST:
				dataList = new ArrayList<Data>();
				resultSet = statement.executeQuery("select * from request");
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					Date date = resultSet.getDate("date");
					int infocet = resultSet.getInt("infocet");
					boolean completed = resultSet.getBoolean("completed");
					Request newRequest = new Request(id, date, infocet, completed);
					dataList.add(newRequest);
				}
				break;
			case DECEASED:
				dataList = new ArrayList<Data>();
				resultSet = statement.executeQuery("select * from deceased");
				while (resultSet.next()){
					int id = resultSet.getInt("id");
					String firstName = resultSet.getString("firstName");
					String lastName = resultSet.getString("lastName");
					String religion = resultSet.getString("religion");
					int graveId = resultSet.getInt("graveId");
					Date burialDate = resultSet.getDate("burialDate");
					Deceased newDeceased = new Deceased(id, firstName, lastName, religion, graveId, burialDate);
					dataList.add(newDeceased);
				}
				break;
			case GRAVE:
				dataList = new ArrayList<Data>();
				resultSet = statement.executeQuery("select * from grave");
				while (resultSet.next()) {
					int graveId = resultSet.getInt("id");
					int parcelId = resultSet.getInt("parcelId");
					int surface = resultSet.getInt("surface");
					int observationId = resultSet.getInt("observationId");
					String type = resultSet.getString("type");
					Grave newGrave = new Grave(graveId, parcelId, surface, observationId, type);
					dataList.add(newGrave);
				}
				break;
	
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dataList;
	}
	
	public void updateData(Data data){
		try {
			if (data instanceof Cemetery) {
				if (((Cemetery)data).isValid()) {
					preparedStatement = connect
							.prepareStatement("update cemetery set name = ?, address = ? where id = ?");
					preparedStatement.setString(1, ((Cemetery)data).getName());
					preparedStatement.setString(2, ((Cemetery)data).getAddress());
					preparedStatement.setInt(3, ((Cemetery)data).getId());
					preparedStatement.executeUpdate();

					for (Data cemetery : getAll(CEMETERY)) {
						if (((Cemetery)cemetery).getId() == ((Cemetery)data).getId()) {
							((Cemetery)cemetery).setName(((Cemetery)data).getName());
							((Cemetery)cemetery).setAddress(((Cemetery)data).getAddress());
						}
					}
				}
			} else if (data instanceof Request){
				if (((Request)data).isValid()){
					preparedStatement = connect
							.prepareStatement("update request set date = ?, infocet = ?, completed = ? where id = ?");
					preparedStatement.setDate(1, (Date) ((Request)data).getDate());
					preparedStatement.setInt(2, ((Request)data).getInfocet());
					preparedStatement.setBoolean(3, ((Request)data).isCompleted());
					preparedStatement.setInt(4, ((Request)data).getId());
					preparedStatement.executeUpdate();
					
					for (Data request : getAll(REQUEST)) {
						if (((Request)request).getId() == ((Request)data).getId()) {
							((Request)request).setDate(((Request)data).getDate());
							((Request)request).setInfocet(((Request)data).getInfocet());
							((Request)request).setCompleted(((Request)data).isCompleted());							
						}
					}
				}
			}else if (data instanceof Grave){
				if (((Grave)data).isValid()){
					preparedStatement = connect
							.prepareStatement("update grave set parcelId = ?, surface = ?, observationId = ?, type = ? where id = ?");
					preparedStatement.setInt(1, ((Grave)data).getId());
					preparedStatement.setInt(2, ((Grave)data).getParcelId());
					preparedStatement.setInt(3, ((Grave)data).getSurface());
					preparedStatement.setInt(4, ((Grave)data).getObservationId());
					preparedStatement.setString(5, ((Grave)data).getType());
					preparedStatement.executeUpdate();
					
					for (Data grave : getAll(GRAVE)) {
						if (((Grave)grave).getId() == ((Grave)data).getId()) {
							((Grave)grave).setParcelId(((Grave)data).getParcelId());
							((Grave)grave).setSurface(((Grave)data).getSurface());
							((Grave)grave).setObservationId(((Grave)data).getObservationId());
							((Grave)grave).setType(((Grave)data).getType());
						}
					}
				}				
			}else if (data instanceof Deceased){
				if (((Deceased)data).isValid()){
					preparedStatement = connect
							.prepareStatement("update deceased set firstName = ?, lastName = ?, religion = ?, graveId = ?, burialDate = ? where id = ?");
					preparedStatement.setString(1, ((Deceased)data).getFirstName());
					preparedStatement.setString(2, ((Deceased)data).getLastName());
					preparedStatement.setString(3, ((Deceased)data).getReligion());
					preparedStatement.setInt(4, ((Deceased)data).getGrave());
					preparedStatement.setDate(5, (Date) ((Deceased)data).getBurialDate());
					preparedStatement.setInt(6, ((Deceased)data).getId());
					preparedStatement.executeUpdate();
					
					for (Data deceased : getAll(DECEASED)) {
						if (((Deceased)deceased).getId() == ((Deceased)data).getId()) {
							((Deceased)deceased).setFirstName(((Deceased)data).getFirstName());
							((Deceased)deceased).setLastName(((Deceased)data).getLastName());
							((Deceased)deceased).setReligion(((Deceased)data).getReligion());
							((Deceased)deceased).setGrave(((Deceased)data).getGrave());
							((Deceased)deceased).setBurialDate(((Deceased)data).getBurialDate());
						}
					}
				}
			}// else if (){...} ... treating every data type the same way
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void deleteData(Data data){
		try {
			if (data instanceof Cemetery) {
				if (getDataById(((Cemetery)data).getId(), CEMETERY) != null) {
					preparedStatement = connect
							.prepareStatement("delete from cemetery where id = ?");
					preparedStatement.setInt(1, ((Cemetery)data).getId());
					preparedStatement.executeUpdate();
				}
			} else if (data instanceof Request){
				if (getDataById(((Request)data).getId(), REQUEST) != null) {
					preparedStatement = connect
							.prepareStatement("delete from request where id = ?");
					preparedStatement.setInt(1, ((Request)data).getId());
					preparedStatement.executeUpdate();
				}
			}
			else if (data instanceof Grave){
				if (getDataById(((Grave)data).getId(), GRAVE) != null) {
					preparedStatement = connect
							.prepareStatement("delete from grave where id = ?");
					preparedStatement.setInt(1, ((Grave)data).getId());
					preparedStatement.executeUpdate();
				}
				
			}else if (data instanceof Deceased){
				if (getDataById(((Deceased)data).getId(), DECEASED) != null){
					preparedStatement = connect
							.prepareStatement("delete from deceased where id = ?");
					preparedStatement.setInt(1, ((Deceased)data).getId());
					preparedStatement.executeUpdate();
				}
			}// else if (){...} ... treating every data type the same way
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
}
