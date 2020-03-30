package org.example.components;

public class PowerSupply extends Component {
    private int energy; //WATT, feel free to refactor -> rename
    private int inVoltage;
    private int outVoltage;

    public PowerSupply(String name, String manufacturer, double price, int energy, int inVoltage, int outVoltage) {
        super(name, manufacturer, price);
        this.energy = energy;
        this.inVoltage = inVoltage;
        this.outVoltage = outVoltage;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getInVoltage() {
        return inVoltage;
    }

    public void setInVoltage(int inVoltage) {
        this.inVoltage = inVoltage;
    }

    public int getOutVoltage() {
        return outVoltage;
    }

    public void setOutVoltage(int outVoltage) {
        this.outVoltage = outVoltage;
    }
}