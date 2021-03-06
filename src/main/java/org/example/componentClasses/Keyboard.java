package org.example.componentClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Keyboard extends Component implements Serializable {
    private transient SimpleStringProperty keyboardSwitches;  //  membrane/mechanical and which type of mechanical switches
    private transient SimpleStringProperty keyboardLanguage;  //  ex. Nordic, US, UK
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

    public String getType() {
        return "Keyboard";
    }

    //  getInfo returns the non-universal attributes, formatted neatly
    public String getInfo(){
        return "Grensesnitt: " + getKeyboardConnectionType() + "\nSpråk: " + getKeyboardLanguage() + "\nType taster: " + getKeyboardSwitches();
    }

    //  setInfo does some input validation, further validated in other setters
    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅ][a-zæøå ]{1,20}: ");
        try {
            setKeyboardConnectionType(split[1]);
            setKeyboardLanguage(split[2]);
            setKeyboardSwitches(split[3]);
        } catch (NumberFormatException n){
            return false;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(keyboardSwitches.getValue());
        s.writeUTF(keyboardLanguage.getValue());
        s.writeUTF(keyboardConnectionType.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.keyboardSwitches = new SimpleStringProperty(s.readUTF());
        this.keyboardLanguage = new SimpleStringProperty(s.readUTF());
        this.keyboardConnectionType = new SimpleStringProperty(s.readUTF());
    }

    @Override
    public String toString() {
        return "Keyboard" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getKeyboardConnectionType() + "," + getKeyboardLanguage() + "," + getKeyboardSwitches();
    }
}
