package org.example.components;

import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private String Storagetype;
    private int capacity;
    private String capacityType;

    public Storage(String name, String manufacturer, double price, String Storagetype, int capacity, String capacityType) {
        super(name, manufacturer, price, "Lagring");
        this.Storagetype = Storagetype;
        this.capacity = capacity;
        this.capacityType = capacityType;
    }

    public String getStoragetype() {
        return Storagetype;
    }

    public void setStoragetype(String storagetype) {
        this.Storagetype = storagetype;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }

    public String getInfo(){
        return "Lagringstype: " + getStoragetype() + "\nKapasitet: " + getCapacity() + getCapacityType();
    }
}