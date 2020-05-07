package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cabinet extends Component {
    private transient SimpleStringProperty mbFormFactor;
    private transient SimpleIntegerProperty height;
    private transient SimpleIntegerProperty width;
    private transient SimpleIntegerProperty depth;
    private transient SimpleDoubleProperty weight;

    public Cabinet(String name, String manufacturer, double price, String mbFormFactor, int height, int width, int depth, double weight) {
        super("Cabinet", name, manufacturer, 0, price);
        this.mbFormFactor = new SimpleStringProperty(mbFormFactor);
        this.height = new SimpleIntegerProperty(height);
        this.width = new SimpleIntegerProperty(width);
        this.depth = new SimpleIntegerProperty(depth);
        this.weight = new SimpleDoubleProperty(weight);
    }

    public String getMbFormFactor() {
        return mbFormFactor.get();
    }

    public SimpleStringProperty mbFormFactorProperty() {
        return mbFormFactor;
    }

    public void setMbFormFactor(String mbFormFactor) {
        this.mbFormFactor.set(mbFormFactor);
    }

    public int getHeight() {
        return height.getValue();
    }

    public void setHeight(int height) {
        this.height.set(height);
    }

    public int getWidth() {
        return width.getValue();
    }

    public void setWidth(int width) {
        this.width.set(width);
    }

    public int getDepth() {
        return depth.getValue();
    }

    public void setDepth(int depth) {
        this.depth.set(depth);
    }

    public double getWeight() {
        return weight.getValue();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public String getInfo(){
        return "Høyde: " + getHeight() + "cm \nBredde: " + getWidth() + "cm \nDybde: " + getDepth() +
                "cm \nVekt: " + getWeight() + "kg";
    }

    @Override
    public String toString(){
        return "Cabinet" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getHeight() + "," + getWidth() + "," + getDepth() + "," + getWeight();
    }

    public void writeObject(ObjectOutputStream s) throws IOException{
        //super.writeObject(s);
        s.writeUTF(getName());
        s.writeUTF(getManufacturer());
        s.writeDouble(getWattsRequired());
        s.writeDouble(getPrice());
        s.writeUTF(mbFormFactor.getValue());
        s.writeInt(height.getValue());
        s.writeInt(width.getValue());
        s.writeInt(depth.getValue());
        s.writeDouble(weight.getValue());
    }

    public void readObject(ObjectInputStream s) throws IOException{
        //super.readObject(s);
        String name = s.readUTF();
        String manufacturer = s.readUTF();
        double wattsRequired = s.readDouble();
        double price = s.readDouble();
        String mbFormFactor = s.readUTF();
        int height = s.readInt();
        int width = s.readInt();
        int depth = s.readInt();
        double weight = s.readDouble();

        setType("Cabinet");
        setName(name);
        setManufacturer(manufacturer);
        setWattsRequired(wattsRequired);
        setPrice(price);
        this.mbFormFactor = new SimpleStringProperty(mbFormFactor);
        this.height = new SimpleIntegerProperty(height);
        this.width = new SimpleIntegerProperty(width);
        this.depth = new SimpleIntegerProperty(depth);
        this.weight = new SimpleDoubleProperty(weight);
    }
}