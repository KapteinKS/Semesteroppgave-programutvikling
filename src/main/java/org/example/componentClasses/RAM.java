package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class RAM extends Component implements Serializable {
    private SimpleStringProperty size;
    private SimpleStringProperty memoryType;
    private SimpleStringProperty amountOfRAMPieces;

    public RAM(String name, String manufacturer, double price, String size, String memoryType, int amountOfRAMPieces) {
        super(name, manufacturer, 0, price);
        this.size = new SimpleStringProperty(size);
        this.memoryType = new SimpleStringProperty(memoryType);
        this.amountOfRAMPieces = new SimpleStringProperty(""+amountOfRAMPieces);
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
