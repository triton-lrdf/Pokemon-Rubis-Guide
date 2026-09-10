package Controleurs;

import Modeles.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// la classe va servir a centraliser les differents controlleurs
// et garder la data qu'elle va donner aux controlleurs à chaque méthode
public class GestionnaireControlleurs {

    private Data donnees ;
    Connection connect ;
    ControlleurRecherche search ;

    public GestionnaireControlleurs() {
        try {

            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nuzlockerrubis",
                    "client",
                    "JePrefereLa3G"
            );

            Statement stmt = connect.createStatement();
            donnees = new Data(stmt) ;
            search = new  ControlleurRecherche();

        }catch (Exception e) {
            donnees = null ;
            System.out.println(e.getMessage());
        }
    }

    public String getAllPokemon () {
        System.out.println("voici les informations de base des pokemons de cette generation ");
        return donnees.getAllPokemons() ;
    }

    public String getPokemon (int id) {
        System.out.println("recherche du pokemon par son id");
        String res =  donnees.getInformations(id);
        if (res != null) return res;
        else return "Id Pokedex incorrect aucun pokemon trouvé" ;
    }

    public String getPokemon (String nom) {
        System.out.println("recherche du pokemon par son nom");
        String res = donnees.getInformations(nom);
        if (res != null) {return res;
        }else {
            String[] resRech =  search.parNom(donnees.getNomsPoke(), nom.toLowerCase()) ;
            StringBuilder resultat = new StringBuilder();
            if (resRech[1] == null && resRech[0] != null) {
                return donnees.getInformations(resRech[0]) ;
            }
            for (String s : resRech) {
                if (s != null) resultat.append(s).append("\n");
            }
            if (resultat.isEmpty()) {
                return "Aucun pokemon trouvé" ;
            }
            return resultat.toString();
        }


    }

    public String getNoms() {

        StringBuilder resultat = new StringBuilder("Voici les pokemons disponibles dans cette generation : \n");
        for (String nom : donnees.getNomsPoke()) {
            resultat.append(nom).append("\n");
        }
        return resultat.toString();
    }


    public String getCapacite(String nom) {
        String [] trouves = search.parNom(donnees.getNomCapacites(),nom) ;
        if (trouves[0] == null) {
            return "aucune capacité trouvée" ;
        }
        if (trouves[0] != null && trouves[1] == null) {
            return trouves[0] ;
        }

        StringBuilder resultat = new StringBuilder();
        for (String s : trouves) {
            if (s != null) resultat.append(s).append("\n");
        }
        return resultat.toString();
    }

    public String getAllCapacites() {

        return "voici les capacites disponibles dans cette generation : \n" + donnees.getAllCapacites() ;
    }

    public String getDresseurs () {
        return "" ;
    }

    public String getLieux () {return "les routes :" + donnees.getListeRoute() ;}

    public String getLieu(String nom) {
        System.out.println("recherche du lieu par son nom");

        String res = donnees.getLieu(nom) ;
        if (res == null ) {
            System.out.println("aucun lieu trouvé");
        }
        return res ;
    }

    public String getDresseur(String nom) {
        System.out.println("recherche du dresseur par son nom");
        String res = donnees.getDresseur(nom) ;
        if (res == null ) {
            System.out.println("aucun dresseur trouvé");
        }
        return res ;
    }

    public String getRencontre (boolean type, String nom) {
        return "" ;
    }

    public String getAllRencontres () {
        return donnees.getAllRencontres() ;
    }

    public String getInfoDresseurs () {
        return donnees.getInfoDresseur() ;
    }



}
