package assignment2;

import java.util.Objects;

public class Skill {

    final private String skillName;
    final private int AP;
    final private int EC;

    Skill(String skillName, int AP, int EC){
        this.skillName = skillName;
        this.AP = AP;
        this.EC = EC;
    }

    @Override
    public String toString(){
        return String.format("%s - AP: %s EC: %s%n", skillName, AP, EC);   
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Skill otherSkill = (Skill)obj;
        
        boolean sameName = this.skillName == otherSkill.getName();
        boolean sameAP = this.AP == otherSkill.getAP();
        boolean sameEC = this.EC == otherSkill.getEC();

        return (sameName && sameAP && sameEC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillName, AP, EC);
    }

    public String useSkill(Pokemon attacker, Pokemon defender){
        double multiplier = TypeEffectiveness.calculateMultiplier(attacker.getType(), defender.getType());
        String damageReceivedString = defender.receiveDamage((int)(AP * multiplier));
        String effectivenessString = TypeEffectiveness.generateEffectivenessMsg(multiplier);
        
        return String.format("%s uses %s on %s.%s%n%s", 
        attacker.getName(), skillName, defender.getName(), effectivenessString, damageReceivedString);
    }

    public String getName(){
        return skillName;
    }

    public int getAP() {
        return AP;
    }

    public int getEC() {
        return EC;
    }
}
