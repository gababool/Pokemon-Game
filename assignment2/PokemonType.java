package assignment2;

public enum PokemonType {
    WATER("Water"),
    FIRE("Fire"),
    GRASS("Grass"),
    NORMAL("Normal");

    String type;

    private PokemonType(String type) {
        this.type = type;
    }
}
