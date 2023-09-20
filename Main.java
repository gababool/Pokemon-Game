
public class Main {
    
    public static void main(String[] args) {
        Pokemon poke = new Pokemon("Squirtle", 45, PokemonType.WATER);
        System.out.println(poke);
        Skill skill = new Skill("WaterGun", 50, 30);
        poke.learnSkill(skill);
        System.out.println(poke);
    }
}
