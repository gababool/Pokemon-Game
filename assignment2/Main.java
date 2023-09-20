package assignment2;

public class Main {

    public static void main(String[] args) {
        Pokemon attacker = new Pokemon("Bulbasaur", 200, "Grass");
        Pokemon defender = new Pokemon("Squirtle", 200, "Water");
        attacker.learnSkill("Leaf Slash", 30, 40);
        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender);
        attacker.attack(defender); 

    }
}
