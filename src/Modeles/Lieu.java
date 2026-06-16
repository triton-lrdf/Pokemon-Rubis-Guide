package Modeles;

import java.util.ArrayList;

public class Lieu {

    private final String nom;
    private final Dresseur [] combats ;
    // manque les pokemon et leur taux pour ca c cho
    // je peux tenter de remettre des pointeurs et faire un tableau associé pour les taux
    // ou je peux enregistrer juste leur numeros ID

    public Lieu(String nom, Dresseur [] combats ) {
        this.nom = nom; this.combats = combats;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(nom + " ");

        for (Dresseur d : combats) {
            result.append(d.getInfoRoute());
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