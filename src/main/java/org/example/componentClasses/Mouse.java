package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Mouse extends Component implements Serializable {
    private transient SimpleIntegerProperty mouseDPI; //sier seg selv
    private transient SimpleStringProperty mouseConnectionType; // ex. USB-A, USB-C, wireless...
    private transient SimpleIntegerProperty mouseProgrammableButtons; //How many extra buttons apart from the regular left-, right and middleclick

    public Mouse(String name, String manufacturer, double wattsRequired, double price, int mouseDPI, String mouseConnectionType, int mouseProgrammableButtons) {
        super("Mouse", name, manufacturer, wattsRequired, price);
        this.mouseDPI = new SimpleIntegerProperty(mouseDPI);
        this.mouseConnectionType = new SimpleStringProperty(mouseConnectionType);
        this.mouseProgrammableButtons = new SimpleIntegerProperty(mouseProgrammableButtons);
    }

    public int getMouseDPI() {
        return mouseDPI.getValue();
    }

    public void setMouseDPI(int mouseDPI) {
        this.mouseDPI.set(mouseDPI);
    }

    public String getMouseConnectionType() {
        return mouseConnectionType.getValue();
    }

    public void setMouseConnectionType(String mouseConnectionType) {
        this.mouseConnectionType.set(mouseConnectionType);
    }

    public int getMouseProgrammableButtons() {
        return mouseProgrammableButtons.getValue();
    }

    public void setMouseProgrammableButtons(int mouseProgrammableButtons) {
        this.mouseProgrammableButtons.set(mouseProgrammableButtons);
    }

    public String getInfo() {
        return "Grensesnitt: " + getMouseConnectionType() + "\nDPI: " + getMouseDPI() + "\nAntall programmerbare taster: " + getMouseProgrammableButtons();
    }

    @Override
    public String toString() {
        return "Mouse" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMouseConnectionType() + "," + getMouseDPI() + "," + getMouseProgrammableButtons();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(getType());
        s.writeInt(mouseDPI.getValue());
        s.writeUTF(mouseConnectionType.getValue());
        s.writeInt(mouseProgrammableButtons.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        super.type = new SimpleStringProperty(s.readUTF());
        this.mouseDPI = new SimpleIntegerProperty(s.readInt());
        this.mouseConnectionType = new SimpleStringProperty(s.readUTF());
        this.mouseProgrammableButtons = new SimpleIntegerProperty(s.readInt());
    }
}
