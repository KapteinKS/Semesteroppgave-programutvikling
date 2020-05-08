package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

    public void setSize(int size) {
        this.size.set(size);
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

    public void setAmountOfRAMPieces(int amountOfRAMPieces) {
        this.amountOfRAMPieces.set(amountOfRAMPieces);
    }

    public String getInfo(){
        return "Minne: " + getSize() + " GB " + getMemoryType() +"\nBrikker: " + getAmountOfRAMPieces() + " x " + getSize()/getAmountOfRAMPieces() + " GB";
    }

    @Override
    public String toString(){
        return "RAM" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getSize() + "," + getMemoryType() + "," + getAmountOfRAMPieces();
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
}
