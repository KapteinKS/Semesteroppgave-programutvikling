package org.example.componentClasses;

import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private int capacity;
    private String capacityType;

    public Storage(String name, String manufacturer, double price, String type, int capacity, String capacityType) {
        super("Storage",name, manufacturer, 0, price);
        this.capacity = capacity;
        this.capacityType = capacityType;
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
}