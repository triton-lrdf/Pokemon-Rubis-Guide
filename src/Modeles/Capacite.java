package Modeles;

public class Capacite {

    private final String nom ;
    private final String description ;
    private final int puissance ;
    private final int precision ;
    private final char categorie ;
    private final Types type ;




    public Capacite(String nom, String description, int puissance, int precision, char categorie, Types type) {
        this.nom = nom;
        this.description = description;
        this.puissance = puissance;
        this.precision = precision;
        this.categorie = categorie;
        this.type = type;
    }

    public String toString(){
        return nom + "\n" + puissance + "\n" + precision + "\n" + categorie + "\n" + type+ "\n" + description;
    }

    public String getNom() {
        return nom;
    }
}
