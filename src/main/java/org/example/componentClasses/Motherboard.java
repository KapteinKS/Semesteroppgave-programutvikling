package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Motherboard extends Component implements Serializable {
	private SimpleStringProperty socket;
	private SimpleStringProperty ramType;

	public Motherboard() {}

	public Motherboard(String name, String manufacturer, double wattsRequired, double price, String socket, String ramType) {
		super(name, manufacturer,wattsRequired, price);
		this.socket = new SimpleStringProperty(socket);
		this.ramType = new SimpleStringProperty(ramType);
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

	@Override
	public String toString(){
		return "Motherboard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
				+ "," + getSocket() + "," + getRamType() + "," + getWattsRequired();
	}

}
