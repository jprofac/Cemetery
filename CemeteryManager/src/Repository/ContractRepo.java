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
import Model.Grave;

import com.mysql.jdbc.Statement;

import Model.Contract;

public class ContractRepo {
	public ContractRepo(){
	}
	
	public List<Contract> getAllContract(){
		ArrayList<Contract> list = new ArrayList<Contract>();
		for (Data d : DataBase.getInstance().getAll(DataBase.CONTRACT)){
			list.add((Contract) d);
		}
		return list;
	}
	public void addContract(Contract g){
		DataBase.getInstance().addData(g);
	}
	public void updateContract(Contract g){
		DataBase.getInstance().updateData(g);
	}
	public void deleteContract(Contract g){
		DataBase.getInstance().deleteData(g);
	}
	public Contract getContractById(int id){
		return (Contract)DataBase.getInstance().getDataById(id, DataBase.CONTRACT);
	}
	
	public List<Contract> getContractsByYear(int year){
		ArrayList<Contract> list = new ArrayList<Contract>();
		for (Data d : DataBase.getInstance().getContractsByYear(year)){
			list.add((Contract) d);
		}
		return list;}
	
	public Contract getContractByGrave(int grave){
		return (Contract)DataBase.getInstance().getContractByGrave(grave);
	}
}
