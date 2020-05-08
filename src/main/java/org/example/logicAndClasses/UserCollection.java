package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class UserCollection {

	private ObservableList<User> users = FXCollections.observableArrayList();

	public List<User> getUsers(){
		return users;
	}
	public void addCustomer(User c){
		users.add(c);
	}
	public void removeAll(){
		users.clear();
	}
	public int getSize(){
		return users.size();
	}

	public boolean checkForUser(String email){
		boolean check = false;
		for (User c : users){
			if (c.getEmail().equals(email)){
				check = true;
				break;
			}
		}
		return check;
	}
	public boolean checkPassword(String email, String password){
		boolean check = false;
		for (User c : users){
			if (c.getEmail().equals(email)){
				if (c.getPassword().equals(password)) {
					check = true;
				}
				break;
			}
		}
		return check;
	}
	public User getUser(String email){
		for (User c : users){
			if (c.getEmail().equals(email)){
				return c;
			}
		}
		return null;
	}

	@Override
	public String toString(){
		String out = "";
		for (User c : users){
			out += c.toString();
		}
		return out;
	}
}
