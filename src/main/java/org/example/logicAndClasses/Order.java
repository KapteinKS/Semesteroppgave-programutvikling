package org.example.logicAndClasses;

import java.util.ArrayList;

public class Order {
	private String userID;
	private String orderID;
	private String date;
	private ArrayList<String> componentsOrdered;
	private double fullPrice;

	public Order(String userID, String orderID, String date, ArrayList<String>componentsOrdered, double fullPrice){
		this.userID = userID;
		this.orderID = orderID;
		this.date = date;
		this.componentsOrdered = componentsOrdered;
		this.fullPrice = fullPrice;
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

	public void setComponentsOrdered(ArrayList<String> componentsOrdered){
		this.componentsOrdered = componentsOrdered;
	}

	public double getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}
	//  Method to display an order neatly
	public String printOrder(){
		String out = "OrderID: " + orderID
				+ "\n" + "Dato: " + date
				+ "\n" + "Komponenter bestilt:" + "\n";
		for (int i = 0; i < componentsOrdered.size() - 1; i++){
			out += componentsOrdered.get(i)+ "\n";
		}
		out += "\nTotal Pris: " + fullPrice + "\n----------------------\n";
		return out;
	}
	//  toString() formats as .csv
	@Override
	public String toString(){
		String out = "" + userID + "," + orderID + "," + date + ",";
		for (String cmpnnt : componentsOrdered){
			out += cmpnnt + ",";
		}
		out += fullPrice + ",";
		return out;
	}
}
