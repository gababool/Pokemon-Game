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
        throw new IllegalArgumentException("No PokemonType with name " + typeName + " found");
        // Alternatively you could return null instead, but we are unsure wheter that breaks the rules from
        // the instructions since that would mean that a Pokemon could be created without a type.
    }
}
