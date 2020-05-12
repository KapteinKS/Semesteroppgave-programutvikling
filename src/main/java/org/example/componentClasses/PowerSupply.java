package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import org.example.exceptions.IllegalVoltageException;

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

    public void setInVoltage(int inVoltage) throws IllegalVoltageException{
        if(inVoltage > 120 && inVoltage < 250) {
            this.inVoltage.set(inVoltage);
        }else{
            throw new IllegalVoltageException("Ugyldig verdi!");
        }
    }

    public int getOutVoltage() {
        return outVoltage.get();
    }

    public void setOutVoltage(int outVoltage) throws IllegalVoltageException{
        if(outVoltage > 10 && outVoltage < 15) {
            this.outVoltage.set(outVoltage);
        }else{
            throw new IllegalVoltageException("Ugyldig verdi!");
        }
    }

    public String getInfo() {
        return "Energiforbruk: " + getWattsRequired() + " W \nSpenning inn: " + getInVoltage() +
                " V \nSpenning ut: " + getOutVoltage() + " V";
    }

    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
        for (int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }
        }
        try {
            setWattsRequired(Double.parseDouble(split[1]));
            setInVoltage(Integer.parseInt(split[2]));
            setOutVoltage(Integer.parseInt(split[3]));
        } catch (NumberFormatException | IllegalVoltageException n){
            return false;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(inVoltage.getValue());
        s.writeInt(outVoltage.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.inVoltage = new SimpleIntegerProperty(s.readInt());
        this.outVoltage = new SimpleIntegerProperty(s.readInt());
    }

    @Override
    public String toString(){
        return "PowerSupply" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getInVoltage() + "," + getOutVoltage();
    }
}