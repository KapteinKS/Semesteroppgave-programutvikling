package org.example.Deeper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
	@Override
	public String toString(){
		//THIS MUST RETURN CSV!!
		return "Hei! Dette er CustomerCollection sin toString! =) Dette må egentlig være en samling av CSVdata";
	}
}
