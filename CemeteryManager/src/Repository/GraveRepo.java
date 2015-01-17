package Repository;

import java.util.List;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cemetery;
import Model.Data;
import Model.Grave;
import Model.Request;

import com.mysql.jdbc.Statement;

public class GraveRepo {
	
	public GraveRepo() {
	}

	public ArrayList<Grave> getAllGrave(){
		ArrayList<Grave> list = new ArrayList<Grave>();
		for (Data d : DataBase.getInstance().getAll(DataBase.GRAVE)){
			list.add((Grave) d);
		}
		return list;
	}

	public void addGrave(Grave g){
		DataBase.getInstance().addData(g);
	}

	public void updateGrave(Grave g){
		DataBase.getInstance().updateData(g);
	}

	public void deleteGrave(Grave g){
		System.out.println(g.getId());
		DataBase.getInstance().deleteData(g);
	}

	public Grave getGraveById(int id) {
		return (Grave)DataBase.getInstance().getDataById(id, DataBase.GRAVE);
	}

	public List<Grave> getExpiring(int year) {
		ArrayList<Grave> list = new ArrayList<Grave>();
		for (Data d : DataBase.getInstance().getExpiringGraves(year)){
			list.add((Grave) d);
		}
		return list;
	}
	
	public List<Grave> getPaid() {
		ArrayList<Grave> list = new ArrayList<Grave>();
		for (Data d : DataBase.getInstance().getPaidGraves()){
			list.add((Grave) d);
		}
		return list;
	}
}
