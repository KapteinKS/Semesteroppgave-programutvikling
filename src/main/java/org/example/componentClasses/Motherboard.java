package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Motherboard extends Component implements Serializable {
	private transient SimpleStringProperty mbFormFactor;
	private transient SimpleStringProperty socket;
	private transient SimpleStringProperty ramType;

	public Motherboard(String name, String manufacturer, double wattsRequired, double price, String mbFormFactor, String socket, String ramType) {
		super("Motherboard", name, manufacturer,wattsRequired, price);
		this.mbFormFactor = new SimpleStringProperty(mbFormFactor);
		this.socket = new SimpleStringProperty(socket);
		this.ramType = new SimpleStringProperty(ramType);
	}

	public String getMbFormFactor() {
		return mbFormFactor.get();
	}

	public SimpleStringProperty mbFormFactorProperty() {
		return mbFormFactor;
	}

	public void setMbFormFactor(String mbFormFactor) {
		this.mbFormFactor.set(mbFormFactor);
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

	public String getInfo(){
		return "Socket: " + getSocket() + "\nRamtype: " + getRamType() + "\nNødvendig energi: " + getWattsRequired() + "W";
	}
}
