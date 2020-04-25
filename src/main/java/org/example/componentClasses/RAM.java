package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class RAM extends Component implements Serializable {
    private SimpleStringProperty size;
    private SimpleStringProperty memoryType;
    private SimpleStringProperty amountOfRAMPieces;

    public RAM(SimpleStringProperty size, SimpleStringProperty memoryType, SimpleStringProperty amountOfRAMPieces) {
        this.size = size;
        this.memoryType = memoryType;
        this.amountOfRAMPieces = amountOfRAMPieces;
    }

    public RAM(String name, String manufacturer, double wattsRequired, double price, SimpleStringProperty size, SimpleStringProperty memoryType, SimpleStringProperty amountOfRAMPieces) {
        super(name, manufacturer, wattsRequired, price);
        this.size = size;
        this.memoryType = memoryType;
        this.amountOfRAMPieces = amountOfRAMPieces;
    }

    public String getSize() {
        return size.get();
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getMemoryType() {
        return memoryType.get();
    }

    public SimpleStringProperty memoryTypeProperty() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType.set(memoryType);
    }

    public String getAmountOfRAMPieces() {
        return amountOfRAMPieces.get();
    }

    public SimpleStringProperty amountOfRAMPiecesProperty() {
        return amountOfRAMPieces;
    }

    public void setAmountOfRAMPieces(String amountOfRAMPieces) {
        this.amountOfRAMPieces.set(amountOfRAMPieces);
    }

    @Override
    public String toString(){
        return "RAM" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getSize() + "," + getMemoryType() + "," + getAmountOfRAMPieces();
    }
}
