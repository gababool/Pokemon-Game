
public class Main {

    public static void main(String[] args) {
        Pokemon mördarPoke = new Pokemon("Bulbasaur", 60, PokemonType.GRASS);
        System.out.println(mördarPoke);
        Skill gräsSKill = new Skill("mördarLöv", 70, 40);
        mördarPoke.learnSkill(gräsSKill);
        System.out.println(mördarPoke);
    }
}
