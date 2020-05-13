package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalRAMException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RAM extends Component implements Serializable {
    private transient SimpleIntegerProperty size;
    private transient SimpleStringProperty memoryType;
    private transient SimpleIntegerProperty amountOfRAMPieces;

    public RAM(String name, String manufacturer, double price, int size, String memoryType, int amountOfRAMPieces) {
        super("RAM",name, manufacturer, 0, price);
        this.size = new SimpleIntegerProperty(size);
        this.memoryType = new SimpleStringProperty(memoryType);
        this.amountOfRAMPieces = new SimpleIntegerProperty(amountOfRAMPieces);
    }

    public int getSize() {
        return size.getValue();
    }

    public void setSize(int size) throws IllegalRAMException {
        if(size > 1) {
            this.size.set(size);
        }else{
            throw new IllegalRAMException("Ugyldig RAM minne!");
        }
    }

    public String getMemoryType() {
        return memoryType.getValue();
    }

    public void setMemoryType(String memoryType) {
        this.memoryType.set(memoryType);
    }

    public int getAmountOfRAMPieces() {
        return amountOfRAMPieces.get();
    }

    public void setAmountOfRAMPieces(int amountOfRAMPieces) throws IllegalRAMException{
        if (amountOfRAMPieces > 0) {
            this.amountOfRAMPieces.set(amountOfRAMPieces);
        }else{
            throw new IllegalRAMException("Ugyldig antall RAM brikker!");
        }
    }

    //  getInfo returns the non-universal attributes, formatted neatly
    public String getInfo(){
        return "Minne: " + getSize() + " GB \nMinnetype: " + getMemoryType() +" \nBrikker: " + getAmountOfRAMPieces();
    }

    //  setInfo does some input validation, further validated in other setters
    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅa-zæøå]{1,20}: ");
        for (int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }
        }
        try {
            setSize(Integer.parseInt(split[1]));
            setMemoryType(split[2]);
            setAmountOfRAMPieces(Integer.parseInt(split[3]));
        } catch (NumberFormatException | IllegalRAMException n){
            return false;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size.getValue());
        s.writeUTF(memoryType.getValue());
        s.writeInt(amountOfRAMPieces.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.size = new SimpleIntegerProperty(s.readInt());
        this.memoryType = new SimpleStringProperty(s.readUTF());
        this.amountOfRAMPieces = new SimpleIntegerProperty(s.readInt());
    }

    @Override
    public String toString(){
        return "RAM" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getSize() + "," + getMemoryType() + "," + getAmountOfRAMPieces();
    }
}
