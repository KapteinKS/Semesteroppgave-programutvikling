package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Monitor extends Component implements Serializable {
    private transient SimpleDoubleProperty monitorSize; //in inches
    private transient SimpleIntegerProperty monitorRefreshRate; //in Hz
    private transient SimpleIntegerProperty monitorResponseTime; //in ms
    private transient SimpleStringProperty monitorScreenType; // ex. LED, OLED, LCD


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

    public void setMonitorSize(int monitorSize) {
        this.monitorSize.set(monitorSize);
    }

    public int getMonitorRefreshRate() {
        return monitorRefreshRate.getValue();
    }

    public void setMonitorRefreshRate(int monitorRefreshRate) {
        this.monitorRefreshRate.set(monitorRefreshRate);
    }

    public int getMonitorResponseTime() {
        return monitorResponseTime.getValue();
    }

    public void setMonitorResponseTime(int monitorResponseTime) {
        this.monitorResponseTime.set(monitorResponseTime);
    }

    public String getMonitorScreenType() {
        return monitorScreenType.getValue();
    }

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

    public void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeDouble(monitorSize.getValue());
        s.writeInt(monitorRefreshRate.getValue());
        s.writeInt(monitorResponseTime.getValue());
        s.writeUTF(monitorScreenType.getValue());
    }

    public void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.monitorSize = new SimpleDoubleProperty(s.readDouble());
        this.monitorRefreshRate = new SimpleIntegerProperty(s.readInt());
        this.monitorResponseTime = new SimpleIntegerProperty(s.readInt());
        this.monitorScreenType = new SimpleStringProperty(s.readUTF());
    }
}
