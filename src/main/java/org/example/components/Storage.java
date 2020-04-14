package org.example.components;

import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private String type;
    private int capacity;
    private String capacityType;

    public Storage(String name, String manufacturer, double price, String type, int capacity, String capacityType) {
        super(name, manufacturer, price);
        this.type = type;
        this.capacity = capacity;
        this.capacityType = capacityType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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