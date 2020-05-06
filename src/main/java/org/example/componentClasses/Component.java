package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Component implements Serializable {
	private transient SimpleStringProperty name;
	private transient SimpleStringProperty manufacturer;
	private transient SimpleDoubleProperty price;
	private String type;

	public Component(String name, String manufacturer, double price, String type){
		this.name = new SimpleStringProperty(name);
		this.manufacturer = new SimpleStringProperty(manufacturer);
		this.price = new SimpleDoubleProperty(price);
		this.type = type;
	}

	public String getName(){
		return name.getValue();
	}

	public void setName(String name){
		this.name.set(name);
	}

	public double getPrice() {
		return price.getValue();
	}

	public void setPrice(double price){
		this.price.set(price);
	}

	public String getManufacturer(){
		return manufacturer.getValue();
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer.set(manufacturer);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo(){
		return "";
	}
}
