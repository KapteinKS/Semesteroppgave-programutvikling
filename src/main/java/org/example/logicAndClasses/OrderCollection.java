package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class OrderCollection{

	private ObservableList<Order> orders = FXCollections.observableArrayList();

	public List<Order> getOrders(){
		return orders;
	}
	public void addOrder(Order o){
		orders.add(o);
	}
	public void removeAll(){
		orders.clear();
	}
	public int size(){
		return orders.size();
	}

	public String printOrders(String customerID) {
		String out = "Ordrene til kunde " + customerID + "\n";
		String theOrders = "";

		for (Order o : orders) {
			if (o.getUserID().equals(customerID)) {
				theOrders += o.printOrder() + "\n";
			}
		}
		if (theOrders.equals("")) {
			out = "";
		} else {
			out += theOrders;
		}
		return out;
	}

	@Override
	public String toString(){
		String out = "";
		for (Order o : orders){
			out += o.toString() + "\n";
		}
		return  out; // Does this work? I do not know.
	}
}
