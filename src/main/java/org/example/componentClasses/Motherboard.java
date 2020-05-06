package org.example.componentClasses;

import java.io.Serializable;

public class Motherboard extends Component implements Serializable {
	private String socket;
	private String ramType;
	private double wattsRequired;


	public Motherboard(String name, String manufacturer, double price, String socket, String ramType, double wattsRequired) {
		super(name, manufacturer, price, "Hovedkort");
		this.socket = socket;
		this.ramType = ramType;
		this.wattsRequired = wattsRequired;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public double getWattsRequired() {
		return wattsRequired;
	}

	public void setWattsRequired(double wattsRequired) {
		this.wattsRequired = wattsRequired;
	}

	public String getInfo(){
		return "Socket: " + getSocket() + "\nRamtype: " + getRamType() + "\nNødvendig energi: " + getWattsRequired() + "W";
	}
}
