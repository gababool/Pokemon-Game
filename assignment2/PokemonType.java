package assignment2;

public enum PokemonType {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal"),
    BUG("Bug"),
    ELECTRIC("Electric"),
    DRAGON("Dragon"),
    ICE("Ice");

    final String TYPE;

    PokemonType(String typeName) {
        this.TYPE = typeName;
    }

    public String toString() {
        return TYPE;
    }

    public static PokemonType fromString(String typeName) {
        for (PokemonType type : PokemonType.values()) {
            if (type.TYPE.equalsIgnoreCase(typeName)) {
                return type;
            }  
        } 
        return null;
        // Ideally you would want to throw an exception here if the Pokémon type doesn't exist, but we 
        // chose to return null for this assignment since we assume arguments are valid.
    }
}
