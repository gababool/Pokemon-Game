package assignment2;

//import java.math.RoundingMode;
//import java.text.DecimalFormat;

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

    private double truncateDouble(double value){
        double factor = Math.pow(10, 2);
        return Math.floor(value * factor) / factor;
    }


    //private String truncateDouble3(double value){
      //  DecimalFormat df = new DecimalFormat("#.##");
        //df.setRoundingMode(RoundingMode.DOWN);
        //return df.format(value);
    //}


   // private double truncateDouble2(double value){
     //   double truncated = ((int)(value * 100)) / 100;
       // return truncated;
    //}

    @Override
    public String toString(){
        return String.format("%s heals %d HP. (%.2f)", name, powerValue, truncateDouble(weight));
    }

    @Override
    public boolean equals(Object obj) {
        Item itemToCompare = (Item) obj;
   
        return (itemToCompare.name == name && itemToCompare.powerValue == powerValue && itemToCompare.weight == weight);
    }
}
