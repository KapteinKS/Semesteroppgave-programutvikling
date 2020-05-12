package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalClockSpeedException;
import org.example.exceptions.IllegalThreadsException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	public void setThreads(int threads) throws IllegalThreadsException {
		if(threads > 0) {
			this.threads.set(threads);
		} else {
			throw new IllegalThreadsException("Kunne ikke sette tråder");
		}
	}

	public double getClockSpeed() {
		return clockSpeed.getValue();
	}

	public void setClockSpeed(double clockSpeed) throws IllegalClockSpeedException {
		if (clockSpeed >=1 && clockSpeed <= 10) {
			this.clockSpeed.set(clockSpeed);
		} else {
			throw new IllegalClockSpeedException("Kunne ikke sette klokkehastighet");
		}
	}

	public String getSocket() {
		return socket.get();
	}

	public void setSocket(String socket) {
		this.socket.set(socket);
	}

	public String getInfo(){
		return "Tråder: " + getThreads() + "\nKlokkehastighet: " + getClockSpeed() + "\nSocket: " + getSocket();
	}

	public boolean setInfo(String info) throws IOException {
		String [] split = info.split("[A-ZÆØÅ][a-zæøå]{1,20}: ");
		try {
			setThreads(Integer.parseInt(split[1]));
			setClockSpeed(Double.parseDouble(split[2]));
			setSocket(split[3]);
		} catch (NumberFormatException | IllegalThreadsException | IllegalClockSpeedException n){
			throw new IOException(n.getMessage());
		}
		return true;
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

	@Override
	public String toString(){
		return "CPU" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
				+ "," + getThreads() + "," + getClockSpeed() + "," + getSocket();
	}
}
