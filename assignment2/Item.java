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

    private double truncateDouble(double value){
        double truncateDouble;
        truncateDouble = (int)(weight * 1000.0) / 10;
        truncateDouble = truncateDouble / 100;
        return truncateDouble;
    }

    @Override
    public String toString(){
        return String.format("%s heals %d HP. (%.2f)", name, powerValue, truncateDouble(weight));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Item itemToCompare = (Item)obj;
        boolean sameName = name == itemToCompare.getName();
        boolean samePower = powerValue == itemToCompare.getPowerValue();
        boolean sameWeight = weight == itemToCompare.getWeight();
   
        return (sameName && samePower && sameWeight);
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
