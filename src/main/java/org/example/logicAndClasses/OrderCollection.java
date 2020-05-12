package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
//  Collection class for orders
public class OrderCollection{
	private ObservableList<Order> orders = FXCollections.observableArrayList();

	public void addOrder(Order o){
		orders.add(o);
	}

	public void removeAll(){
		orders.clear();
	}

	public int size(){
		return orders.size();
	}
	//  Method to print all orders from a specific given customer
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
	//  toString returns .csv with one order per line
	@Override
	public String toString(){
		String out = "";
		for (Order o : orders){
			out += o.toString() + "\n";
		}
		return out;
	}
}
