package Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Data;
import Model.Request;

public class RequestRepo {
	
	public RequestRepo() {
	}

	public List<Request> getAllRequest() throws SQLException {
		ArrayList<Request> list = new ArrayList<Request>();
		for (Data d : DataBase.getInstance().getAll(DataBase.REQUEST)){
			list.add((Request) d);
		}
		return list;
	}

	public void addRequest(Request g) throws SQLException {
		DataBase.getInstance().addData(g);
	}

	public void updateRequest(Request g) throws SQLException {
		DataBase.getInstance().updateData(g);
	}

	public void deleteRequest(Request g) throws SQLException {
		DataBase.getInstance().deleteData(g);
	}

	public Request getRequestById(int id) {
		return (Request)DataBase.getInstance().getDataById(id, DataBase.REQUEST);
	}

	public List<Request> searchRequest(String s) {
		/*List<Request> searchResult = new ArrayList<Request>();
		for (Request request : allRequest) {
			String infocet = Integer.toString(request.getInfocet());
			String date = request.getDate().toString();
			if (date.contains(s) || infocet.contains(s)) {
				searchResult.add(request);
			}
		}*/
		return null;
	}
}
