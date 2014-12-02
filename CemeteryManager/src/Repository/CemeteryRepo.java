package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cemetery;
import Model.Data;

import com.mysql.jdbc.Statement;

public class CemeteryRepo {

	public CemeteryRepo() {
	}

	public ArrayList<Cemetery> getAllCemetery() {
		ArrayList<Cemetery> list = new ArrayList<Cemetery>();
		for (Data d : DataBase.getInstance().getAll(DataBase.CEMETERY)){
			list.add((Cemetery) d);
		}
		return list;
	}

	public void addCemetery(Cemetery g) {
		DataBase.getInstance().addData(g);
	}

	public void updateCemetery(Cemetery data) {
		DataBase.getInstance().updateData(data);
	}

	public void deleteCemetery(Cemetery data) {
		DataBase.getInstance().deleteData(data);
	}

	public Cemetery getCemeteryById(int id) {
		return (Cemetery)DataBase.getInstance().getDataById(id, DataBase.CEMETERY);
	}

	public List<Cemetery> searchCemetery(String s) {
		/*List<Cemetery> searchResult = new ArrayList<Cemetery>();
		for (Cemetery cemetery : allCemetery) {
			if (cemetery.getName().contains(s)
					|| cemetery.getAddress().contains(s)) {
				searchResult.add(cemetery);
			}
		}
		return searchResult;*/
		return null;
	}
}
