package org.example.components;

public class Motherboard extends Component {
	private String[] ports;
	private double wattsRequired;

	public Motherboard() {}

	public Motherboard(String name, String manufacturer, double price, String[] ports, double wattsRequired) {
		super(name, manufacturer, price);
		this.ports = ports;
		this.wattsRequired = wattsRequired;
	}

	public String[] getPorts() {
		return ports;
	}

	public void setPorts(String[] ports) {
		this.ports = ports;
	}

	public double getWattsRequired() {
		return wattsRequired;
	}

	public void setWattsRequired(double wattsRequired) {
		this.wattsRequired = wattsRequired;
	}
}
