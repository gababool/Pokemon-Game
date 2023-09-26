package assignment2;

public class TypeEffectiveness {

    final static private double SUPER_EFFECTIVE = 2.0; 
    final static private double NOT_VERY_EFFECTIVE = 0.5;
    final static private double NORMAL_EFFECTIVENESS = 1.0;
    

    public static double calculateMultiplier(String attacker, String defender) {
        switch (attacker) {
            case "Water":
                return calculateWaterMultiplier(defender);
            case "Fire":
                return calculateFireMultiplier(defender);
            case "Grass":
                return calculateGrassMultiplier(defender);
            case "Bug":
                return calculateBugMultiplier(defender);
            case "Electric":
                return calculateElectricMultiplier(defender);
            case "Dragon":
                return calculateDragonMultiplier(defender);    
            case "Ice":
                return calculateIceMultiplier(defender);
        }
        return NORMAL_EFFECTIVENESS;
    }

    private static double calculateFireMultiplier(String defender) {
        switch (defender) {
            case "Fire":
            case "Water":
            case "Dragon":
                return NOT_VERY_EFFECTIVE;
            case "Grass":
            case "Bug":
            case "Ice":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateGrassMultiplier(String defender){
            switch (defender){
                case "Fire":
                case "Grass":
                case "Dragon":
                case "Bug":
                    return NOT_VERY_EFFECTIVE;
                case "Water":
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }
    
    private static double calculateIceMultiplier(String defender){
            switch (defender){
                case "Fire":
                case "Ice":
                case "Water":
                    return NOT_VERY_EFFECTIVE;
                case "Grass":
                case "Dragon":
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateWaterMultiplier(String defender){
            switch (defender){
                case "Grass":
                case "Dragon":
                case "Water":
                    return NOT_VERY_EFFECTIVE;
                case "Fire":
                    return SUPER_EFFECTIVE;
                default:
                    return NORMAL_EFFECTIVENESS;
        }
    }

    private static double calculateBugMultiplier(String defender){
        switch (defender){
            case "Fire":
                return NOT_VERY_EFFECTIVE;
            case "Grass":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }

    private static double calculateDragonMultiplier(String defender){
        switch (defender){
            case "Dragon":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }
    private static double calculateElectricMultiplier(String defender){
        switch (defender){
            case "Grass":
            case "Electric":
            case "Dragon":
                return NOT_VERY_EFFECTIVE;
            case "Water":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }

public static String generateEffectivenessMsg(double multiplier) {
    String effectiveness = "";
    if (multiplier == NOT_VERY_EFFECTIVE) {
        effectiveness = " It is not very effective...";
    } else if (multiplier == SUPER_EFFECTIVE) {
        effectiveness = " It is super effective!";
    }
    return effectiveness;

}

}
