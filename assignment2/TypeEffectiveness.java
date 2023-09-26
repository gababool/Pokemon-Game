package assignment2;

public class TypeEffectiveness {

    final static private double SUPER_EFFECTIVE = 2.0; 
    final static private double NOT_VERY_EFFECTIVE = 0.5;
    final static private double NORMAL_EFFECTIVENESS = 1.0;
    

    public static double calculateMultiplier(String attackerType, String defenderType) {
        switch (attackerType) {
            case "Water":
                return calculateWaterMultiplier(defenderType);
            case "Fire":
                return calculateFireMultiplier(defenderType);
            case "Grass":
                return calculateGrassMultiplier(defenderType);
            case "Bug":
                return calculateBugMultiplier(defenderType);
            case "Electric":
                return calculateElectricMultiplier(defenderType);
            case "Dragon":
                return calculateDragonMultiplier(defenderType);    
            case "Ice":
                return calculateIceMultiplier(defenderType);
        }
        return NORMAL_EFFECTIVENESS;
    }

    private static double calculateFireMultiplier(String defenderType) {
        switch (defenderType) {
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

    private static double calculateGrassMultiplier(String defenderType){
            switch (defenderType){
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
    
    private static double calculateIceMultiplier(String defenderType){
            switch (defenderType){
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

    private static double calculateWaterMultiplier(String defenderType){
            switch (defenderType){
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

    private static double calculateBugMultiplier(String defenderType){
        switch (defenderType){
            case "Fire":
                return NOT_VERY_EFFECTIVE;
            case "Grass":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }

    private static double calculateDragonMultiplier(String defenderType){
        switch (defenderType){
            case "Dragon":
                return SUPER_EFFECTIVE;
            default:
                return NORMAL_EFFECTIVENESS;
        } 
    }
    private static double calculateElectricMultiplier(String defenderType){
        switch (defenderType){
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
        effectiveness += " It is not very effective...";
    } else if (multiplier == SUPER_EFFECTIVE) {
        effectiveness += " It is super effective!";
    }
    return effectiveness;

}

}
