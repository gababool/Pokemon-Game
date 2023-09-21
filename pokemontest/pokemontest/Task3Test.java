package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3Test {

    @Test
    public void shouldReceiveDamage(){
        Pokemon gyarados = new Pokemon("Gyarados", 100, "Water");
        gyarados.learnSkill("OP Hyper Beam", 100, 10); //Cheap EC so gyrados doesnt need to rest.

        Pokemon wigglytuff = new Pokemon("Wigglytuff", 120, "Normal");
        assertEquals(120, wigglytuff.getCurrentHP());
        wigglytuff.learnSkill("Double Slap", 40, 28);

        gyarados.attack(wigglytuff); //120 - 100 = 20.
        wigglytuff.attack(gyarados); //100 - 40 = 60

        assertEquals(120, wigglytuff.getMAX_HP());
        assertEquals(20, wigglytuff.getCurrentHP());

        assertEquals(100, gyarados.getMAX_HP());
        assertEquals(60, gyarados.getCurrentHP());
    }



    @Test
    public void shouldRest(){
        Pokemon gyarados = new Pokemon("Gyarados", 100, "Water");
        gyarados.learnSkill("OP Hyper Beam", 100, 10); //Cheap EC so gyrados doesnt need to rest.
        gyarados.rest();
        assertEquals(100, gyarados.getCurrentHP());

        Pokemon wigglytuff = new Pokemon("Wigglytuff", 120, "Normal");
        assertEquals(120, wigglytuff.getCurrentHP());
        wigglytuff.rest();
        assertEquals(120, wigglytuff.getCurrentHP());

        gyarados.attack(wigglytuff); //120 - 100 = 20.
        assertEquals(20, wigglytuff.getCurrentHP());
        wigglytuff.rest(); // 20 + 20 = 40
        wigglytuff.rest();
        wigglytuff.rest();
        assertEquals(80, wigglytuff.getCurrentHP());
    }

    @Test
    public void shouldNotRestFainted(){
        Pokemon gyarados = new Pokemon("Gyarados", 100, "Water");
        gyarados.learnSkill("OP Hyper Beam", 100, 10); //Cheap EC so gyrados doesnt need to rest.

        Pokemon wigglytuff = new Pokemon("Wigglytuff", 120, "Normal");
        assertEquals(120, wigglytuff.getCurrentHP());

        // attack twice to make wigglytuff faint.
        gyarados.attack(wigglytuff); //120 - 100 = 20.
        gyarados.attack(wigglytuff); // 20 - 100 = 0. Wigglytuff faints
        assertEquals(0, wigglytuff.getCurrentHP());
        wigglytuff.rest();
        assertEquals(0, wigglytuff.getCurrentHP());
    }

    @Test
    public void shouldSpendAndRecoverEP(){
        Pokemon rattata = new Pokemon("Rattata", 65, "Normal");

        Pokemon squirtle = new Pokemon("Squirtle", 100, "Water");
        squirtle.learnSkill("Acqua Pulse", 30, 28);
        assertEquals(100, squirtle.getEnergy());

        squirtle.attack(rattata);
        assertEquals(72, squirtle.getEnergy());
        squirtle.attack(rattata);
        squirtle.attack(rattata);
        assertEquals(16, squirtle.getEnergy());

        // This attack fails because rattata has fainted.
        squirtle.attack(rattata);
        assertEquals(16, squirtle.getEnergy());

        squirtle.recoverEnergy(); // 16 + 25 = 41
        squirtle.recoverEnergy();
        assertEquals(66, squirtle.getEnergy());
    }

    @Test
    public void shouldNeverExceedEPLimit(){
        Pokemon meowth = new Pokemon("Meowth", 75, "Normal");
        Pokemon shellder = new Pokemon("Shellder", 100, "Water");
        shellder.learnSkill("Bubblebeam", 40, 15);
        assertEquals(100, shellder.getEnergy());

        shellder.attack(meowth);
        assertEquals(85, shellder.getEnergy());
        shellder.recoverEnergy();
        assertEquals(100, shellder.getEnergy());
    }

    @Test
    public void shouldNotExceedMaxHP(){
        Pokemon meowth = new Pokemon("Meowth", 75, "Normal");
        Pokemon shellder = new Pokemon("Shellder", 100, "Water");
        shellder.learnSkill("Water gun", 30, 15);

        shellder.attack(meowth); // 75 - 30 = 45
        assertEquals(45, meowth.getCurrentHP());
        meowth.rest();
        assertEquals(65, meowth.getCurrentHP());
        meowth.rest();
        assertEquals(75, meowth.getCurrentHP());
    }
}
