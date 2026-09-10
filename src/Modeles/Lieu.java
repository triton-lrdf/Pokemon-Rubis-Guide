package Modeles;

public class Lieu {

    private final String nom;
    private final Dresseur [] combats ;


    public Lieu(String nom, Dresseur [] combats ) {
        this.nom = nom; this.combats = combats; ;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(nom + "\n");
        result.append("Combats : \n");
        for (Dresseur d : combats) {
            result.append(d.getInfoRoute()).append("\n");
        }

        return result.toString();
    }


    public Dresseur getDresseurs(String nom) {
        for (Dresseur d : combats) {
            if (d.getNom().equals(nom)) {
                return d ;
            }
        }
        return null ;
    }


    public String getNom() {
        return nom ;
    }

    public String getInfos() {
        StringBuilder result = new StringBuilder(nom + "\n");
        result.append("Dresseurs : \n");
        for (Dresseur d : combats) {
            result.append(d.getInfoRoute()).append("\n");
        }
        return result.toString();
    }


}