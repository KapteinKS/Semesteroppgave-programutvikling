package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalRefreshRateException;
import org.example.exceptions.IllegalResponseTimeException;
import org.example.exceptions.IllegalScreenSizeException;

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

    public void setMonitorSize(double monitorSize) throws IllegalScreenSizeException {
        if (monitorSize >= 13) {
            this.monitorSize.set(monitorSize);
        } else {
            throw new IllegalScreenSizeException("Kunne ikke sette skjermstørrelse");
        }
    }

    public int getMonitorRefreshRate() {
        return monitorRefreshRate.getValue();
    }

    public void setMonitorRefreshRate(int monitorRefreshRate) throws IllegalRefreshRateException {
        if (monitorRefreshRate >= 16) {
            this.monitorRefreshRate.set(monitorRefreshRate);
        } else {
            throw new IllegalRefreshRateException("Kunne ikke sette responstid");
        }
    }

    public int getMonitorResponseTime() {
        return monitorResponseTime.getValue();
    }

    public void setMonitorResponseTime(int monitorResponseTime) throws IllegalResponseTimeException{
        if (monitorResponseTime > 0 && monitorResponseTime <= 50) {
            this.monitorResponseTime.set(monitorResponseTime);
        } else {
            throw new IllegalResponseTimeException("Kunne ikke sette responstid");
        }
    }

    public String getMonitorScreenType() {
        return monitorScreenType.getValue();
    }

    public void setMonitorScreenType(String monitorScreenType) {
        this.monitorScreenType.set(monitorScreenType);
    }

    public String getInfo(){
        return "Size: " + getMonitorSize() + " \" \nRefresh Rate: " + getMonitorRefreshRate() + " Hz\nResponstid: "
                + getMonitorResponseTime() + " ms\nSkjermtype: " + getMonitorScreenType();
    }

    public boolean setInfo(String info) throws IOException {
        String [] split = info.split("[A-ZÆØÅ][a-zæøå `\"]{1,20}: ");

        for (int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }
        }
        try {
            setMonitorSize(Double.parseDouble(split[1]));
            setMonitorRefreshRate(Integer.parseInt(split[2]));
            setMonitorResponseTime(Integer.parseInt(split[3]));
            setMonitorScreenType(split[4]);
        } catch (NumberFormatException | IllegalScreenSizeException n){
            throw new IOException(n.getMessage());
        }

        return true;

    }

    @Override
    public String toString() {
        return "Monitor" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMonitorSize() + "," + getMonitorRefreshRate() + "," + getMonitorResponseTime() + "," + getMonitorScreenType();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeDouble(monitorSize.getValue());
        s.writeInt(monitorRefreshRate.getValue());
        s.writeInt(monitorResponseTime.getValue());
        s.writeUTF(monitorScreenType.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.monitorSize = new SimpleDoubleProperty(s.readDouble());
        this.monitorRefreshRate = new SimpleIntegerProperty(s.readInt());
        this.monitorResponseTime = new SimpleIntegerProperty(s.readInt());
        this.monitorScreenType = new SimpleStringProperty(s.readUTF());
    }
}
