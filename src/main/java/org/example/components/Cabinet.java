package org.example.components;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

public class Cabinet extends Component implements Serializable {
    private transient SimpleIntegerProperty height;
    private transient SimpleIntegerProperty width;
    private transient SimpleIntegerProperty depth;
    private transient SimpleDoubleProperty weight;

    public Cabinet(String name, String manufacturer, double price, int height, int width, int depth, double weight) {
        super(name, manufacturer, price);
        this.height = new SimpleIntegerProperty(height);
        this.width = new SimpleIntegerProperty(width);
        this.depth = new SimpleIntegerProperty(depth);
        this.weight = new SimpleDoubleProperty(weight);
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
}