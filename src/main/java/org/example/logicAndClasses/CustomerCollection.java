package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CustomerCollection {

	private ObservableList<Customer> customers = FXCollections.observableArrayList();

	public List<Customer> getCustomers(){
		return customers;
	}
	public void addCustomer(Customer c){
		customers.add(c);
	}
	public void removeAll(){
		customers.clear();
	}
	public int getSize(){
		return customers.size();
	}

	public boolean checkForCustomer(String email){
		boolean check = false;
		for (Customer c : customers){
			if (c.getEmail().equals(email)){
				check = true;
				break;
			}
		}
		return check;
	}
	public boolean checkPassword(String email, String password){
		boolean check = false;
		for (Customer c : customers){
			if (c.getEmail().equals(email)){
				if (c.getPassword().equals(password)) {
					check = true;
				}
				break;
			}
		}
		return check;
	}

	@Override
	public String toString(){
		String out = "";
		for (Customer c : customers){
			out += c.toString();
		}
		return out;
	}
}
