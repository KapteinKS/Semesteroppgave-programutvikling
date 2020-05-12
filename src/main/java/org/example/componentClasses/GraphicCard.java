package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalClockSpeedException;
import org.example.exceptions.IllegalRAMException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GraphicCard extends Component implements Serializable {
    private transient SimpleIntegerProperty ram;
    private transient SimpleStringProperty ramType;
    private transient SimpleDoubleProperty clockSpeed;

    public GraphicCard(String name, String manufacturer, double wattsRequired, double price, int ram, String ramType, double clockSpeed) {
        super("GraphicCard",name, manufacturer, wattsRequired, price);
        this.ram = new SimpleIntegerProperty(ram);
        this.ramType = new SimpleStringProperty(ramType);
        this.clockSpeed = new SimpleDoubleProperty(clockSpeed);
    }

    public int getRam() {
        return ram.getValue();
    }

    public void setRam(int ram) throws IllegalRAMException {
        if (ram >= 1) {
            this.ram.set(ram);
        } else {
            throw new IllegalRAMException("Kunne ikke sette RAM");
        }
    }

    public String getRamType() {
        return ramType.getValue();
    }

    public void setRamType(String ramType) {
        this.ramType.set(ramType);
    }

    public double getClockSpeed() {
        return clockSpeed.getValue();
    }

    public void setClockSpeed(double clockSpeed) throws IllegalClockSpeedException {
        if(clockSpeed >= 1) {
            this.clockSpeed.set(clockSpeed);
        } else {
            throw new IllegalClockSpeedException("Kunne ikke sette klokkehastighet");
        }
    }

    public String getInfo(){
        return "RAM: " + getRam() + " GB \nRamtype: " + getRamType() + " \nKlokkehastighet: " + getClockSpeed() + " MHz";
    }

    public boolean setInfo(String info) throws IOException {
        String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
        for (int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }
        }
        try {
            setRam(Integer.parseInt(split[1]));
            setRamType(split[2]);
            setClockSpeed(Double.parseDouble(split[3]));
        } catch (NumberFormatException | IllegalRAMException | IllegalClockSpeedException n){
            throw new IOException(n.getMessage());
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(ram.getValue());
        s.writeUTF(ramType.getValue());
        s.writeDouble(clockSpeed.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.ram = new SimpleIntegerProperty(s.readInt());
        this.ramType = new SimpleStringProperty(s.readUTF());
        this.clockSpeed = new SimpleDoubleProperty(s.readDouble());
    }

    @Override
    public String toString(){
        return "GraphicCard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getRam() + "," + getRamType() + "," + getClockSpeed();
    }
}
