package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Keyboard extends Component implements Serializable {
    private transient SimpleStringProperty keyboardSwitches; //membrane/mechanical and which type of mechanical switches
    private transient SimpleStringProperty keyboardLanguage; // ex. Nordic, US, UK
    private transient SimpleStringProperty keyboardConnectionType;  // ex. USB-A, USB-C, wireless

    public Keyboard(String name, String manufacturer, double wattsRequired, double price, String keyboardSwitches, String keyboardLanguage, String keyboardConnectionType) {
        super("Keyboard", name, manufacturer, wattsRequired, price);
        this.keyboardSwitches = new SimpleStringProperty(keyboardSwitches);
        this.keyboardLanguage = new SimpleStringProperty(keyboardLanguage);
        this.keyboardConnectionType = new SimpleStringProperty(keyboardConnectionType);
    }

    public String getKeyboardSwitches() {
        return keyboardSwitches.getValue();
    }

    public void setKeyboardSwitches(String keyboardSwitches) {
        this.keyboardSwitches.set(keyboardSwitches);
    }

    public String getKeyboardLanguage() {
        return keyboardLanguage.getValue();
    }

    public void setKeyboardLanguage(String keyboardLanguage) {
        this.keyboardLanguage.set(keyboardLanguage);
    }

    public String getKeyboardConnectionType() {
        return keyboardConnectionType.getValue();
    }

    public void setKeyboardConnectionType(String keyboardConnectionType) {
        this.keyboardConnectionType.set(keyboardConnectionType);
    }

    public String getInfo(){
        return "Grensesnitt: " + getKeyboardConnectionType() + "\nSpråk: " + getKeyboardLanguage() + "\nType taster: " + getKeyboardSwitches();
    }

    @Override
    public String toString() {
        return "Keyboard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getKeyboardConnectionType() + "," + getKeyboardLanguage() + "," + getKeyboardSwitches();
    }
}
