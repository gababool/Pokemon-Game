package assignment2;

import java.util.Objects;

public class Pokemon {

    private final String type;
    private final int MAX_HP;
    private final int MAX_EP;
    private final int FAINT_HP; // MAX HP FAINT HP MAX EP Skulle kunna vara static, iochmed att det finns en
                                // instants och vi ej kommer ändra det
    private String name;
    private int currentHP;
    private int energy;
    private boolean knowsSkill;
    private boolean isFainted;
    private Skill skill;

    public Pokemon(String name, int MAX_HP, String type) {
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.currentHP = MAX_HP;
        this.FAINT_HP = 0;
        this.MAX_EP = 100;
        this.energy = MAX_EP;
        this.type = type;
        this.skill = null;
        this.knowsSkill = false;
        this.isFainted = false;
    }

    @Override
    public String toString() {
        if (skill == null) {
            return String.format("%s (%s)", name, type);
        } else {
            return String.format("%s (%s). Knows %s - AP: %d EC: %d", name, type, skill.getName(), skill.getAP(),
                    skill.getEC());
        }
    }

    // For this part we had to use the internet to find out how to override the
    // equals and hashCode methods to make assertEquals() in the tests work.

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pokemon otherPokemon = (Pokemon) obj;
        return currentHP == otherPokemon.currentHP &&
                MAX_HP == otherPokemon.MAX_HP &&
                energy == otherPokemon.energy &&
                Objects.equals(name, otherPokemon.name) &&
                Objects.equals(type, otherPokemon.type) &&
                Objects.equals(skill, otherPokemon.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, skill, currentHP, MAX_HP, energy);
    }

    public void learnSkill(String skillName, int skillAP, int skillEC) {
        this.skill = new Skill(skillName, skillAP, skillEC);
        this.knowsSkill = true;
    }

    public void forgetSkill() {
        this.skill = null;
        this.knowsSkill = false;
    }

    public String attack(Pokemon defender) {
        if (skill == null) {
            return "Attack failed." + name + " does not know a skill.";
        } else if (skill.getEC() > energy) {
            return "Attack failed. " + name + " lacks energy: " + energy + "/" + skill.getEC();
        } else if (isFainted) {
            return "Attack failed. " + name + " fainted.";
        } else if (defender.isFainted()) {
            return "Attack failed. " + defender.getName() + " fainted.";
        } else {
            spendEP();
            String attackMsg = skill.useSkill(this, defender);
            return attackMsg;

        }
    }

    public String calcEffectiveness(Pokemon defender) {
        double multiplier = TypeEffectiveness.calculateMultiplier(type, defender.getType());
        String effectiveness = "";

        if (multiplier == 0.5) {
            effectiveness = "It is not very effective...";
        } else if (multiplier == 1) {
            return effectiveness;
        } else {
            effectiveness = "It is super effective!";
        }
        return effectiveness;
    }

    public String receiveDamage(int damage) {
        if (currentHP - damage < FAINT_HP) {
            currentHP = 0;
            isFainted = true;
            return name + " has 0 HP left. " + name + " faints.";
        } else {
            currentHP -= damage;
            return name + " has " + currentHP + " HP left.";
        }
    }

    public void spendEP() {
        int energyCost = skill.getEC();
        if (energy - energyCost < 0) {
            energy = 0;
        } else {
            energy -= energyCost;
        }
    }

    public void recoverEnergy() {
        int restoredEP = 25;
        if ((energy + restoredEP) > MAX_EP) {
            energy = MAX_EP;
        } else {
            energy += restoredEP;
        }
    }

    public void rest() {
        int restoredHP = 20;
        if (isFainted)
            return;
        if ((restoredHP + currentHP) > MAX_HP) {
            currentHP = MAX_HP;
        } else {
            currentHP += restoredHP;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getMAX_HP() {
        return MAX_HP;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getEnergy() {
        return energy;
    }

    public Skill getSkill() {
        return skill;
    }

    public boolean knowsSkill() {
        return knowsSkill;
    }

    public boolean isFainted() {
        return isFainted;
    }

}