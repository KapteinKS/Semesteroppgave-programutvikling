package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	public void writeObject(ObjectOutputStream s) throws IOException {
		s.writeUTF(getName());
		s.writeUTF(getManufacturer());
		s.writeDouble(getWattsRequired());
		s.writeDouble(getPrice());
		s.writeUTF(mbFormFactor.getValue());
		s.writeUTF(socket.getValue());
		s.writeUTF(ramType.getValue());
	}

	public void readObject(ObjectInputStream s) throws IOException{
		String name = s.readUTF();
		String manufacturer = s.readUTF();
		double wattsRequired = s.readDouble();
		double price = s.readDouble();
		String mbFormFactor = s.readUTF();
		String socket = s.readUTF();
		String ramType = s.readUTF();
		setType("Motherboard");
		setName(name);
		setManufacturer(manufacturer);
		setWattsRequired(wattsRequired);
		setPrice(price);
		this.mbFormFactor = new SimpleStringProperty(mbFormFactor);
		this.socket = new SimpleStringProperty(socket);
		this.ramType = new SimpleStringProperty(ramType);
	}
}
