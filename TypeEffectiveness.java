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
                        multiplier= 2.0;
                        break;
                    case WATER:
                        multiplier= 0.5;
                        break;
                    default:
                        break;
                }
            case WATER:
                switch (defender) {
                        case FIRE:
                            multiplier= 2.0;
                            break;
                        case GRASS:
                            multiplier= 0.5;
                            break;
                        case WATER:
                            multiplier= 0.5;
                            break;
                        default:
                            break;
                }
            case GRASS:
                switch (defender) {
                        case FIRE:
                            multiplier= 0.5;
                            break;
                        case GRASS:
                            multiplier= 0.5;
                            break;
                        case WATER:
                            multiplier= 2.0;
                            break;
                        default:
                            break;
                        
                }
            case NORMAL:
                break;
            
        
        }
        return multiplier;
    }

    public static void calculteEffectiveness(double multiplier){
        if (multiplier == 0.5){
            System.out.print(" It is not very effective...");
        } else if (multiplier == 2.0){
            System.out.print(" It is super effective!");
        }
    }

}
