package org.example.components;

public class Cooling extends Component {
    private int diameter;
    private double airPressure;
    private int maxNoiceVolume;

    public Cooling(String name, String manufacturer, double price, int diameter, double airPressure, int maxNoiceVolume) {
        super(name, manufacturer, price);
        this.diameter = diameter;
        this.airPressure = airPressure;
        this.maxNoiceVolume = maxNoiceVolume;
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

    public int getMaxNoiceVolume() {
        return maxNoiceVolume;
    }

    public void setMaxNoiceVolume(int maxNoiceVolume) {
        this.maxNoiceVolume = maxNoiceVolume;
    }
}
