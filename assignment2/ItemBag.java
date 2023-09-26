package assignment2;

import java.util.ArrayList;

public class ItemBag {

    private final double MAX_WEIGHT;
    private ArrayList<Item> storedItems;

    public ItemBag(double MAX_WEIGHT) {
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.storedItems = new ArrayList<>();
    }

    public int addItem(Item item) {
        if (item.getWeight() + getCurrentWeight() > getMaxWeight()) {
            return -1;
        }
        int indexToAdd = getItemWeightIndex(item);
        if (indexToAdd >= 0)
            storedItems.add(indexToAdd, item);
        else {
            storedItems.add(item);
        }
        return storedItems.indexOf(item);
    }

    private int getItemWeightIndex(Item item) {
        int indexToAdd = -1;
        for (Item i : storedItems) {
            if (i.getWeight() < item.getWeight()) {
                indexToAdd = storedItems.indexOf(i);
                return indexToAdd;
            }
        }
        return indexToAdd;
    }

    public String peekItemAt(int index) {
        if (!isIndexOutOfBounds(index)) {
            Item item = storedItems.get(index);
            return item.toString();
        } return "";  
    }

    public Item removeItemAt(int index) {
        if (!isIndexOutOfBounds(index)) {
            Item item = storedItems.remove(index);
            return item;
        }
        return null;
    }

    public boolean isIndexOutOfBounds(int index) {
        if (index < 0) {
            return true;
        } else if (index > storedItems.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public Item popItem() {
        return removeItemAt(0);
    }

    public double getMaxWeight() {
        return MAX_WEIGHT;
    }

    public double getCurrentWeight() { // Variable or loop? 
        double currentWeight = 0;
        for (Item i : storedItems) {
            currentWeight += i.getWeight();
        }
        return currentWeight;
    }

    public int getNumOfItems() {
        return storedItems.size();
    }
}
