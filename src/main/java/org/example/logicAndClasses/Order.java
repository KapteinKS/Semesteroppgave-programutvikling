package org.example.logicAndClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.componentClasses.Component;

import java.util.Date;

public class Order {
	private String customerID;
	private String orderID;
	private Date date;
	ObservableList<Component> componentsOrdered;
	private double price;

	public Order(String customerID, String orderID, Date date, ObservableList<Component>componentsOrdered, double price){
		this.customerID = customerID;
		this.orderID = orderID;
		this.date = date;
		this.componentsOrdered = componentsOrdered;
		this.price = price;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ObservableList<Component> getComponentsOrdered() {
		return componentsOrdered;
	}

	public void setComponentsOrdered(ObservableList<Component> componentsOrdered) {
		this.componentsOrdered = componentsOrdered;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

		//This prints the specific order
	public String printOrder(){
		String out = "OrderID: " + orderID
				+ "\n" + "Dato: " + date
				+ "\n" + "Komponenter bestilt:" + "\n";
		for (Component cmpnnt : componentsOrdered){
			out += cmpnnt + "\n";
		}
		out += "Pris: " + price;
		return out;
	}

	@Override
	public String toString(){
		String out = "" +  customerID + "," + orderID + "," + date + ",";
		for (Component cmpnnt : componentsOrdered){
			out += cmpnnt + ",";
		}
		out += price + ",";
		return out;
	}
}
