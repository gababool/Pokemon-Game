
public class Main {

    public static void main(String[] args) {
        Pokemon mördarPoke = new Pokemon("Bulbasaur", 200, PokemonType.GRASS);
        Pokemon defender = new Pokemon("Squirtle", 200, PokemonType.NORMAL);
        Skill gräsSKill = new Skill("mördarLöv", 101, 40);
        mördarPoke.learnSkill(gräsSKill);
        mördarPoke.useSkill(defender);
        mördarPoke.useSkill(defender);
        mördarPoke.useSkill(defender);
    }
}
