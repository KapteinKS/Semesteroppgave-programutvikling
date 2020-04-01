package org.example.components;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class PowerSupply extends Component implements Serializable {
    private SimpleIntegerProperty energy; //WATT, feel free to refactor -> rename
    private SimpleIntegerProperty inVoltage;
    private SimpleIntegerProperty outVoltage;

    public PowerSupply(String name, String manufacturer, double price, int energy, int inVoltage, int outVoltage) {
        super(name, manufacturer, price);
        this.energy = new SimpleIntegerProperty(energy);
        this.inVoltage = new SimpleIntegerProperty(inVoltage);
        this.outVoltage = new SimpleIntegerProperty(outVoltage);
    }

    public int getEnergy() {
        return energy.getValue();
    }

    public void setEnergy(int energy) {
        this.energy.set(energy);
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
        return "PowerSupply" + "," + getName() + "," + getManufacturer() + "," + getPrice()
                + "," + getEnergy() + "," + getInVoltage() + "," + getOutVoltage();
    }
}