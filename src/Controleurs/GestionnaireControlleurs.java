package Controleurs;

import Modeles.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            String[] resRech =  search.pokeParNom(donnees.getNoms(), nom.toLowerCase()) ;
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
        System.out.println("Voici les pokemons disponibles dans cette generation :");
        StringBuilder resultat = new StringBuilder();
        for (String nom : donnees.getNoms()) {
            resultat.append(nom).append("\n");
        }
        return resultat.toString();
    }


    public String getCapacites() {
        StringBuilder resultat = new StringBuilder();
        for (String cap : donnees.getCapacites()) {
            resultat.append(cap).append("\n");
        }
        return resultat.toString();
    }


    public String getDresseurs () {
        return "" ;
    }

    public String getLieux () {
        return donnees.getListeRoute() ;
    }

    public String getDresseur(String nom) {
        return "" ;
    }



}
