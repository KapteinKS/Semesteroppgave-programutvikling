package org.example.components;

import java.io.Serializable;

public class GraphicCard extends Component implements Serializable {
    private int ram;
    private String ramType;
    private String clockSpeed;

    public GraphicCard(String name, String manufacturer, double price, int ram, String ramType, String clockSpeed) {
        super(name, manufacturer, price, "Grafikkort");
        this.ram = ram;
        this.ramType = ramType;
        this.clockSpeed = clockSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public String getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(String clockSpeed) {
        this.clockSpeed = clockSpeed;
    }
}
