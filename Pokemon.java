
public class Pokemon{
    
    private final PokemonType type;
    private final int MAX_HP;
    private String name;
    private int HP;
    private int EP;
    private boolean knowsSkill;
    private boolean isFainted;
    
    Skill skill;
    
    Pokemon(String name, int MAX_HP, PokemonType type){
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.HP = MAX_HP;
        this.EP = 100;
        this.type = type;
        this.skill = null;
        this.knowsSkill = false;
        this.isFainted = false;
    }

    public String toString(){
        
        if (skill == null){
            return String.format("%s (%s)%n", name, type);
        } else {
            return String.format("%s (%s). Knows %s AP: %d EC: %d%n", name, type, skill.getName(), skill.getAP(), skill.getEC());
        }
    }

     public void setName(String name) {
        this.name = name;
    }

    public void learnSkill(Skill newSkill){
        this.skill = newSkill;
        this.knowsSkill = true;
    }

    public void forgetSkill(){
        this.skill = null;
        this.knowsSkill = false;
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

    public int getHP() {
        return HP;
    }

    public int getEP() {
        return EP;
    }

    public boolean KnowsSkill() {
        return knowsSkill;
    }

    public boolean isFainted() {
        return isFainted;
    }

    public void useSkill(Pokemon defender){
        if (skill == null){
            System.out.println(name + " has not yet learned any skill");
        } else{
            skill.use(this, defender);
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


    public void recieveDamage(int damage){
        
        if(HP - damage < 0){
            HP = 0;
        } else {
            HP  -= damage;
        }
    }


}