package assignment2;

public class TypeEffectiveness {

    final static private double SUPER_EFFECTIVE = 2.0; 
    final static private double NOT_VERY_EFFECTIVE = 0.5;
    final static private double NORMAL_EFFECTIVENESS = 1.0;
    

    public static double calculateMultiplier(PokemonType attackerType, PokemonType defenderType) {
        switch (attackerType) {
            case WATER:
                return calculateWaterMultiplier(defenderType);
            case FIRE:
                return calculateFireMultiplier(defenderType);
            case GRASS:
                return calculateGrassMultiplier(defenderType);
            case BUG:
                return calculateBugMultiplier(defenderType);
            case ELECTRIC:
                return calculateElectricMultiplier(defenderType);
            case DRAGON:
                return calculateDragonMultiplier(defenderType);    
            case ICE:
                return calculateIceMultiplier(defenderType);
            default:
                return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateFireMultiplier(PokemonType defenderType) {
        switch (defenderType) {
            case FIRE:
            case WATER:
            case DRAGON:
                return NOT_VERY_EFFECTIVE;
            case GRASS:
            case BUG:
            case ICE:
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateGrassMultiplier(PokemonType defenderType){
            switch (defenderType){
                case FIRE:
                case GRASS:
                case DRAGON:
                case BUG:
                    return NOT_VERY_EFFECTIVE;
                case WATER:
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }
    
    private static double calculateIceMultiplier(PokemonType defenderType){
            switch (defenderType){
                case FIRE:
                case ICE:
                case WATER:
                    return NOT_VERY_EFFECTIVE;
                case GRASS:
                case DRAGON:
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateWaterMultiplier(PokemonType defenderType){
            switch (defenderType){
                case GRASS:
                case DRAGON:
                case WATER:
                    return NOT_VERY_EFFECTIVE;
                case FIRE:
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateBugMultiplier(PokemonType defenderType){
        switch (defenderType){
            case FIRE:
                return NOT_VERY_EFFECTIVE;
            case GRASS:
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }

    private static double calculateDragonMultiplier(PokemonType defenderType){
        switch (defenderType){
            case DRAGON:
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }
    private static double calculateElectricMultiplier(PokemonType defenderType){
        switch (defenderType){
            case GRASS:
            case ELECTRIC:
            case DRAGON:
                return NOT_VERY_EFFECTIVE;
            case WATER:
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }

public static String generateEffectivenessMsg(double multiplier) {
    String effectiveness = "";
    if (multiplier == NOT_VERY_EFFECTIVE) {
        effectiveness += " It is not very effective...";
    } else if (multiplier == SUPER_EFFECTIVE) {
        effectiveness += " It is super effective!";
    }
    return effectiveness;

}

}
