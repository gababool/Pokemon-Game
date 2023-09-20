
public class Pokemon{
    
    private final PokemonType type;
    private final int MAX_HP;
    private final int MAX_EP;
    private String name;
    private int currentHP;
    private int energy;
    private boolean knowsSkill;
    private boolean isFainted;
    private Skill skill;
    
    Pokemon(String name, int MAX_HP, PokemonType type){
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.currentHP = MAX_HP;
        this.MAX_EP = 100;
        this.energy = MAX_EP;
        this.type = type;
        this.skill = null;
        this.knowsSkill = false;
        this.isFainted = false;
    }

    @Override
    public String toString(){
        if (skill == null){
            return String.format("%s (%s)%n", name, type);
        } else {
            return String.format("%s (%s). Knows %s AP: %d EC: %d%n", name, type, skill.getName(), skill.getAP(), skill.getEC());
        }
    }

    public void learnSkill(String skillName, int skillAP, int skillEC){
        this.skill = new Skill(skillName, skillAP, skillEC);
        this.knowsSkill = true;
    }

    public void forgetSkill(){
        this.skill = null;
        this.knowsSkill = false;
    }

    public void attack(Pokemon defender){
        if (skill == null){
            System.out.println("Attack failed." + name + " does not know a skill.");
        } 
        else if (skill.getEC() > energy){
            System.out.println("Attack failed. " + name + " lacks energy: " + energy + "/" + skill.getEC());
        }
        else if (isFainted){
            System.out.println("Attack failed. " + name + " fainted.");
        }
        else if (defender.isFainted()){
            System.out.println("Attack failed. " + defender.getName() + " fainted.");
        }
        else{
            skill.useSkill(this, defender);
        }
    }

    public String calcEffectiveness(Pokemon defender){
        double multiplier = TypeEffectiveness.calculateMultiplier(type, defender.getType());
        String effectiveness = "";
        
        if (multiplier == 0.5){
            effectiveness = "It is not very effective...";
        } else if (multiplier == 1){
            return effectiveness;
        } else {
            effectiveness = "It is super effective!";
        }
       return effectiveness;
    }

    public String receiveDamage(int damage){
        if(currentHP - damage < 0){
            currentHP = 0;
            isFainted = true;
            return name + " faints.";
        } else {
            currentHP  -= damage;
            return name + " has " + currentHP + " HP left.";
        }
    }

    public void spendEP(){
        int energyCost = skill.getEC();
        if(energy - energyCost < 0){
            energy = 0;
        } else {
            energy  -= energyCost;
        }
    }

    public void recoverEP(){
        int restoredEP = 25;
        if((energy + restoredEP) > MAX_EP){
            energy = MAX_EP;
        } else {
            energy  += restoredEP;
        }
    }

    public void rest(){
        int restoredHP = 20;
        if(!isFainted){
           if ((restoredHP + currentHP) > MAX_HP){
            currentHP = MAX_HP;
            }
            else {
                currentHP += restoredHP;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
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

    public Skill getSkill(){
        return skill;
    }

    public boolean knowsSkill() {
        return knowsSkill;
    }

    public boolean isFainted() {
        return isFainted;
    }


}