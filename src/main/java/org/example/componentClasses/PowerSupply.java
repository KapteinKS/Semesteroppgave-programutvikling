package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void writeObject(ObjectOutputStream s) throws IOException {
        //super.writeObject(s);
        s.writeUTF(getName());
        s.writeUTF(getManufacturer());
        s.writeDouble(getWattsRequired());
        s.writeDouble(getPrice());
        s.writeInt(inVoltage.getValue());
        s.writeInt(outVoltage.getValue());

    }

    public void readObject(ObjectInputStream s) throws IOException{
        //super.readObject(s);
        String name = s.readUTF();
        String manufacturer = s.readUTF();
        double wattsRequired = s.readDouble();
        double price = s.readDouble();
        int inVoltage = s.readInt();
        int outVoltage = s.readInt();

        setType("Keyboard");
        setName(name);
        setManufacturer(manufacturer);
        setWattsRequired(wattsRequired);
        setPrice(price);
        this.inVoltage = new SimpleIntegerProperty(inVoltage);
        this.outVoltage = new SimpleIntegerProperty(outVoltage);
    }

}