package Modeles;

public class Lieu {

    private final String nom;
    private final Dresseur [] combats ;
    private final Rencontre [] rencontres ;


    public Lieu(String nom, Dresseur [] combats, Rencontre [] rencontres) {
        this.nom = nom; this.combats = combats; this.rencontres = rencontres;

    }

    public String toString() {
        StringBuilder result = new StringBuilder(nom + "\n");
        result.append("Rencontres: \n");
        for  (Rencontre rencontre : rencontres) {
            result.append(rencontre.getInfo());
        }
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


}