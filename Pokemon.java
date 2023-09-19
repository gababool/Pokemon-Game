
public class Pokemon{
    
    private final PokemonType type;
    private final int MAX_HP;
    private String name;
    private int HP;
    private int EP;
    
    Skill skill;
    
    Pokemon(String name, int MAX_HP, PokemonType type){
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.HP = MAX_HP;
        this.EP = 100;
        this.type = type;
        this.skill = null;
    }

    @Override
    public String toString(){
        if (skill == null){
            return String.format("%s (%s)%n", name, type);
        } else {
            return String.format("%s (%s) Knows %s AP: %d EC: %d%n", name, type, skill, skill.getAP(), skill.getEC());
        }
    }

    // Setters 

     public void setName(String name) {
        this.name = name;
    }


    // Getters 

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


    // Skills

    public void useSkill(){
        if (skill == null){
            System.out.println(name + " has not yet learned any skill");
        }
        skill.use();
    }


}