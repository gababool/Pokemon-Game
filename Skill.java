import java.lang.Math;
public class Skill {

    final private String name;
    final private int AP;
    final private int EC;

    Skill(String name, int AP, int EC){
        this.name = name;
        this.AP = AP;
        this.EC = EC;
    }

    public String toString(){
        return String.format("%s - AP: %s EC: %s%n", name, AP, EC);   
    }

    public void attack(Pokemon attacker, Pokemon defender){
        double multiplier = TypeEffectiveness.calculateMultiplier(attacker.getType(), defender.getType());
        double damage = AP * multiplier;
        String attackMsg = defender.receiveDamage((int)Math.round(damage));
        String effectivenessMsg = TypeEffectiveness.calculteEffectiveness(multiplier);
        System.out.printf("%s uses %s on %s. %s %s%n", attacker.getName(), name, defender.getName(), effectivenessMsg, attackMsg);
    }

    public String getName(){
        return name;
    }

    public int getAP() {
        return AP;
    }

    public int getEC() {
        return EC;
    }
}
