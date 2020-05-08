package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Component implements Serializable {
	private transient SimpleStringProperty type;
	private transient SimpleStringProperty name;
	private transient SimpleStringProperty manufacturer;
	private transient SimpleDoubleProperty wattsRequired;
	private transient SimpleDoubleProperty price;

	public Component(){
	}

	public Component(String type, String name, String manufacturer, double wattsRequired, double price){
		this.type = new SimpleStringProperty(type);
		this.name = new SimpleStringProperty(name);
		this.manufacturer = new SimpleStringProperty(manufacturer);
		this.wattsRequired = new SimpleDoubleProperty(wattsRequired);
		this.price = new SimpleDoubleProperty(price);
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public String getType() {
		return type.get();
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

	public void setWattsRequired(double wattsRequired) {
		this.wattsRequired.set(wattsRequired);
	}

	public String getManufacturer(){
		return manufacturer.getValue();
	}

	public void setManufacturer(String manufacturer){
		this.manufacturer.set(manufacturer);
	}

	//Method to 'print-display' the component (used, for instance, when populating comboBoxes in user GUI)
	public String displayComponent(){
		return this.getManufacturer() + " " + this.getName() + ", " + this.getPrice() + " NOK";
	}
	public String getInfo(){
		return "";
	}


	private void writeObject(ObjectOutputStream s) throws IOException{
		s.writeUTF(type.getValue());
		s.writeUTF(name.getValue());
		s.writeUTF(manufacturer.getValue());
		s.writeDouble(wattsRequired.getValue());
		s.writeDouble(price.getValue());
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		this.type = new SimpleStringProperty(s.readUTF());
		this.name = new SimpleStringProperty(s.readUTF());
		this.manufacturer = new SimpleStringProperty(s.readUTF());
		this.wattsRequired = new SimpleDoubleProperty(s.readDouble());
		this.price = new SimpleDoubleProperty(s.readDouble());
	}
}
