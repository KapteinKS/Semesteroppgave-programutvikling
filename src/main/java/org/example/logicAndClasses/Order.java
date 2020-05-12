package org.example.logicAndClasses;

import javafx.collections.ObservableList;
import org.example.componentClasses.Component;
import java.util.ArrayList;

public class Order {
	private String userID;
	private String orderID;
	private String date;
	private ArrayList<String> componentsOrdered;
	private double price;

	public Order(String userID, String orderID, String date, ArrayList<String>componentsOrdered, double price){
		this.userID = userID;
		this.orderID = orderID;
		this.date = date;
		this.componentsOrdered = componentsOrdered;
		this.price = price;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<String> getComponentsOrdered() {
		return componentsOrdered;
	}

	public void setComponentsOrdered(ObservableList<Component> componentsOrdered) {
		for (Component cmpnt : componentsOrdered) {
			this.componentsOrdered.add(cmpnt.displayComponent());
		}
	}

	public void setComponentsOrdered(ArrayList<String> componentsOrdered){
		this.componentsOrdered = componentsOrdered;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//  Method to display an order neatly
	public String printOrder(){
		String out = "OrderID: " + orderID
				+ "\n" + "Dato: " + date
				+ "\n" + "Komponenter bestilt:" + "\n";
		for (String cmpnnt : componentsOrdered){
			out += cmpnnt + "\n";
		}
		out += "Pris: " + price + "\n----------------------\n";
		return out;
	}
	//  toString() formats as .csv
	@Override
	public String toString(){
		String out = "" + userID + "," + orderID + "," + date + ",";
		for (String cmpnnt : componentsOrdered){
			out += cmpnnt + ",";
		}
		out += price + ",";
		return out;
	}
}
