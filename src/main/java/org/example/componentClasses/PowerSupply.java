package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class PowerSupply extends Component implements Serializable {
    private SimpleIntegerProperty inVoltage;
    private SimpleIntegerProperty outVoltage;

    public PowerSupply(String name, String manufacturer, double wattsRequired, double price, int energy, int inVoltage, int outVoltage) {
        super(name, manufacturer, wattsRequired, price);
        this.inVoltage = new SimpleIntegerProperty(inVoltage);
        this.outVoltage = new SimpleIntegerProperty(outVoltage);
    }

    public int getInVoltage() {
        return inVoltage.getValue();
    }

    public void setInVoltage(int inVoltage) {
        this.inVoltage.set(inVoltage);
    }

    public int getOutVoltage() {
        return outVoltage.getValue();
    }

    public void setOutVoltage(int outVoltage) {
        this.outVoltage.set(outVoltage);
    }

    @Override
    public String toString(){
        return "PowerSupply" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getInVoltage() + "," + getOutVoltage();
    }
}