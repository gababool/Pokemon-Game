package assignment2;

import java.util.ArrayList;

public class ItemBag {

    private final double MAX_WEIGHT;
    private double currentWeight;
    private ArrayList<Item> storedItems;
    private int numOfItems;
    
    public ItemBag(double MAX_WEIGHT){
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.currentWeight = 0;
        this.storedItems = new ArrayList<>();
        this.numOfItems = 0;
    }

    public int addItem(Item item){
        double weight = item.getWeight();
        if (weight + currentWeight > MAX_WEIGHT){
            return -1;
        } else {
            storedItems.add(item);
            currentWeight += weight;
            numOfItems += 1;
            int itemIndex = sortItems(weight);
            return itemIndex;
        }
    }

    public Item removeItemAt(int index){
        if (index > (storedItems.size() - 1) || index < 0){ 
            return null;
        }
        else{
            Item removedItem = storedItems.get(index);
            numOfItems -= 1;
            currentWeight -= removedItem.getWeight();
            return storedItems.remove(index); // No need to sort again after removal. The ArrayList gets adjusted.
        }
    }

    public Item popItem(){
        int lastIndex = storedItems.size() - 1;
        if (numOfItems == 0){
            return null;
        } else{
            return removeItemAt(lastIndex);
        }
    }

    public int sortItems(double weight){
        int itemIndex = 0;
        double weightCounter = 0;
        int i = 0;
        while (weightCounter != MAX_WEIGHT && i < storedItems.length){
            weightCounter += storedItems[i].getWeight();
            if (storedItems[i].getWeight() >= MAX_WEIGHT){
                return -1;
            }
                
        }
        i++;

        while (weightCounter <= MAX_WEIGHT){
            for (int i = 0; i < storedItems.length; i++){
                weightCounter += storedItems[i].getWeight();    
            }
        } 
    }

    public String peekItemAt(int index){
        Item item = storedItems.get(index);
        return item.toString();
    }

    public double getMAX_WEIGHT() {
        return MAX_WEIGHT;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    


}
