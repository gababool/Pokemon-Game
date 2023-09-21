package pokemontest;

import assignment2.Item;
import assignment2.Pokemon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task6Test {

    @BeforeEach
    public void setupLocale(){
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    public void shouldCreateValidItems(){
        Item potion = new Item("Potion", 20, 5.0);
        Item superPotion = new Item("Super Potion", 60, 8.31235);
        Item hyperPotion = new Item("Hyper Potion", 120, 10.77850);

        assertEquals("Potion heals 20 HP. (5.00)"  , potion.toString());
        assertEquals("Super Potion heals 60 HP. (8.31)"  , superPotion.toString());
        assertEquals("Hyper Potion heals 120 HP. (10.77)", hyperPotion.toString());

        Item potionCopy = new Item("Potion", 20, 5.0);

        assertEquals(potion, potionCopy);
        assertNotEquals(potion, superPotion);
    }

    @Test
    public void shouldUseItemOnPokemon(){
        Pokemon venusaur = new Pokemon("Venusaur", 200, "Grass");
        venusaur.learnSkill("Solar Beam", 100, 50);
        Pokemon magikarp = new Pokemon("Magikarp", 50, "Water");

        venusaur.attack(magikarp);
        assertEquals(0, magikarp.getCurrentHP());
        magikarp.rest(); // should not rest.
        assertEquals(0, magikarp.getCurrentHP());

        Item potion = new Item("Potion", 30, 5.0);
        assertEquals("Magikarp used Potion. It healed 30 HP.", magikarp.useItem(potion));
        assertEquals(30, magikarp.getCurrentHP());

        assertEquals("Magikarp used Potion. It healed 20 HP.", magikarp.useItem(potion));
        assertEquals(50, magikarp.getCurrentHP());

        assertEquals("Magikarp could not use Potion. HP is already full.", magikarp.useItem(potion));
        assertEquals(50, magikarp.getCurrentHP());
    }

}
