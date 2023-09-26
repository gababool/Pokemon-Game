package assignment2;

public enum PokemonType {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal");

    private final String type;

    private PokemonType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    
}
