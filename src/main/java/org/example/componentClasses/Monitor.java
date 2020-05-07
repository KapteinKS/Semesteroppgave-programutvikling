package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Monitor extends Component implements Serializable {
    private SimpleDoubleProperty monitorSize; //in inches
    private SimpleIntegerProperty monitorRefreshRate; //in Hz
    private SimpleIntegerProperty monitorResponseTime; //in ms
    private SimpleStringProperty monitorScreenType; // ex. LED, OLED, LCD


    public Monitor(String name, String manufacturer, double wattsRequired, double price, double monitorSize, int monitorRefreshRate, int monitorResponseTime, String monitorScreenType) {
        super("Monitor", name, manufacturer, wattsRequired, price);
        this.monitorSize = new SimpleDoubleProperty(monitorSize);
        this.monitorRefreshRate = new SimpleIntegerProperty(monitorRefreshRate);
        this.monitorResponseTime = new SimpleIntegerProperty(monitorResponseTime);
        this.monitorScreenType = new SimpleStringProperty(monitorScreenType);
    }

    public double getMonitorSize() {
        return monitorSize.getValue();
    }

    /*
    public SimpleIntegerProperty monitorSizeProperty() {
        return monitorSize;
    }
    */

    public void setMonitorSize(int monitorSize) {
        this.monitorSize.set(monitorSize);
    }

    public int getMonitorRefreshRate() {
        return monitorRefreshRate.getValue();
    }
    /*
    public SimpleIntegerProperty monitorRefreshRateProperty() {
        return monitorRefreshRate;
    }
    */

    public void setMonitorRefreshRate(int monitorRefreshRate) {
        this.monitorRefreshRate.set(monitorRefreshRate);
    }

    public int getMonitorResponseTime() {
        return monitorResponseTime.getValue();
    }
    /*
    public SimpleIntegerProperty monitorResponseTimeProperty() {
        return monitorResponseTime;
    }
    */

    public void setMonitorResponseTime(int monitorResponseTime) {
        this.monitorResponseTime.set(monitorResponseTime);
    }

    public String getMonitorScreenType() {
        return monitorScreenType.getValue();
    }
    /*
    public SimpleIntegerProperty monitorScreenTypeProperty() {
        return monitorScreenType;
    }
    */

    public void setMonitorScreenType(String monitorScreenType) {
        this.monitorScreenType.set(monitorScreenType);
    }

    public String getInfo(){
        return "Size: " + getMonitorSize() + " Inches \nRefresh Rate: " + getMonitorRefreshRate() + " Hz\nResponstid: "
                + getMonitorResponseTime() + "ms\nSkjermtype: " + getMonitorScreenType();
    }

    @Override
    public String toString() {
        return "Monitor" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMonitorSize() + "," + getMonitorRefreshRate() + "," + getMonitorResponseTime() + "," + getMonitorScreenType();
    }
}
