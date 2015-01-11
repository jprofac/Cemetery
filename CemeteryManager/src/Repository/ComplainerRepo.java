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
import Model.Person;
import Model.Owner;

import com.mysql.jdbc.Statement;

import Model.Complainer;

public class ComplainerRepo {
	
	public ComplainerRepo(){
	}
	
	public List<Complainer> getAllComplainer(){
		ArrayList<Complainer> list = new ArrayList<Complainer>();
		for (Data d : DataBase.getInstance().getAll(DataBase.COMPLAINER)){
			list.add((Complainer) d);
		}
		return list;
	}
	public void addComplainer(Complainer g){
		DataBase.getInstance().addData(g);
	}
	public void updateComplainer(Complainer g){
		DataBase.getInstance().updateData(g);
	}
	public void deleteComplainer(Complainer g){
		DataBase.getInstance().deleteData(g);
	}
	public Complainer getComplainerById(int id){
		return (Complainer)DataBase.getInstance().getDataById(id, DataBase.COMPLAINER);
	}
	public List<Complainer> searchComplainer(String s){
		/*List<Complainer> searchResult = new ArrayList<Complainer>();
		for (Complainer complainer : allComplainer){
			String firstName = complainer.getFirstName();
			String lastName = complainer.getLastName();
			String reason = complainer.getReason();
			if (firstName.contains(s) || lastName.contains(s) || reason.contains(s)) {
				searchResult.add(complainer);
			}
		}
		return searchResult; */
		return null;
	}
}
