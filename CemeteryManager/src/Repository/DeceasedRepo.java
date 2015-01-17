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
import Model.User;

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
		DataBase.getInstance().updateData(d);
	}

	public void deleteDeceased(Deceased d){
		DataBase.getInstance().deleteData(d);
	}

	public Deceased getDeceasedById(int id){
		return (Deceased)DataBase.getInstance().getDataById(id, DataBase.DECEASED);
	}
	
	public Deceased getDeceasedByGrave(int id){
		return (Deceased)DataBase.getInstance().getDeceasedById(id);
	}


	public List<Deceased> getDeceasedByYear(int year) {
		ArrayList<Deceased> list = new ArrayList<Deceased>();
		for (Data d : DataBase.getInstance().getDeceasedByYear(year)){
			list.add((Deceased) d);
			}
			return list;
		}
	public ArrayList<Deceased> searchDeceased(String s){ArrayList<Deceased> searchResult = new ArrayList<Deceased>();
	for (Deceased deceased : getAllDeceased()) {
		if (deceased.getLastName().contains(s)) {
			searchResult.add(deceased);
		}
	}
	return searchResult;}
	
}

