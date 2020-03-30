package org.example.components;

public class Component {
	private String name;
	private String manufacturer;
	private double price;

	public Component(){}

	public Component(String name, String manufacturer, double price){
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public String getManufacturer(){
		return manufacturer;
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
}
