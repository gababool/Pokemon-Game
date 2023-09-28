package assignment2;

public class Pokemon {

    private final PokemonType TYPE;
    private final int MAX_HP;
    private final int MAX_EP = 100;
    private final int FAINT_HP = 0;
    private final int LOWEST_EP = 0;
    private final int RESTORED_EP = 25;
    private final int REST_HP = 20;

    private String name;
    private int currentHP;
    private int energy;
    private boolean knowsSkill;
    private Skill skill;

    public Pokemon(String name, int MAX_HP, String type) {
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.currentHP = MAX_HP;
        this.energy = MAX_EP;
        this.TYPE = PokemonType.fromString(type);
        this.skill = null;
        this.knowsSkill = false;
    }

    @Override
    public String toString() {
        if (skill == null) {
            return String.format("%s (%s)", name, TYPE);
        } else {
            return String.format("%s (%s). Knows %s - AP: %d EC: %d", 
            name, TYPE, skill.getName(), skill.getAP(),skill.getEC());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Pokemon otherPokemon = (Pokemon) obj;
        boolean sameName = name == otherPokemon.getName();
        boolean samePower = getPokemonType() == otherPokemon.getPokemonType();
        boolean sameSkill = skill == otherPokemon.getSkill();
        boolean sameCurrentHP = currentHP == otherPokemon.getCurrentHP();
        boolean sameMAX_HP = MAX_HP == otherPokemon.getMAX_HP();
        boolean sameEnergy = energy == otherPokemon.getEnergy();

        return (sameName && samePower && sameSkill && sameCurrentHP && sameMAX_HP && sameEnergy);
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
        String attackResult = "";
        if (skill == null) {
            attackResult += "Attack failed." + name + " does not know a skill.";

        } else if (skill.getEC() > energy) {
            attackResult += "Attack failed. " + name + " lacks energy: " + energy + "/" + skill.getEC();

        } else if (currentHP == FAINT_HP) {
            attackResult += "Attack failed. " + name + " fainted.";

        } else if (defender.getCurrentHP() == FAINT_HP) {
            attackResult += "Attack failed. " + defender.getName() + " fainted.";

        } else {
            spendEP();

            double multiplier = TypeEffectiveness.calculateMultiplier(TYPE, defender.getPokemonType());
            double damage = (skill.getAP() * multiplier);
            String skillMsg = skill.useSkill(this, defender);
            String effectivenessMsg = TypeEffectiveness.generateEffectivenessMsg(multiplier);
            String damageMsg = defender.receiveDamage((int) damage);
            
            attackResult += skillMsg + effectivenessMsg + damageMsg;
        }
        return attackResult;
    }

    private String receiveDamage(double damage) {
        if (currentHP - damage <= FAINT_HP) {
            currentHP = FAINT_HP;
            return String.format("%n%s has %d HP left. %s faints.", name, currentHP, name);
        } else {
            currentHP -= damage;
            return String.format("%n%s has %d HP left.", name, currentHP);
        }
    }

    private void spendEP() {
        int energyCost = skill.getEC();
        if (energy - energyCost < LOWEST_EP) {
            energy = LOWEST_EP;
        } else {
            energy -= energyCost;
        }
    }

    public void recoverEnergy() {
        if ((energy + RESTORED_EP) > MAX_EP) {
            energy = MAX_EP;
        } else {
            energy += RESTORED_EP;
        }
    }

    public void rest() {
        if (currentHP == FAINT_HP) {
            return;
        }
        heal(REST_HP);
    }

    public String useItem(Item item) {
        int itemPower = item.getPowerValue();
        String itemName = item.getName();
        int healedHp = heal(itemPower);
        String pokemonName = getName();
        if (healedHp == 0) {
            return String.format("%s could not use %s. HP is already full.", pokemonName, itemName);
        }
        return String.format("%s used %s. It healed %d HP.", pokemonName, itemName, healedHp);
    }

    private int heal(int hp) {
        int newHp = this.currentHP + hp;
        if (newHp > this.MAX_HP) {
            int healed = this.MAX_HP - this.currentHP;
            this.currentHP = this.MAX_HP;
            return healed;
        } else {
            int healed = newHp - this.currentHP;
            this.currentHP = newHp;
            return healed;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return TYPE.toString();
    }

    public PokemonType getPokemonType() {
        return TYPE;
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
}