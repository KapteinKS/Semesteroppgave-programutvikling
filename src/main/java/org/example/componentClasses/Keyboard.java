package org.example.componentClasses;

import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Keyboard extends Component implements Serializable {
    private SimpleIntegerProperty keyboardSwitches; //membrane/mechanical and which type of mechanical switches
    private SimpleIntegerProperty keyboardLanguage; // ex. Nordic, US, UK
    private SimpleIntegerProperty keyboardConnectionType;  // ex. USB-A, USB-C, wireless

    public Keyboard(String type, String name, String manufacturer, double wattsRequired, double price, SimpleIntegerProperty keyboardSwitches, SimpleIntegerProperty keyboardLanguage, SimpleIntegerProperty keyboardConnectionType) {
        super(type, name, manufacturer, wattsRequired, price);
        this.keyboardSwitches = keyboardSwitches;
        this.keyboardLanguage = keyboardLanguage;
        this.keyboardConnectionType = keyboardConnectionType;
    }

    public int getKeyboardSwitches() {
        return keyboardSwitches.get();
    }

    public SimpleIntegerProperty keyboardSwitchesProperty() {
        return keyboardSwitches;
    }

    public void setKeyboardSwitches(int keyboardSwitches) {
        this.keyboardSwitches.set(keyboardSwitches);
    }

    public int getKeyboardLanguage() {
        return keyboardLanguage.get();
    }

    public SimpleIntegerProperty keyboardLanguageProperty() {
        return keyboardLanguage;
    }

    public void setKeyboardLanguage(int keyboardLanguage) {
        this.keyboardLanguage.set(keyboardLanguage);
    }

    public int getKeyboardConnectionType() {
        return keyboardConnectionType.get();
    }

    public SimpleIntegerProperty keyboardConnectionTypeProperty() {
        return keyboardConnectionType;
    }

    public void setKeyboardConnectionType(int keyboardConnectionType) {
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
