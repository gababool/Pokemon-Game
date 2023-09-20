
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

    public void use(){
        
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
