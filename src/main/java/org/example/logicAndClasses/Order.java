package org.example.logicAndClasses;

public class Order {
	private String customerID;
	private String orderID;
	private String[] componentsOrdered;
	private double price;

	public Order(String customerID, String orderID, String[]componentsOrdered, double price){
		this.customerID = customerID;
		this.orderID = orderID;
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

	public String[] getComponentsOrdered() {
		return componentsOrdered;
	}

	public void setComponentsOrdered(String[] componentsOrdered) {
		this.componentsOrdered = componentsOrdered;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString(){
		String out = "" +  customerID + ",";
		for (String cmpnnt : componentsOrdered){
			out += cmpnnt + ",";
		}
		out += price + ",";
		return out;
	}
}
