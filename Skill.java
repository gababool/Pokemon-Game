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

    public double use(Pokemon attacker, Pokemon defender){
        PokemonType attackerType = attacker.getType();
        PokemonType defenderType = defender.getType();
        double damage = AP * TypeEffectiveness.calculateMultiplier(attackerType, defenderType);
        damage = (int)Math.round(damage);
        return damage;
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
