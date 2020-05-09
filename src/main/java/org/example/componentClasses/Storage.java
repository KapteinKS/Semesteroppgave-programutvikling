package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

    public void setCapacity(double capacity) {
        this.capacity.set(capacity);
    }

    public String getCapacityType() {
        return capacityType.get();
    }

    public void setCapacityType(String capacityType) {
        this.capacityType.set(capacityType);
    }

    public String getInfo(){
        return "Minnetype: " + getStoragetype() + " \nKapasitet: " + getCapacity() + " " + getCapacityType();
    }
    @Override
    public String toString(){
        return "Storage" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getStoragetype() + "," + getCapacity() + "," + getCapacityType();
    }


    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
        try {
            setStoragetype(split[1]);
            setCapacity(Double.parseDouble(split[2].substring(0, split[2].indexOf(" "))));
            setCapacityType(split[2].substring(split[2].indexOf(" ")));
        } catch (NumberFormatException n){
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
}