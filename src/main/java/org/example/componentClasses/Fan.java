package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

    public void writeObject(ObjectOutputStream s) throws IOException {
        //super.writeObject(s);
        s.writeUTF(getName());
        s.writeUTF(getManufacturer());
        s.writeDouble(getWattsRequired());
        s.writeDouble(getPrice());
        s.writeInt(diameter.getValue());
        s.writeDouble(airPressure.getValue());
        s.writeInt(maxNoiseVolume.getValue());
    }

    public void readObject(ObjectInputStream s) throws IOException{
        //super.readObject(s);
        String name = s.readUTF();
        String manufacturer = s.readUTF();
        double wattsRequired = s.readDouble();
        double price = s.readDouble();
        int diameter = s.readInt();
        double airPressure = s.readDouble();
        int maxNoiseVolume = s.readInt();

        setType("Fan");
        setName(name);
        setManufacturer(manufacturer);
        setWattsRequired(wattsRequired);
        setPrice(price);
        this.diameter = new SimpleIntegerProperty(diameter);
        this.airPressure = new SimpleDoubleProperty(airPressure);
        this.maxNoiseVolume = new SimpleIntegerProperty(maxNoiseVolume);
    }
}
