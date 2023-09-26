package assignment2;

public class TypeEffectiveness {

    public static double calculateMultiplier(PokemonType attacker, PokemonType defender) {
        double multiplier = 1.0;

        switch (attacker) {
            case FIRE:
                switch (defender) {
                    case FIRE:
                        multiplier = 0.5;
                        break;
                    case GRASS:
                        multiplier = 2.0;
                        break;
                    case WATER:
                        multiplier = 0.5;
                        break;
                    default:
                        break;
                }
                break;
            case WATER:
                switch (defender) {
                    case FIRE:
                        multiplier = 2.0;
                        break;
                    case GRASS:
                        multiplier = 0.5;
                        break;
                    case WATER:
                        multiplier = 0.5;
                        break;
                    default:
                        break;
                }
                break;
            case GRASS:
                switch (defender) {
                    case FIRE:
                        multiplier = 0.5;
                        break;
                    case GRASS:
                        multiplier = 0.5;
                        break;
                    case WATER:
                        multiplier = 2.0;
                        break;
                    default:
                        break;

                }
                break;
            case NORMAL:
                break;

        }
        return multiplier;
    }

    public static String generateEffectivenessMsg(double multiplier) {
        String effectiveness = "";
        if (multiplier == 0.5) {
            effectiveness = " It is not very effective...";
        } else if (multiplier == 2.0) {
            effectiveness = " It is super effective!";
        } 
        return effectiveness;

    }

}
