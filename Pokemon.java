
public class Pokemon{
    
    String name;
    final int MAX_HP;
    int HP;
    int EP;
    PokemonType type;
    Skill skill;
    
    Pokemon(String name, int MAX_HP, PokemonType type){
        this.name = name;
        this.MAX_HP = MAX_HP;
        this.HP = MAX_HP;
        this.EP = 100;
        this.type = type;
        this.skill = null;
    }

     public void useSkill(){
        skill.use();
    }


}