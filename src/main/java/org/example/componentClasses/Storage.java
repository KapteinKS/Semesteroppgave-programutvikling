package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalCapacityException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private transient SimpleStringProperty storageType;
    private transient SimpleDoubleProperty capacity;
    private transient SimpleStringProperty capacityType;

    public Storage(String name, String manufacturer, double price, String storageType, double capacity, String capacityType) {
        super("Storage", name, manufacturer, 0, price);
        this.storageType = new SimpleStringProperty(storageType);
        this.capacity = new SimpleDoubleProperty(capacity);
        this.capacityType = new SimpleStringProperty(capacityType);
    }

    public String getStoragetype() {
        return storageType.get();
    }

    public void setStoragetype(String storagetype) {
        this.storageType.set(storagetype);
    }

    public double getCapacity() {
        return capacity.get();
    }

    public void setCapacity(double capacity) throws IllegalCapacityException {
        if(capacity > 1 && capacity < 2048) {
            this.capacity.set(capacity);
        }else{
            throw new IllegalCapacityException("Ugyldig lagrinsplass!");
        }
    }

    public String getCapacityType() {
        return capacityType.get();
    }

    public void setCapacityType(String capacityType) {
        this.capacityType.set(capacityType);
    }

    //  getInfo returns the non-universal attributes, formatted neatly
    public String getInfo(){
        return "Minnetype: " + getStoragetype() + " \nKapasitet: " + getCapacity() + " " + getCapacityType();
    }

    //  setInfo does some input validation, further validated in other setters
    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
        try {
            setStoragetype(split[1]);
            setCapacity(Double.parseDouble(split[2].substring(0, split[2].indexOf(" "))));
            setCapacityType(split[2].substring(split[2].indexOf(" ")));
        } catch (NumberFormatException | IllegalCapacityException n){
            return false;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(storageType.getValue());
        s.writeDouble(capacity.getValue());
        s.writeUTF(capacityType.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.storageType = new SimpleStringProperty(s.readUTF());
        this.capacity = new SimpleDoubleProperty(s.readDouble());
        this.capacityType = new SimpleStringProperty(s.readUTF());
    }

    @Override
    public String toString(){
        return "Storage" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getStoragetype() + "," + getCapacity() + "," + getCapacityType();
    }
}