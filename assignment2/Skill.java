package assignment2;

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

    public String useSkill(Pokemon attacker, Pokemon defender){
        return String.format("%s uses %s on %s.", attacker.getName(), skillName, defender.getName());
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
