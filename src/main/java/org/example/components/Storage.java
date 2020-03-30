package org.example.components;

public class Storage extends Component {
    private String type;
    private int capacity;

    public Storage(String name, String manufacturer, double price, String type, int capacity) {
        super(name, manufacturer, price);
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}