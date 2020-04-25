package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Component implements Serializable {
	private SimpleStringProperty name;
	private SimpleStringProperty manufacturer;
	private SimpleDoubleProperty wattsRequired;
	private SimpleDoubleProperty price;

	public Component(){}

	public Component(String name, String manufacturer, double wattsRequired, double price){
		this.name = new SimpleStringProperty(name);
		this.manufacturer = new SimpleStringProperty(manufacturer);
		this.wattsRequired = new SimpleDoubleProperty(wattsRequired);
		this.price = new SimpleDoubleProperty(price);
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

	public double getWattsRequired() {
		return wattsRequired.get();
	}

	public SimpleDoubleProperty wattsRequiredProperty() {
		return wattsRequired;
	}

	public void setWattsRequired(double wattsRequired) {
		this.wattsRequired.set(wattsRequired);
	}

	public String getManufacturer(){
		return manufacturer.getValue();
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer.set(manufacturer);
	}
}
