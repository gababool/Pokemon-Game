package pokemontest;

import assignment2.Item;
import assignment2.ItemBag;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task7Test {

    @BeforeEach
    public void setupLocale(){
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    public void shouldCreateValidItemStash(){
        Item potion = new Item("Potion", 20, 5.0);
        Item superPotion = new Item("Super Potion", 40, 8.0);

        ItemBag itemBag = new ItemBag(30.0);
        assertEquals(0, itemBag.getNumOfItems());
        assertEquals(0.0, itemBag.getCurrentWeight());
        assertEquals(30.0, itemBag.getMaxWeight());

        itemBag.addItem(potion);
        itemBag.addItem(superPotion);
        assertEquals(2, itemBag.getNumOfItems());
        assertEquals(13.0, itemBag.getCurrentWeight());
        assertEquals(30.0, itemBag.getMaxWeight());
    }

    @Test
    public void shouldAddItemsCorrectly(){
        Item potion1 = new Item("Potion", 20, 5.0);
        Item potion2 = new Item("Potion", 20, 5.0);
        Item potion3 = new Item("Potion", 20, 5.0);

        Item hyperPotion = new Item("Hyper Potion", 50, 10.0);
        Item superPotion = new Item("Super Potion", 40, 8.3);

        ItemBag itemBag = new ItemBag(30.0);
        assertEquals(0, itemBag.addItem(potion1));
        assertEquals(0, itemBag.addItem(potion2));
        assertEquals(0, itemBag.addItem(hyperPotion));
        assertEquals(1, itemBag.addItem(superPotion));
        assertEquals(-1, itemBag.addItem(potion3));

        assertEquals(4, itemBag.getNumOfItems());
        assertEquals(28.3, itemBag.getCurrentWeight());
    }

    @Test
    public void shouldPreserveOrder(){
        Item potion1 = new Item("Potion", 20, 5.0);
        Item potion2 = new Item("Potion", 20, 5.0);
        Item hyperPotion = new Item("Hyper Potion", 50, 10.0);
        Item superPotion = new Item("Super Potion", 40, 8.34867);

        ItemBag itemBag = new ItemBag(30.0);
        assertEquals(0, itemBag.addItem(hyperPotion));
        assertEquals(1, itemBag.addItem(potion1));
        assertEquals(1, itemBag.addItem(superPotion));
        assertEquals(2, itemBag.addItem(potion2));

        assertEquals("Hyper Potion heals 50 HP. (10.00)", itemBag.peekItemAt(0));
        assertEquals("Super Potion heals 40 HP. (8.34)", itemBag.peekItemAt(1));
        assertEquals("Potion heals 20 HP. (5.00)", itemBag.peekItemAt(2));
        assertEquals("Potion heals 20 HP. (5.00)", itemBag.peekItemAt(3));

        // indices outside bounds return null.
        assertEquals("", itemBag.peekItemAt(5));
        assertEquals("", itemBag.peekItemAt(-1));
    }

    @Test
    public void shouldRemoveItemsByIndex(){
        Item potion = new Item("Potion", 20, 5.0);
        Item hyperPotion = new Item("Hyper Potion", 50, 10.0);
        Item superPotion = new Item("Super Potion", 40, 8.0);

        ItemBag itemBag = new ItemBag(15.0);
        itemBag.addItem(potion);
        itemBag.addItem(hyperPotion);
        assertEquals(-1, itemBag.addItem(superPotion));
        assertEquals(15.0, itemBag.getCurrentWeight());

        assertEquals(hyperPotion, itemBag.removeItemAt(0));
        assertNull(itemBag.removeItemAt(1));
        assertEquals(0, itemBag.addItem(superPotion));
        assertEquals(13.0, itemBag.getCurrentWeight());
    }

    @Test
    public void shouldPopItem(){
        Item hyperPotion = new Item("Hyper Potion", 50, 10.0);
        Item superPotion = new Item("Super Potion", 40, 8.0);

        ItemBag itemBag = new ItemBag(20.0);
        itemBag.addItem(superPotion);
        itemBag.addItem(hyperPotion);
        assertEquals(hyperPotion, itemBag.popItem());
        assertEquals(8.0, itemBag.getCurrentWeight());

        assertEquals(superPotion, itemBag.popItem());
        assertNull(itemBag.popItem());
        assertEquals(0.0, itemBag.getCurrentWeight());
        assertEquals(20.0, itemBag.getMaxWeight());
    }
}
