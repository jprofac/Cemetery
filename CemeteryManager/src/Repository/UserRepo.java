package Repository;

import java.util.ArrayList;
import java.util.List;

import Model.Data;
import Model.User;

public class UserRepo {
	public List<User> getAllUser(){ArrayList<User> list = new ArrayList<User>();
		for (Data d : DataBase.getInstance().getAll(DataBase.USER)){
			list.add((User) d);
		}
		return list;}
	public void addUser(User g){
		DataBase.getInstance().addData(g);
	}
	public void updateUser(User g){
		DataBase.getInstance().updateData(g);
	}
	public void deleteUser(User g){
		DataBase.getInstance().deleteData(g);
	}
	public User getUserById(int id){
		return (User)DataBase.getInstance().getDataById(id, DataBase.USER);
	}
	public List<User> searchUser(String s){ArrayList<User> searchResult = new ArrayList<User>();
		for (User user : getAllUser()) {
			if (user.getUsername().contains(s)) {
				searchResult.add(user);
			}
		}
		return searchResult;}
}
