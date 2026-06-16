package Modeles;

public class Dresseur {

    private final String nom ;
    private final String position ;
    private final PokeDresseur[] equipe ;

    public Dresseur(String nom, String position, PokeDresseur[] equipe) {this.nom = nom;this.position = position;this.equipe = equipe;}

    public String toString() {
        StringBuilder result = new StringBuilder(nom +"Niveau maximum : "+getNivMax() +"\n");
        result.append(position).append("\n");
        result.append("Equipe : " + "\n");
        for (PokeDresseur p : equipe) {
            result.append(p.toString()).append("\n");
        }

        return result.toString();
    }

    public int getNivMax () {
        int max = 0 ;
        for  (PokeDresseur p : equipe ) {
            if (p.getNiveau() > max) max= p.getNiveau() ;
        }
        return max ;
    }

    public  String getInfoRoute () {
        return nom + " de niveau max : " + getNivMax() + position;
    }


    public String getNom() {
        return nom ;
    }
}
