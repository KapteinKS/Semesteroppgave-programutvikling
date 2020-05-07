package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RAM extends Component implements Serializable {
    private transient SimpleStringProperty size;
    private transient SimpleStringProperty memoryType;
    private transient SimpleStringProperty amountOfRAMPieces;

    public RAM(String name, String manufacturer, double price, String size, String memoryType, int amountOfRAMPieces) {
        super("RAM",name, manufacturer, 0, price);
        this.size = new SimpleStringProperty(size);
        this.memoryType = new SimpleStringProperty(memoryType);
        this.amountOfRAMPieces = new SimpleStringProperty(""+amountOfRAMPieces);
    }

    public String getSize() {
        return size.getValue();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getMemoryType() {
        return memoryType.getValue();
    }

    public String memoryTypeProperty() {
        return memoryType.getValue();
    }

    public void setMemoryType(String memoryType) {
        this.memoryType.set(memoryType);
    }

    public String getAmountOfRAMPieces() {
        return amountOfRAMPieces.get();
    }

    public String amountOfRAMPiecesProperty() {
        return amountOfRAMPieces.getValue();
    }

    public void setAmountOfRAMPieces(String amountOfRAMPieces) {
        this.amountOfRAMPieces.set(amountOfRAMPieces);
    }

    public String getInfo(){
        return "Minne: " + getSize() + "GB " + getMemoryType();
    }

    @Override
    public String toString(){
        return "RAM" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getSize() + "," + getMemoryType() + "," + getAmountOfRAMPieces();
    }

    public void writeObject(ObjectOutputStream s) throws IOException {
        //super.writeObject(s);
        s.writeUTF(getName());
        s.writeUTF(getManufacturer());
        s.writeDouble(getWattsRequired());
        s.writeDouble(getPrice());
        s.writeUTF(size.getValue());
        s.writeUTF(memoryType.getValue());
        s.writeUTF(amountOfRAMPieces.getValue());

    }

    public void readObject(ObjectInputStream s) throws IOException{
        //super.readObject(s);
        String name = s.readUTF();
        String manufacturer = s.readUTF();
        double wattsRequired = s.readDouble();
        double price = s.readDouble();
        String size = s.readUTF();
        String memoryType = s.readUTF();
        String amountOfRAMPieces = s.readUTF();

        setType("Keyboard");
        setName(name);
        setManufacturer(manufacturer);
        setWattsRequired(wattsRequired);
        setPrice(price);
        this.size = new SimpleStringProperty(size);
        this.memoryType = new SimpleStringProperty(memoryType);
        this.amountOfRAMPieces = new SimpleStringProperty(amountOfRAMPieces);
    }
}
