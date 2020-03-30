package org.example.components;

public class GraphicCard extends Component {
    private int ram;
    private String ramType;
    private int hertz;

    public GraphicCard(String name, String manufacturer, double price, int ram, String ramType, int hertz) {
        super(name, manufacturer, price);
        this.ram = ram;
        this.ramType = ramType;
        this.hertz = hertz;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getRamType() {
        return ramType;
    }

    public void setRamType(String ramType) {
        this.ramType = ramType;
    }

    public int getHertz() {
        return hertz;
    }

    public void setHertz(int hertz) {
        this.hertz = hertz;
    }
}
