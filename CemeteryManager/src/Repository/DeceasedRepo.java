package Repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Cemetery;
import Model.Data;
import Model.Deceased;
import Model.Owner;
import Model.Request;

import com.mysql.jdbc.Statement;

public class DeceasedRepo {
	public DeceasedRepo(){
		
	}

	public ArrayList<Deceased> getAllDeceased() {
		ArrayList<Deceased> list = new ArrayList<Deceased>();
		for (Data d : DataBase.getInstance().getAll(DataBase.DECEASED)){
			list.add((Deceased) d);
		}
		return list;
	}
	
	public void addDeceased(Deceased d){
		DataBase.getInstance().addData(d);
	}
	
	public void updateDeceased(Deceased d){
		DataBase.getInstance().updateData(data);
	}

	public void deleteDeceased(Deceased d){
		DataBase.getInstance().deleteData(data);
	}

	public Deceased getDeceasedById(int id){
		return (Deceased)DataBase.getInstance().getDataById(id, DataBase.DECEASED);
	}

	public List<Deceased> searchDeceased(String s){
		/*List<Deceased> searchResult = new ArrayList<Deceased>();
		for (Deceased d : allDeceased){
			String firstName = d.getFirstName();
			String lastName = d.getLastName();
			String religion = d.getReligion();
			String date = d.getBurialDate().toString();		
			if (firstName.contains(s) || lastName.contains(s) || religion.contains(s) || date.contains(s))
				searchResult.add(d);
		}
		return searchResult; */
		return null;
	}
	
}

