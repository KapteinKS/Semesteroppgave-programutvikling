package org.example.components;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class RAM extends Component implements Serializable {
    private SimpleStringProperty memory;
    private SimpleStringProperty amountOfRAMPieces;

    public RAM(SimpleStringProperty memory, SimpleStringProperty amountOfRAMPieces) {
        this.memory = memory;
        this.amountOfRAMPieces = amountOfRAMPieces;
    }

    public RAM(String name, String manufacturer, double price, SimpleStringProperty memory, SimpleStringProperty amountOfRAMPieces) {
        super(name, manufacturer, price);
        this.memory = memory;
        this.amountOfRAMPieces = amountOfRAMPieces;
    }

    public String getMemory() {
        return memory.get();
    }

    public SimpleStringProperty memoryProperty() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory.set(memory);
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
        return "RAM" + "," + getName() + "," + getManufacturer() + "," +
                getPrice() + "," + getMemory() + "," + getAmountOfRAMPieces();
    }
}
