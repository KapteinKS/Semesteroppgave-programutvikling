package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
        import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private transient SimpleStringProperty storageType;
    private transient SimpleIntegerProperty capacity;
    private transient SimpleStringProperty capacityType;

    public Storage(String name, String manufacturer, double price, String Storagetype, int capacity, String capacityType) {
        super("Storage", name, manufacturer, 0, price);
        this.storageType = new SimpleStringProperty(Storagetype);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.capacityType = new SimpleStringProperty(capacityType);
    }

    public String getStoragetype() {
        return storageType.get();
    }

    public SimpleStringProperty storagetypeProperty() {
        return storageType;
    }

    public void setStoragetype(String storagetype) {
        this.storageType.set(storagetype);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public SimpleIntegerProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public String getCapacityType() {
        return capacityType.get();
    }

    public SimpleStringProperty capacityTypeProperty() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType.set(capacityType);
    }

    public String getInfo(){
        return "Lagringstype: " + getStoragetype() + "\nKapasitet: " + getCapacity() + getCapacityType();
    }

    public void writeObject(ObjectOutputStream s) throws IOException {
        //super.writeObject(s);
        s.writeUTF(getName());
        s.writeUTF(getManufacturer());
        s.writeDouble(getWattsRequired());
        s.writeDouble(getPrice());
        s.writeUTF(storageType.getValue());
        s.writeInt(capacity.getValue());
        s.writeUTF(capacityType.getValue());

    }

    public void readObject(ObjectInputStream s) throws IOException{
        //super.readObject(s);
        String name = s.readUTF();
        String manufacturer = s.readUTF();
        double wattsRequired = s.readDouble();
        double price = s.readDouble();
        String storageType = s.readUTF();
        int capacity = s.readInt();
        String capacityType = s.readUTF();

        setType("Keyboard");
        setName(name);
        setManufacturer(manufacturer);
        setWattsRequired(wattsRequired);
        setPrice(price);
        this.storageType = new SimpleStringProperty(storageType);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.capacityType = new SimpleStringProperty(capacityType);
    }
}