package Pokemon;

import Skills.Skill;

public abstract class Pokemon{
    
    private String name;
    final private int MAX_HP;
    private int HP;
    private int EP;
    private PokemonType type;
    private Skill skill;
    
    Pokemon(String name, int MAX_HP, PokemonType type){
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.HP = MAX_HP;
        this.EP = 100;
        this.type = type;
        this.skill = null;
    }

    // Getter methods

    public int getMAX_HP() {
        return MAX_HP;
    }

    public int getEP() {
        return EP;
    }

    public PokemonType getType() {
        return type;
    }

    public Skill getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    // Skill methods

     public void useSkill(){
        skill.use();
    }


}