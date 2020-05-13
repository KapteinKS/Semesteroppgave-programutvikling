package org.example.componentClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.exceptions.IllegalDimensionsException;
import org.example.exceptions.IllegalWeightException;

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
        //  The component-type is set directly in constructor, without taking in a parameter. Also, since a cabinet
        //  does not require power, we set the wattsRequired to '0'. This is done for some of the component-types.
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

    public void setHeight(double height) throws IllegalDimensionsException {
        if (height >= 20 && height <= 150) {
            this.height.set(height);
        } else {
            throw new IllegalDimensionsException("Kan ikke sette høyde");
        }
    }

    public double getWidth() {
        return width.getValue();
    }

    public void setWidth(double width) throws IllegalDimensionsException {
        if (width >= 5 && width <= 40) {
            this.width.set(width);
        } else {
            throw new IllegalDimensionsException("Kan ikke sette bredde");
        }
    }

    public double getDepth() {
        return depth.getValue();
    }

    public void setDepth(double depth) throws IllegalDimensionsException {
        if (depth >= 20 && depth <= 125) {
            this.depth.set(depth);
        } else {
            throw new IllegalDimensionsException("Kan ikke sette dybde");
        }
    }

    public double getWeight() {
        return weight.getValue();
    }

    public void setWeight(double weight) throws IllegalWeightException {
        if (weight > 0) {
            this.weight.set(weight);
        } else {
            throw new IllegalWeightException("Kan ikke sette vekt");
        }
    }
    //  getInfo returns the non-universal attributes, formatted neatly
    public String getInfo(){
        return "Høyde: " + getHeight() + " cm \nBredde: " + getWidth() + " cm \nDybde: " + getDepth() +
                " cm \nVekt: " + getWeight() + " kg";
    }
    //  setInfo does some input validation, further validated in other setters
    public boolean setInfo(String info) throws IOException {
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
        } catch (NumberFormatException | IllegalDimensionsException | IllegalWeightException n){
            throw new IOException(n.getMessage());
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
    //  toStrings() returns a .csv
    @Override
    public String toString(){
        return "Cabinet" + "," + getName() + "," + getManufacturer() + "," + getWattsRequired() + "," + getPrice()
                + "," + getMbFormFactor() + "," + getHeight() + "," + getWidth() + "," + getDepth() + "," + getWeight();
    }
}