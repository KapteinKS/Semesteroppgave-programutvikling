package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class PowerSupply extends Component implements Serializable {

    public PowerSupply(String name, String manufacturer, double wattsRequired, double price) {
        super(name, manufacturer, wattsRequired, price);
    }

    @Override
    public String toString(){
        return "PowerSupply" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                ;
    }
}