package org.example.components;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Motherboard extends Component implements Serializable {
	private SimpleStringProperty socket;
	private SimpleStringProperty ramType;
	private SimpleDoubleProperty wattsRequired;

	public Motherboard() {}

	public Motherboard(String name, String manufacturer, double price, String socket, String ramType, double wattsRequired) {
		super(name, manufacturer, price);
		this.socket = new SimpleStringProperty(socket);
		this.ramType = new SimpleStringProperty(ramType);
		this.wattsRequired = new SimpleDoubleProperty(wattsRequired);
	}

	public String getSocket() {
		return socket.getValue();
	}

	public void setSocket(String socket) {
		this.socket.set(socket);
	}

	public String getRamType() {
		return ramType.getValue();
	}

	public void setRamType(String ramType) {
		this.ramType.set(ramType);
	}

	public double getWattsRequired() {
		return wattsRequired.getValue();
	}

	public void setWattsRequired(double wattsRequired) {
		this.wattsRequired.set(wattsRequired);
	}

	@Override
	public String toString(){
		return "Motherboard" + "," + getName() + "," + getManufacturer() + "," + getPrice()
				+ "," + getSocket() + "," + getRamType() + "," + getWattsRequired();
	}

}
