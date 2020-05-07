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
   /* public String getType() {
        return "PowerSupply";
    }

    public String getName(){
        return super.getName();
    }

    public double getPrice() {
        return super.getPrice();
    }

    public double getWattsRequired() {
        return super.getWattsRequired();
    }

    public String getManufacturer(){
        return super.getManufacturer();
    }

    */

    private void writeObject(ObjectOutputStream s) throws IOException {
        /*s.writeUTF(super.getName());
        s.writeUTF(super.getManufacturer());
        s.writeDouble(super.getWattsRequired());
        s.writeDouble(super.getPrice());*/
        s.defaultWriteObject();
        s.writeUTF(getType());
        s.writeInt(inVoltage.getValue());
        s.writeInt(outVoltage.getValue());

    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        super.type = new SimpleStringProperty(s.readUTF());
        this.inVoltage = new SimpleIntegerProperty(s.readInt());
        this.outVoltage = new SimpleIntegerProperty(s.readInt());
    }

}