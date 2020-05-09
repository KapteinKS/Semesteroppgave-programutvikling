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
    private transient SimpleDoubleProperty height;
    private transient SimpleDoubleProperty width;
    private transient SimpleDoubleProperty depth;
    private transient SimpleDoubleProperty weight;

    public Cabinet(String name, String manufacturer, double price, String mbFormFactor, double height, double width, double depth, double weight) {
        super("Cabinet", name, manufacturer, 0, price);
        this.mbFormFactor = new SimpleStringProperty(mbFormFactor);
        this.height = new SimpleDoubleProperty(height);
        this.width = new SimpleDoubleProperty(width);
        this.depth = new SimpleDoubleProperty(depth);
        this.weight = new SimpleDoubleProperty(weight);
    }

    public String getMbFormFactor() {
        return mbFormFactor.get();
    }

    public void setMbFormFactor(String mbFormFactor) {
        this.mbFormFactor.set(mbFormFactor);
    }

    public double getHeight() {
        return height.getValue();
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getWidth() {
        return width.getValue();
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getDepth() {
        return depth.getValue();
    }

    public void setDepth(double depth) {
        this.depth.set(depth);
    }

    public double getWeight() {
        return weight.getValue();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public String getInfo(){
        return "Høyde: " + getHeight() + " cm \nBredde: " + getWidth() + " cm \nDybde: " + getDepth() +
                " cm \nVekt: " + getWeight() + " kg";
    }

    public boolean setInfo(String info){
        String [] split = info.split("[A-ZÆØÅ][a-zæøå]{1,10}: ");


        for(int i = 1; i < split.length; i++){
            if(split[i].indexOf(" ") > 0) {
                split[i] = split[i].substring(0, split[i].indexOf(" "));
            }        }
        try {
            setHeight(Double.parseDouble(split[1]));
            setWidth(Double.parseDouble(split[2]));
            setDepth(Double.parseDouble(split[3]));
            setWeight(Double.parseDouble(split[4]));

        } catch (NumberFormatException n){
            return false;
        }
        return true;
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeUTF(mbFormFactor.getValue());
        s.writeDouble(height.getValue());
        s.writeDouble(width.getValue());
        s.writeDouble(depth.getValue());
        s.writeDouble(weight.getValue());
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.mbFormFactor = new SimpleStringProperty(s.readUTF());
        this.height = new SimpleDoubleProperty(s.readDouble());
        this.width = new SimpleDoubleProperty(s.readDouble());
        this.depth = new SimpleDoubleProperty(s.readDouble());
        this.weight = new SimpleDoubleProperty(s.readDouble());
    }

    @Override
    public String toString(){
        return "Cabinet" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMbFormFactor() + "," + getHeight() + "," + getWidth() + "," + getDepth() + "," + getWeight();
    }
}