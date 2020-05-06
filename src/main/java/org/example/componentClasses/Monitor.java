package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Monitor extends Component implements Serializable {
    private SimpleIntegerProperty monitorSize; //in inches
    private SimpleIntegerProperty monitorRefreshRate; //in Hz
    private SimpleIntegerProperty monitorResponseTime; //in ms
    private SimpleIntegerProperty monitorScreenType; // ex. LED, OLED, LCD


    public Monitor(String type, String name, String manufacturer, double wattsRequired, double price, SimpleIntegerProperty monitorSize, SimpleIntegerProperty monitorRefreshRate, SimpleIntegerProperty monitorResponseTime, SimpleIntegerProperty monitorScreenType) {
        super(type, name, manufacturer, wattsRequired, price);
        this.monitorSize = monitorSize;
        this.monitorRefreshRate = monitorRefreshRate;
        this.monitorResponseTime = monitorResponseTime;
        this.monitorScreenType = monitorScreenType;
    }

    public int getMonitorSize() {
        return monitorSize.get();
    }

    public SimpleIntegerProperty monitorSizeProperty() {
        return monitorSize;
    }

    public void setMonitorSize(int monitorSize) {
        this.monitorSize.set(monitorSize);
    }

    public int getMonitorRefreshRate() {
        return monitorRefreshRate.get();
    }

    public SimpleIntegerProperty monitorRefreshRateProperty() {
        return monitorRefreshRate;
    }

    public void setMonitorRefreshRate(int monitorRefreshRate) {
        this.monitorRefreshRate.set(monitorRefreshRate);
    }

    public int getMonitorResponseTime() {
        return monitorResponseTime.get();
    }

    public SimpleIntegerProperty monitorResponseTimeProperty() {
        return monitorResponseTime;
    }

    public void setMonitorResponseTime(int monitorResponseTime) {
        this.monitorResponseTime.set(monitorResponseTime);
    }

    public int getMonitorScreenType() {
        return monitorScreenType.get();
    }

    public SimpleIntegerProperty monitorScreenTypeProperty() {
        return monitorScreenType;
    }

    public void setMonitorScreenType(int monitorScreenType) {
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
