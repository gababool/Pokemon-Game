
public class Main {

    public static void main(String[] args) {
        Pokemon attacker = new Pokemon("Bulbasaur", 200, PokemonType.GRASS);
        Pokemon defender = new Pokemon("Squirtle", 200, PokemonType.WATER);
        Skill leafSlash = new Skill("Leaf Slash", 30, 40);
        attacker.learnSkill(leafSlash);
        attacker.useSkill(defender);
        attacker.useSkill(defender);
        attacker.useSkill(defender);
        attacker.useSkill(defender);
        attacker.useSkill(defender);

    }
}
