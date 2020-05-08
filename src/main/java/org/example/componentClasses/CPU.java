package org.example.componentClasses;

/*

Component classes should have attributes, from which, compatibility can be gauged.
Say the user chooses an AMD motherboard, and we have in our "store", an Intel i5 CPU
the i5 should then be grayed out for the user, as it's incompatible.
This should be done with a checker-method (SEE CHECKER.java)
}

 */


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CPU extends Component {
	private transient SimpleIntegerProperty threads;
	private transient SimpleDoubleProperty clockSpeed;
	private transient SimpleStringProperty socket;

	public CPU(String name, String manufacturer, double wattsRequired, double price, int threads, double clockSpeed, String socket){
		super("CPU",name,manufacturer,wattsRequired,price);
		this.threads = new SimpleIntegerProperty(threads);
		this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
		this.socket = new SimpleStringProperty(socket);
	}

	public int getThreads() {
		return threads.getValue();
	}

	public void setThreads(int threads) {
		this.threads.set(threads);
	}

	public double getClockSpeed() {
		return clockSpeed.getValue();
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed.set(clockSpeed);
	}

	public String getSocket() {
		return socket.get();
	}

	public void setSocket(String socket) {
		this.socket.set(socket);
	}

	public String getInfo(){
		return "Tråder: " + getThreads() + "\nKlokkehastighet: " + getClockSpeed();
	}

	@Override
	public String toString(){
		return "CPU" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
				+ "," + getThreads() + "," + getClockSpeed() + "," + getSocket();
	}

	private void writeObject(ObjectOutputStream s) throws IOException{
		s.defaultWriteObject();
		s.writeInt(threads.getValue());
		s.writeDouble(clockSpeed.getValue());
		s.writeUTF(socket.getValue());
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		this.threads = new SimpleIntegerProperty(s.readInt());
		this.clockSpeed = new SimpleDoubleProperty(s.readDouble());
		this.socket = new SimpleStringProperty(s.readUTF());
	}
}
