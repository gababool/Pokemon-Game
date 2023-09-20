package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task1Test {

    @Test
    public void shouldCreateValidPokemon(){
        Pokemon charmander = new Pokemon("Charmander", 100, "Fire");
        assertEquals(100, charmander.getEnergy());
        assertEquals(100, charmander.getCurrentHP());
        assertEquals("Charmander", charmander.getName());
        assertEquals("Fire", charmander.getType());
        assertEquals("Charmander (Fire)", charmander.toString());
        assertEquals(100, charmander.getMAX_HP());
        assertEquals(charmander.getCurrentHP(), charmander.getMAX_HP());

        Pokemon squirtle = new Pokemon("Squirtle", 120, "Water");
        assertEquals(100, squirtle.getEnergy());
        assertEquals(120, squirtle.getCurrentHP());
        assertEquals("Squirtle", squirtle.getName());
        assertEquals("Water", squirtle.getType());
        assertEquals("Squirtle (Water)", squirtle.toString());
        assertEquals(120, squirtle.getMAX_HP());
        assertEquals(squirtle.getCurrentHP(), squirtle.getMAX_HP());
    }

    @Test
    public void shouldCheckEqualPokemons(){
        Pokemon exeggute1 = new Pokemon("Exeggcute", 95, "Grass");
        Pokemon exeggute2 = new Pokemon("Exeggcute", 95, "Grass");
        Pokemon ditto = new Pokemon("Exeggcute", 95, "Normal"); // diff type.

        assertEquals(exeggute1, exeggute2); //If they both dont know a skill, they have equal skills.
        assertNotEquals(exeggute1, ditto);
    }


}
