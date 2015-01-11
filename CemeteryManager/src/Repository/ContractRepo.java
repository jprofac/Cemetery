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
	public List<Contract> searchContract(String s){
		/*List<Contract> searchResult = new ArrayList<Contract>();
		for (Contract contract : allContract){
			String date = contract.getDate().toString();
			String period = Integer.toString(contract.getPeriod());
			String receipt = Integer.toString(contract.getReceipt());
			if (date.contains(s) || period.contains(s) || receipt.contains(s)) {
				searchResult.add(contract);
			}
			
		}
		return searchResult; */
		return null;}
}
