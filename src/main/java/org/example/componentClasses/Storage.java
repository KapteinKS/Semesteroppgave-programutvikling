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

    public void setStoragetype(String storagetype) {
        this.storageType.set(storagetype);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public String getCapacityType() {
        return capacityType.get();
    }

    public void setCapacityType(String capacityType) {
        this.capacityType.set(capacityType);
    }

    public String getInfo(){
        return "Lagringstype: " + getStoragetype() + "\nKapasitet: " + getCapacity() + getCapacityType();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(storageType.getValue());
        s.writeInt(capacity.getValue());
        s.writeUTF(capacityType.getValue());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.storageType = new SimpleStringProperty(s.readUTF());
        this.capacity = new SimpleIntegerProperty(s.readInt());
        this.capacityType = new SimpleStringProperty(s.readUTF());
    }
}