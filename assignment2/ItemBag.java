package assignment2;
public class ItemBag {

    private final double MAX_WEIGHT;
    private double currentWeight;
    private Item[] storedItems;
    
    public ItemBag(double MAX_WEIGHT){
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.currentWeight = 0;
        this.storedItems = new Item[Integer.MAX_VALUE];

    }

    public int addItem(Item item){
        double weight = item.getWeight();
        if (weight + currentWeight > MAX_WEIGHT){
            return -1;
        } else {
            int itemIndex = sortItems(weight);
            return itemIndex;
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

    public void placeItem(){
        // When item is added to bag, sout index position
    }


}
