package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Parcel;
import Model.Data;

import com.mysql.jdbc.Statement;

public class ParcelRepo {

	public ParcelRepo() {
	}

	public ArrayList<Parcel> getAllParcel() {
		ArrayList<Parcel> list = new ArrayList<Parcel>();
		for (Data d : DataBase.getInstance().getAll(DataBase.PARCEL)){
			list.add((Parcel) d);
		}
		return list;
	}

	public void addParcel(Parcel g) {
		DataBase.getInstance().addData(g);
	}

	public void updateParcel(Parcel data) {
		DataBase.getInstance().updateData(data);
	}

	public void deleteParcel(Parcel data) {
		DataBase.getInstance().deleteData(data);
	}

	public Parcel getParcelById(int id) {
		return (Parcel)DataBase.getInstance().getDataById(id, DataBase.PARCEL);
	}

	public List<Parcel> searchParcel(String s) {
		/*List<Parcel> searchResult = new ArrayList<Parcel>();
		for (Parcel Parcel : allParcel) {
			if (Parcel.getName().contains(s)
					|| Parcel.getAddress().contains(s)) {
				searchResult.add(Parcel);
			}
		}
		return searchResult;*/
		return null;
	}
}
