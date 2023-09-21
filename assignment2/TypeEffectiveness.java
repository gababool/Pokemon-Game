package assignment2;

public class TypeEffectiveness {

    public static double calculateMultiplier(String attacker, String defender) {
        double multiplier = 1.0;

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
