package assignment2;

public class TypeEffectiveness {

    public static double calculateMultiplier(String attacker, String defender) {
        double multiplier = 1.0;
        switch (attacker) {
            case "Water":
                multiplier = calculateWaterMultiplier(defender);
                break;
            case "Fire":
                multiplier = calculateFireMultiplier(defender);
                break;
            case "Grass":
                multiplier = calculateGrassMultiplier(defender);
                break;
            case "Bug":
                multiplier = calculateBugMultiplier(defender);
                break;
            case "Electric":
                multiplier = calculateElectricMultiplier(defender);
                break;
            case "Dragon":
                multiplier = calculateDragonMultiplier(defender);
                break;
            case "Ice":
                multiplier = calculateIceMultiplier(defender);
                break;
        }
        return multiplier;
    }

    private static double calculateFireMultiplier(String defender) {
        switch (defender) {
            case "Fire":
                return 0.5;
            case "Grass":
                return 2.0;
            case "Water":
                return 0.5;
            case "Dragon":
                return 0.5;
            case "Bug":
                return 2.0;
            case "Ice":
                return 2.0;
            default:
                return 1.0;
        }
    }

    private static double calculateGrassMultiplier(String defender){
            switch (defender){
                case "Fire":
                    return 0.5;
                case "Grass":
                    return 0.5;
                case "Water":
                    return 2.0;
                case "Dragon":
                    return 0.5;
                case "Bug":
                    return 0.5;
                default:
                    return 1.0;
        }
    }
    
    private static double calculateIceMultiplier(String defender){
            switch (defender){
                case "Fire":
                    return 0.5;
                case "Grass":
                    return 2.0;
                case "Water":
                    return 0.5;
                case "Dragon":
                    return 2.0;
                case "Ice":
                    return 0.5;
                default:
                    return 1.0;
        }
    }

    private static double calculateWaterMultiplier(String defender){
            switch (defender){
                case "Fire":
                    return 2.0;
                case "Grass":
                    return 0.5;
                case "Water":
                    return 0.5;
                case "Dragon":
                    return 0.5;
                default:
                    return 1.0;
        }
    }

    private static double calculateBugMultiplier(String defender){
        switch (defender){
            case "Fire":
                return 0.5;
            case "Grass":
                return 2.0;
            default:
                return 1.0;
        } 
    }

    private static double calculateDragonMultiplier(String defender){
        switch (defender){
            case "Dragon":
                return 2.0;
            default:
                return 1.0;
        } 
    }
private static double calculateElectricMultiplier(String defender){
            switch (defender){
                case "Grass":
                    return 0.5;
                case "Water":
                    return 2.0;
                case "Dragon":
                    return 0.5;
                case "Electric":
                    return 0.5;
                default:
                    return 1.0;
            } 

        }


/*
        switch (attacker) {
            case "Fire":
                switch (defender) { 
                    case "Fire":
                        multiplier = 0.5;
                        break;
                    case "Grass":
                        multiplier = 2.0;
                        break;
                    case "Water":
                        multiplier = 0.5;
                        break;
                    default:
                        break;
                }
                break;
            case "Water":
                switch (defender) {
                    case "Fire":
                        multiplier = 2.0;
                        break;
                    case "Grass":
                        multiplier = 0.5;
                        break;
                    case "Water":
                        multiplier = 0.5;
                        break;
                    default:
                        break;
                }
                break;
            case "Grass":
                switch (defender) {
                    case "Fire":
                        multiplier = 0.5;
                        break;
                    case "Grass":
                        multiplier = 0.5;
                        break;
                    case "Water":
                        multiplier = 2.0;
                        break;
                    default:
                        break;

                }
                break;
            case "Normal":
                break;

        }
        return multiplier;
    }
*/
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
