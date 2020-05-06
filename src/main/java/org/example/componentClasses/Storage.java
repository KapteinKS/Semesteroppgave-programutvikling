package org.example.componentClasses;

        import javafx.beans.property.SimpleIntegerProperty;
        import javafx.beans.property.SimpleStringProperty;

        import java.io.Serializable;

public class Storage extends Component implements Serializable {
    private SimpleStringProperty Storagetype;
    private SimpleIntegerProperty capacity;
    private SimpleStringProperty capacityType;

    public Storage(String name, String manufacturer, double price, String Storagetype, int capacity, String capacityType) {
        super("Storage", name, manufacturer, 0, price);
        this.Storagetype = new SimpleStringProperty(Storagetype);
        this.capacity = new SimpleIntegerProperty(capacity);
        this.capacityType = new SimpleStringProperty(capacityType);
    }

    public String getStoragetype() {
        return Storagetype.get();
    }

    public SimpleStringProperty storagetypeProperty() {
        return Storagetype;
    }

    public void setStoragetype(String storagetype) {
        this.Storagetype.set(storagetype);
    }

    public int getCapacity() {
        return capacity.get();
    }

    public SimpleIntegerProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity.set(capacity);
    }

    public String getCapacityType() {
        return capacityType.get();
    }

    public SimpleStringProperty capacityTypeProperty() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType.set(capacityType);
    }

    public String getInfo(){
        return "Lagringstype: " + getStoragetype() + "\nKapasitet: " + getCapacity() + getCapacityType();
    }
}