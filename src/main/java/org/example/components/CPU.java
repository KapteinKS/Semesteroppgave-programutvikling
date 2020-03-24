package org.example.components;

public class CPU extends Component{
	private int threads;
	private double clockSpeed;

	public CPU(){}

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
}
