package Modeles;

public enum Types {
    EAU,FEU,SOL,PSY,PLANTE,ROCHE,TENEBRES,GLACE,FEE,ACIER,COMBAT,SPECTRE,POISON,INSECTE,DRAGON,ELECTRIQUE,NORMAL,VOL ;

    public static Types getType(int type) {
        return switch (type) {
            case 1 -> EAU;
            case 2 -> FEU;
            case 3 -> PLANTE;
            case 4 -> INSECTE;
            case 5 -> GLACE;
            case 6 -> PSY;
            case 7 -> TENEBRES;
            case 8 -> NORMAL;
            case 9 -> ACIER;
            case 10 -> ROCHE;
            case 11 -> SOL;
            case 12 -> COMBAT;
            case 13 -> ELECTRIQUE;
            case 14 -> VOL;
            case 15 -> SPECTRE;
            case 16 -> DRAGON;
            case 17 -> POISON;
            default -> null;
        };
    }
    
    public static Types getType(String nom) {
        return switch (nom) {
            case "EAU" -> EAU;
            case "FEU" -> FEU;
            case "PLANTE" -> PLANTE;
            case "INSECTE" -> INSECTE;
            case "GLACE" -> GLACE;
            case "PSY" -> PSY;
            case "TENEBRES" -> TENEBRES;
            case "NORMAL" -> NORMAL;
            case "ACIER" -> ACIER;
            case "ROCHE" -> ROCHE;
            case "SOL" -> SOL;
            case "COMBAT" -> COMBAT;
            case "SPECTRE" -> SPECTRE;
            case "POISON" -> POISON;
            default -> null;
        };
    }  
    
}
