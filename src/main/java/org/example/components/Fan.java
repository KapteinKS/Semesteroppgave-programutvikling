package org.example.components;

public class Fan extends Component {
    private int diameter;
    private double airPressure;
    private int maxNoiseVolume;

    public Fan(String name, String manufacturer, double price, int diameter, double airPressure, int maxNoiseVolume) {
        super(name, manufacturer, price);
        this.diameter = diameter;
        this.airPressure = airPressure;
        this.maxNoiseVolume = maxNoiseVolume;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(double airPressure) {
        this.airPressure = airPressure;
    }

    public int getMaxNoiseVolume() {
        return maxNoiseVolume;
    }

    public void setMaxNoiseVolume(int maxNoiceVolume) {
        this.maxNoiseVolume = maxNoiceVolume;
    }
}