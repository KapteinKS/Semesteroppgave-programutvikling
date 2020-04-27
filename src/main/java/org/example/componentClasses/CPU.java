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

import java.io.Serializable;

public class CPU extends Component implements Serializable {
	private SimpleIntegerProperty threads;
	private SimpleDoubleProperty clockSpeed;

	public CPU(String name, String manufacturer, double wattsRequired, double price, int threads, double clockSpeed){
		super(name,manufacturer,wattsRequired,price);
		this.threads = new SimpleIntegerProperty(threads);
		this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
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

	@Override
	public String toString(){
		return "CPU" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
				+ "," + getThreads() + "," + getClockSpeed();
	}
}