package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Fan extends Component implements Serializable {
    private SimpleIntegerProperty diameter;
    private SimpleDoubleProperty airPressure;
    private SimpleIntegerProperty maxNoiseVolume;

    public Fan(String name, String manufacturer, double price, int diameter, double airPressure, int maxNoiseVolume) {
        super("Fan", name, manufacturer, 0, price);
        this.diameter = new SimpleIntegerProperty(diameter);
        this.airPressure = new SimpleDoubleProperty(airPressure);
        this.maxNoiseVolume = new SimpleIntegerProperty(maxNoiseVolume);
    }

    public int getDiameter() {
        return diameter.getValue();
    }

    public void setDiameter(int diameter) {
        this.diameter.set(diameter);
    }

    public double getAirPressure() {
        return airPressure.getValue();
    }

    public void setAirPressure(double airPressure) {
        this.airPressure.set(airPressure);
    }

    public int getMaxNoiseVolume() {
        return maxNoiseVolume.getValue();
    }

    public void setMaxNoiseVolume(int maxNoiceVolume) {
        this.maxNoiseVolume.setValue(maxNoiceVolume);
    }

    public String getInfo(){
        return "Diameter: " + getDiameter() + "cm \nLufttrykk: " + getAirPressure() +
                "mm \nHøyeste støyvolum" + getMaxNoiseVolume() + "dBA";
    }

    @Override
    public String toString(){
        return "Fan" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getDiameter() + "," + getAirPressure() + "," + getMaxNoiseVolume();
    }
}
