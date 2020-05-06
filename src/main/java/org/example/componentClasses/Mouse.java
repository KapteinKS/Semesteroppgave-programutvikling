package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Mouse extends Component implements Serializable {
    private SimpleIntegerProperty mouseDPI; //sier seg selv
    private SimpleIntegerProperty mouseConnectionType; // ex. USB-A, USB-C, wireless...
    private SimpleIntegerProperty mouseProgrammableButtons; //How many extra buttons apart from the regular left-, right and middleclick

    public Mouse(String type, String name, String manufacturer, double wattsRequired, double price, SimpleIntegerProperty mouseDPI, SimpleIntegerProperty mouseConnectionType, SimpleIntegerProperty mouseProgrammableButtons) {
        super(type, name, manufacturer, wattsRequired, price);
        this.mouseDPI = mouseDPI;
        this.mouseConnectionType = mouseConnectionType;
        this.mouseProgrammableButtons = mouseProgrammableButtons;
    }

    public int getMouseDPI() {
        return mouseDPI.get();
    }

    public SimpleIntegerProperty mouseDPIProperty() {
        return mouseDPI;
    }

    public void setMouseDPI(int mouseDPI) {
        this.mouseDPI.set(mouseDPI);
    }

    public int getMouseConnectionType() {
        return mouseConnectionType.get();
    }

    public SimpleIntegerProperty mouseConnectionTypeProperty() {
        return mouseConnectionType;
    }

    public void setMouseConnectionType(int mouseConnectionType) {
        this.mouseConnectionType.set(mouseConnectionType);
    }

    public int getMouseProgrammableButtons() {
        return mouseProgrammableButtons.get();
    }

    public SimpleIntegerProperty mouseProgrammableButtonsProperty() {
        return mouseProgrammableButtons;
    }

    public void setMouseProgrammableButtons(int mouseProgrammableButtons) {
        this.mouseProgrammableButtons.set(mouseProgrammableButtons);
    }

    public String getInfo(){
        return "Grensesnitt: " + getMouseConnectionType() + "\nDPI: " + getMouseDPI() + "\nAntall programmerbare taster: " + getMouseProgrammableButtons();
    }

    @Override
    public String toString() {
        return "Mouse" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMouseConnectionType() + "," + getMouseDPI() + "," + getMouseProgrammableButtons();
    }
}
