package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {

    @Test
    public void shouldBeSuperEffective(){
        Pokemon starmie = new Pokemon("Starmie", 180, "Water");
        Pokemon vileplume = new Pokemon("Vileplume", 220, "Grass");
        Pokemon ninetales = new Pokemon("Ninetales", 155, "Fire");

        starmie.learnSkill("Surf", 55, 25);
        vileplume.learnSkill("Mega drain", 70, 40);
        ninetales.learnSkill("Flamethrower", 65, 30);

        starmie.attack(ninetales); // water is super effective
        ninetales.attack(vileplume);
        vileplume.attack(starmie);

        assertEquals(40, starmie.getCurrentHP());
        assertEquals(45, ninetales.getCurrentHP());
        assertEquals(90, vileplume.getCurrentHP());
    }

    @Test
    public void shouldNotBeEffective(){
        Pokemon starmie = new Pokemon("Starmie", 180, "Water");
        Pokemon vileplume = new Pokemon("Vileplume", 220, "Grass");
        Pokemon ninetales = new Pokemon("Ninetales", 155, "Fire");

        starmie.learnSkill("Surf", 55, 25);
        vileplume.learnSkill("Mega drain", 70, 40);
        ninetales.learnSkill("Flamethrower", 65, 30);

        starmie.attack(vileplume);
        ninetales.attack(starmie);
        vileplume.attack(ninetales);

        assertEquals(193, vileplume.getCurrentHP());
        assertEquals(120, ninetales.getCurrentHP());
        assertEquals(148, starmie.getCurrentHP());
    }

    @Test
    public void shouldBeNormalDamage(){
        Pokemon starmie = new Pokemon("Starmie", 180, "Water");
        Pokemon vileplume = new Pokemon("Vileplume", 220, "Grass");
        Pokemon ninetales = new Pokemon("Ninetales", 155, "Fire");
        Pokemon blissey = new Pokemon("Blissey", 500, "Normal");

        starmie.learnSkill("Surf", 55, 25);
        vileplume.learnSkill("Mega drain", 70, 40);
        ninetales.learnSkill("Flamethrower", 65, 30);
        blissey.learnSkill("Slam", 73, 20);

        starmie.attack(blissey);
        assertEquals(445, blissey.getCurrentHP());

        ninetales.attack(blissey);
        assertEquals(380, blissey.getCurrentHP());

        vileplume.attack(blissey);
        assertEquals(310, blissey.getCurrentHP());

        blissey.attack(ninetales);
        blissey.attack(starmie);
        blissey.attack(vileplume);

        assertEquals(107, starmie.getCurrentHP());
        assertEquals(147, vileplume.getCurrentHP());
        assertEquals(82, ninetales.getCurrentHP());
    }

    @Test
    public void shouldNotGoBelowZero(){
        Pokemon tangela = new Pokemon("Tangela", 160, "Grass");
        Pokemon starmie = new Pokemon("Starmie", 180, "Water");
        Pokemon vileplume = new Pokemon("Vileplume", 220, "Grass");
        Pokemon ninetales = new Pokemon("Ninetales", 155, "Fire");

        starmie.learnSkill("Hydro Pump", 110, 47);
        vileplume.learnSkill("Petal dance", 105, 40);
        ninetales.learnSkill("Fire Blast", 120, 50);
        tangela.learnSkill("Solar Beam", 100, 45);

        ninetales.attack(tangela);
        starmie.attack(ninetales);
        vileplume.attack(starmie);

        assertEquals(0, starmie.getCurrentHP());
        assertEquals(220, vileplume.getCurrentHP());
        assertEquals(0, ninetales.getCurrentHP());
        assertEquals(0, tangela.getCurrentHP());
    }

}
