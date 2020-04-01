package org.example.components;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private SimpleStringProperty type;
    private SimpleStringProperty capacity;

    public Storage(String name, String manufacturer, double price, String type, String capacity) {
        super(name, manufacturer, price);
        this.type = new SimpleStringProperty(type);
        this.capacity = new SimpleStringProperty(capacity);
    }

    public String getType() {
        return type.getValue();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getCapacity() {
        return capacity.getValue();
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

    @Override
    public String toString(){
        return "Storage" + "," + getName() + "," + getManufacturer() + "," + getPrice()
                + "," + getType() + "," + getCapacity();
    }

}