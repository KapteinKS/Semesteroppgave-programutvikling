package org.example.components;

/*

Component classes should have attributes, from which, compatibility can be gauged.
Say the user chooses an AMD motherboard, and we have in our "store", an Intel i5 CPU
the i5 should then be grayed out for the user, as it's incompatible.
This should be done with a checker-method (SEE CHECKER.java)
}

 */


import java.io.Serializable;

public class CPU extends Component implements Serializable {
	private int threads;
	private double clockSpeed;

	public CPU(String name, String manufacturer, double price, int threads, double clockSpeed){
		super(name,manufacturer,price);
		this.threads = threads;
		this.clockSpeed = clockSpeed;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public double getClockSpeed() {
		return clockSpeed;
	}

	public void setClockSpeed(double clockSpeed) {
		this.clockSpeed = clockSpeed;
	}

	@Override
	public String toString(){
		return "CPU" + "," + getName() + "," + getManufacturer() + "," + getPrice()
				+ "," + getThreads() + "," + getClockSpeed();
	}
}
