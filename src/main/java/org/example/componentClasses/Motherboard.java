package org.example.componentClasses;

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

	//  getInfo returns the non-universal attributes, formatted neatly
	public String getInfo(){
		return "Socket: " + getSocket() + "\nRamtype: " + getRamType() + "\nNødvendig energi: " + getWattsRequired() + " W";
	}

	//  setInfo does some input validation, further validated in other setters
	public boolean setInfo(String info){
		String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
		for (int i = 1; i < split.length; i++){
			if(split[i].indexOf(" ") > 0) {
				split[i] = split[i].substring(0, split[i].indexOf(" "));
			}
		}
		try {
			setSocket(split[1]);
			setRamType(split[2]);
			setWattsRequired(Double.parseDouble(split[3]));
		} catch (NumberFormatException n){
			return false;
		}
		return true;

	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeUTF(mbFormFactor.getValue());
		s.writeUTF(socket.getValue());
		s.writeUTF(ramType.getValue());
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		this.mbFormFactor = new SimpleStringProperty(s.readUTF());
		this.socket = new SimpleStringProperty(s.readUTF());
		this.ramType = new SimpleStringProperty(s.readUTF());
	}

	@Override
	public String toString(){
		return "Motherboard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
				+ "," + getMbFormFactor() + "," + getSocket() + "," + getRamType();
	}
}
