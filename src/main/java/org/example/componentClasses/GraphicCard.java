package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class GraphicCard extends Component implements Serializable {
    private transient SimpleIntegerProperty ram;
    private transient SimpleStringProperty ramType;
    private transient SimpleIntegerProperty clockSpeed;

    public GraphicCard(String name, String manufacturer, double wattsRequired, double price, int ram, String ramType, int clockSpeed) {
        super("GraphicCard",name, manufacturer, wattsRequired, price);
        this.ram = new SimpleIntegerProperty(ram);
        this.ramType = new SimpleStringProperty(ramType);
        this.clockSpeed = new SimpleIntegerProperty(clockSpeed);
    }

    public int getRam() {
        return ram.getValue();
    }

    public void setRam(int ram) {
        this.ram.set(ram);
    }

    public String getRamType() {
        return ramType.getValue();
    }

    public void setRamType(String ramType) {
        this.ramType.set(ramType);
    }

    public int getClockSpeed() {
        return clockSpeed.getValue();
    }

    public void setClockSpeed(int clockSpeed) {
        this.clockSpeed.set(clockSpeed);
    }

    public String getInfo(){
        return "RAM: " + getRam() + "GB \nRamtype: " + getRamType() + "\nKlokkehastighet: " + getClockSpeed() + "MHz";
    }

    @Override
    public String toString(){
        return "GraphicCard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getRam() + "," + getRamType() + "," + getClockSpeed();
    }
}
