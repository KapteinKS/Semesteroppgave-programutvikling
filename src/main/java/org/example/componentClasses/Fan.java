package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalDimensionsException;
import org.example.exceptions.IllegalNoiseException;
import org.example.exceptions.IllegalPressureException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Spliterator;

public class Fan extends Component implements Serializable {
    private transient SimpleIntegerProperty diameter;
    private transient SimpleDoubleProperty airPressure;
    private transient SimpleIntegerProperty maxNoiseVolume;

    public Fan(String name, String manufacturer, double price, int diameter, double airPressure, int maxNoiseVolume) {
        super("Fan", name, manufacturer, 0, price);
        this.diameter = new SimpleIntegerProperty(diameter);
        this.airPressure = new SimpleDoubleProperty(airPressure);
        this.maxNoiseVolume = new SimpleIntegerProperty(maxNoiseVolume);
    }

    public int getDiameter() {
        return diameter.getValue();
    }

    public void setDiameter(int diameter) throws IllegalDimensionsException {
        if (diameter >= 5 && diameter <= 40) {
            this.diameter.set(diameter);
        } else {
            throw new IllegalDimensionsException("Kunne ikke sette viftediameter");
        }
    }

    public double getAirPressure() {
        return airPressure.getValue();
    }

    public void setAirPressure(double airPressure) throws IllegalPressureException {
        if (airPressure > 0 && airPressure <= 10) {
            this.airPressure.set(airPressure);
        } else {
            throw new IllegalPressureException("Kunne ikke sette lufttrykk");
        }
    }

    public int getMaxNoiseVolume() {
        return maxNoiseVolume.getValue();
    }

    public void setMaxNoiseVolume(int maxNoiceVolume) throws IllegalNoiseException {
        if (maxNoiceVolume < 100) {
            this.maxNoiseVolume.setValue(maxNoiceVolume);
        } else {
            throw new IllegalNoiseException("Kunne ikke sette støyvolum");
        }
    }

    public String getInfo(){
        return "Diameter: " + getDiameter() + " mm \nLufttrykk: " + getAirPressure() +
                " mm \nHøyeste støyvolum: " + getMaxNoiseVolume() + " dBA";
    }

    public boolean setInfo(String info) throws IOException {
        String [] split = info.split("[A-ZÆØÅ][a-zæøå]{1,20}: ");

        for (int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }        }
        try {
            setDiameter(Integer.parseInt(split[1]));
            setAirPressure(Double.parseDouble(split[2]));
            setMaxNoiseVolume(Integer.parseInt(split[3]));
        } catch (NumberFormatException | IllegalDimensionsException | IllegalPressureException | IllegalNoiseException n){
            throw new IOException(n.getMessage());
        }
        return true;
    }

    @Override
    public String toString(){
        return "Fan" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getDiameter() + "," + getAirPressure() + "," + getMaxNoiseVolume();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(diameter.getValue());
        s.writeDouble(airPressure.getValue());
        s.writeInt(maxNoiseVolume.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.diameter = new SimpleIntegerProperty(s.readInt());
        this.airPressure = new SimpleDoubleProperty(s.readDouble());
        this.maxNoiseVolume = new SimpleIntegerProperty(s.readInt());
    }
}
