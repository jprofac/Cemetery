package Repository;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.*;

import com.mysql.jdbc.Statement;

import Model.Observation;

public class ObservationRepo {
	public ObservationRepo(){
	}
	public List<Observation> getAllObservation(){
		ArrayList<Observation> list = new ArrayList<Observation>();
		for (Data d : DataBase.getInstance().getAll(DataBase.OBSERVATION)){
			list.add((Observation) d);	
		}
		return list;
	}
	public void addObservation(Observation g){
		DataBase.getInstance().addData(g);
	}
	public void updateObservation(Observation g){
		DataBase.getInstance().updateData(g);
	}
	public void deleteObservation(Observation g){
		DataBase.getInstance().deleteData(g);
	}
	public Observation getObservationById(int id){
		return (Observation)DataBase.getInstance().getDataById(id, DataBase.OBSERVATION);
	}
	public List<Observation> searchObservation(String s){
		/* List<Observation> searchResult = new ArrayList<Observation>();
		for (Observation observation : searchResult){
			String modificationNr = Integer.toString(observation.getModificationNr());
			String photography = observation.getPhotography();
			if (modificationNr.contains(s) || photography.contains(s)) {
				searchResult.add(observation);
			}
		return searchResult; */
		return null;
	}
}
