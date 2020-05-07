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
/*
	public String getType() {
		return "Motherboard";
	}

	public String getName(){
		return super.getName();
	}

	public double getPrice() {
		return super.getPrice();
	}

	public double getWattsRequired() {
		return super.getWattsRequired();
	}

	public String getManufacturer(){
		return super.getManufacturer();
	}

 */

	private void writeObject(ObjectOutputStream s) throws IOException {
		/*s.writeUTF(super.getName());
		s.writeUTF(super.getManufacturer());
		s.writeDouble(super.getWattsRequired());
		s.writeDouble(super.getPrice());*/
		s.defaultWriteObject();
		s.writeUTF(getType());
		s.writeUTF(mbFormFactor.getValue());
		s.writeUTF(socket.getValue());
		s.writeUTF(ramType.getValue());
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		super.type = new SimpleStringProperty(s.readUTF());
		this.mbFormFactor = new SimpleStringProperty(s.readUTF());
		this.socket = new SimpleStringProperty(s.readUTF());
		this.ramType = new SimpleStringProperty(s.readUTF());
	}
}
