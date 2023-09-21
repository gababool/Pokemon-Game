package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {

    @Test
    public void shouldNotKnowSkills(){
        Pokemon charmander = new Pokemon("Charmander", 100, "Fire");
        assertFalse(charmander.knowsSkill()); // must be false upon creation.
        assertEquals("Charmander (Fire)", charmander.toString());

        Pokemon squirtle = new Pokemon("Squirtle", 120, "Water");
        assertFalse(squirtle.knowsSkill()); // must be false upon creation.
        assertEquals("Squirtle (Water)", squirtle.toString());
    }

    @Test
    public void shouldLearnSkills(){
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 150, "Grass");
        assertFalse(bulbasaur.knowsSkill()); // must be false upon creation.
        assertEquals("Bulbasaur (Grass)", bulbasaur.toString());

        bulbasaur.learnSkill("Razor Leaf", 20, 15);
        assertTrue(bulbasaur.knowsSkill());
        assertEquals("Bulbasaur (Grass). Knows Razor Leaf - AP: 20 EC: 15", bulbasaur.toString());

        Pokemon starmie = new Pokemon("Starmie", 80, "Water");
        assertFalse(starmie.knowsSkill());
        assertEquals("Starmie (Water)", starmie.toString());
        starmie.learnSkill("Surf", 40, 35);
        assertTrue(starmie.knowsSkill());
        assertEquals("Starmie (Water). Knows Surf - AP: 40 EC: 35", starmie.toString());
    }

    @Test
    public void shouldForgetSkill(){
        Pokemon oddish = new Pokemon("Oddish", 60, "Grass");
        assertFalse(oddish.knowsSkill());
        oddish.learnSkill("Mega Drain", 30, 20);
        assertTrue(oddish.knowsSkill());
        assertEquals("Oddish (Grass). Knows Mega Drain - AP: 30 EC: 20", oddish.toString());
        oddish.forgetSkill();
        assertFalse(oddish.knowsSkill());
        assertEquals("Oddish (Grass)", oddish.toString());
    }


}
