package org.example.components;

import java.io.Serializable;

public class Cabinet extends Component implements Serializable {
    private int height;
    private int width;
    private int depth;
    private double weight;

    public Cabinet(String name, String manufacturer, double price, int height, int width, int depth, double weight) {
        super(name, manufacturer, price);
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Cabinet" + "," + getName() + "," + getManufacturer() + "," + getPrice()
                + "," + getHeight() + "," + getWidth() + "," + getDepth() + "," + getWeight();
    }
}