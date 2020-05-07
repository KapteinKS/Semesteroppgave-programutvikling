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

    /*public String getType() {
        return "RAM";
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

    @Override
    public String toString(){
        return "RAM" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getSize() + "," + getMemoryType() + "," + getAmountOfRAMPieces();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        /*s.writeUTF(super.getName());
        s.writeUTF(super.getManufacturer());
        s.writeDouble(super.getWattsRequired());
        s.writeDouble(super.getPrice());*/
        s.defaultWriteObject();
        s.writeUTF(getType());
        s.writeUTF(size.getValue());
        s.writeUTF(memoryType.getValue());
        s.writeUTF(amountOfRAMPieces.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        super.type = new SimpleStringProperty(s.readUTF());
        this.size = new SimpleStringProperty(s.readUTF());
        this.memoryType = new SimpleStringProperty(s.readUTF());
        this.amountOfRAMPieces = new SimpleStringProperty(s.readUTF());
    }
}
