package pokemontest;

import assignment2.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    // Gets the corresponding end of line character from the system and
    //  stores it in a constant.
    private static String END_OF_LINE = System.lineSeparator();

    @Test
    public void shouldBeRegularAttack(){
        String expectedPoryAttack = "Porygon uses Hyper beam on Wigglytuff." + END_OF_LINE +
                                     "Wigglytuff has 130 HP left.";

        String expectedWigglyAttack = "Wigglytuff uses Double slap on Porygon." + END_OF_LINE +
                                  "Porygon has 45 HP left.";

        Pokemon wigglytuff = new Pokemon("Wigglytuff",230,"Normal");
        wigglytuff.learnSkill("Double slap", 75, 35);

        Pokemon porygon = new Pokemon("Porygon", 120, "Normal");
        porygon.learnSkill("Hyper beam", 100, 50);

        assertEquals(expectedPoryAttack, porygon.attack(wigglytuff));
        assertEquals(expectedWigglyAttack, wigglytuff.attack(porygon));

        assertEquals(65, wigglytuff.getEnergy());
        assertEquals(130, wigglytuff.getCurrentHP());
        assertEquals(50, porygon.getEnergy());
        assertEquals(45, porygon.getCurrentHP());
    }

    @Test
    public void shouldPrintJustFainted(){
        String expectedPoryAttack = "Porygon uses Hyper beam on Wigglytuff." + END_OF_LINE +
                                      "Wigglytuff has 30 HP left.";

        String expectedPoryAttack2 = "Porygon uses Hyper beam on Wigglytuff." + END_OF_LINE +
                                     "Wigglytuff has 0 HP left. Wigglytuff faints.";

        String expectedWigglyAttack = "Wigglytuff uses Slam on Porygon." + END_OF_LINE +
                                      "Porygon has 60 HP left.";

        Pokemon wigglytuff = new Pokemon("Wigglytuff",130,"Normal");
        wigglytuff.learnSkill("Slam", 60, 35);

        Pokemon porygon = new Pokemon("Porygon", 120, "Normal");
        porygon.learnSkill("Hyper beam", 100, 50);

        assertEquals(expectedPoryAttack, porygon.attack(wigglytuff));
        assertEquals(expectedWigglyAttack, wigglytuff.attack(porygon));
        assertEquals(expectedPoryAttack2, porygon.attack(wigglytuff));
    }

    @Test
    public void shouldBeSuperEffective(){
        String resultVaporeonAtt = "Vaporeon uses Surf on Arcanine. It is super effective!" + END_OF_LINE +
                                   "Arcanine has 40 HP left.";

        String resultArcanineAtt = "Arcanine uses Flamethrower on Victreebel. It is super effective!" + END_OF_LINE +
                                    "Victreebel has 50 HP left.";

        String resultVictreeAtt = "Victreebel uses Razor leaf on Vaporeon. It is super effective!" + END_OF_LINE +
                                      "Vaporeon has 10 HP left.";

        Pokemon arcanine = new Pokemon("Arcanine",150,"Fire");
        arcanine.learnSkill("Flamethrower", 60, 25);

        Pokemon vaporeon = new Pokemon("Vaporeon", 130, "Water");
        vaporeon.learnSkill("Surf", 55, 30);

        Pokemon victreebel = new Pokemon("Victreebel", 170, "Grass");
        victreebel.learnSkill("Razor leaf", 60, 30);

        assertEquals(resultArcanineAtt, arcanine.attack(victreebel));
        assertEquals(resultVaporeonAtt, vaporeon.attack(arcanine));
        assertEquals(resultVictreeAtt, victreebel.attack(vaporeon));

        String resultVictreebelFaints = "Arcanine uses Flamethrower on Victreebel. It is super effective!" + END_OF_LINE +
                                        "Victreebel has 0 HP left. Victreebel faints.";
        String resultArcanineFaints   = "Vaporeon uses Surf on Arcanine. It is super effective!" + END_OF_LINE +
                                         "Arcanine has 0 HP left. Arcanine faints.";
        assertEquals(resultVictreebelFaints, arcanine.attack(victreebel));
        assertEquals(resultArcanineFaints, vaporeon.attack(arcanine));
    }

    @Test
    public void shouldNotBeEffective(){
        String resultVaporeonAtt = "Vaporeon uses Surf on Victreebel. It is not very effective..." + END_OF_LINE +
                                   "Victreebel has 143 HP left.";

        String resultArcanineAtt = "Arcanine uses Flamethrower on Vaporeon. It is not very effective..." + END_OF_LINE +
                                   "Vaporeon has 100 HP left.";

        String resultVictreeAtt = "Victreebel uses Razor leaf on Arcanine. It is not very effective..." + END_OF_LINE +
                                  "Arcanine has 120 HP left.";

        Pokemon arcanine = new Pokemon("Arcanine",150,"Fire");
        arcanine.learnSkill("Flamethrower", 60, 25);

        Pokemon vaporeon = new Pokemon("Vaporeon", 130, "Water");
        vaporeon.learnSkill("Surf", 55, 30);

        Pokemon victreebel = new Pokemon("Victreebel", 170, "Grass");
        victreebel.learnSkill("Razor leaf", 60, 30);

        assertEquals(resultArcanineAtt, arcanine.attack(vaporeon));
        assertEquals(resultVaporeonAtt, vaporeon.attack(victreebel));
        assertEquals(resultVictreeAtt, victreebel.attack(arcanine));

        String resultMagikarpFaint = "Arcanine uses Flamethrower on Magikarp. It is not very effective..." + END_OF_LINE +
                                     "Magikarp has 0 HP left. Magikarp faints.";

        Pokemon magikarp = new Pokemon("Magikarp", 25, "Water");
        assertEquals(resultMagikarpFaint,  arcanine.attack(magikarp));
    }

}
