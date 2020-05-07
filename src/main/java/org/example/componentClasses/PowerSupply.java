package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import java.io.Serializable;

public class PowerSupply extends Component implements Serializable {
    private transient SimpleIntegerProperty inVoltage;
    private transient SimpleIntegerProperty outVoltage;

    public PowerSupply(String name, String manufacturer, double wattsRequired, double price, int inVoltage, int outVoltage) {
        super("PowerSupply", name, manufacturer, wattsRequired, price);
        this.inVoltage = new SimpleIntegerProperty(inVoltage);
        this.outVoltage = new SimpleIntegerProperty(outVoltage);
    }

    public int getInVoltage() {
        return inVoltage.get();
    }

    public SimpleIntegerProperty inVoltageProperty() {
        return inVoltage;
    }

    public void setInVoltage(int inVoltage) {
        this.inVoltage.set(inVoltage);
    }

    public int getOutVoltage() {
        return outVoltage.get();
    }

    public SimpleIntegerProperty outVoltageProperty() {
        return outVoltage;
    }

    public void setOutVoltage(int outVoltage) {
        this.outVoltage.set(outVoltage);
    }


    public String getInfo() {
        return "Energiforbruk: " + getWattsRequired() + "W \nSpenning inn: " + getInVoltage() +
                "V \nSpenning ut: " + getOutVoltage() + "V";
    }

}