package org.example.components;

import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private String type;
    private String capacity;

    public Storage(String name, String manufacturer, double price, String type, String capacity) {
        super(name, manufacturer, price);
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
}