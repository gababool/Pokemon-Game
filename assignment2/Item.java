package assignment2;

public class Item {
    private final String name;
    private final int powerValue;
    private final double weight;

    public Item(String name, int powerValue, double weight){

        this.name = name;
        this.powerValue = powerValue;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getPowerValue() {
        return powerValue;
    }

    public double getWeight() {
        return weight;
    }

    

}
