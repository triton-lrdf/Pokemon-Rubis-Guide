package Modeles;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.ResultSet;
import java.sql.Statement;

public class Data {

    private Pokemon[] pokemons;
    private Capacite[] capacites;

    public Data(Statement stm) {
        // On repure toutes les infos des pokemons de la generation
        if (! loadPokemons(stm)) {
            System.out.println("Erreur de lecture de pokemons");
        }
        if (!loadCapacite(stm)) {
            System.out.println("Erreur de lecture de capacite");
        }


    }

    public String[] getNoms() {
        String[] names = new String[pokemons.length];
        for (int i = 0; i < pokemons.length; i++) {
            names[i] = pokemons[i].getNom();
        }
        return names;
    }

    public String getAllPokemons() {
        String res = "";
        for (Pokemon p : pokemons) {
            res += p.getInformations() + "\n";
        }
        return res;
    }

    public String getInformations(int id) {
        for (Pokemon p : pokemons) {
            if (p.getId() == id) {
                return p.getInformations();
            }
        }
        return null ;
    }

    public String getInformations(String nom) {
        for (Pokemon p : pokemons) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p.getInformations();
            }
        }
        return null ;
    }

    private boolean loadPokemons(Statement stm) {
        try {

            ResultSet res  = stm.executeQuery("select count(id) from pokemon");
            res.next();
            pokemons = new Pokemon[res.getInt(1)];
            res = stm.executeQuery("SELECT * from pokemon as p ;");
            int index = 0;
            while (res.next()) {

                Pokemon temp = new Pokemon(
                        res.getInt("id"),
                        res.getString("nom"),
                        Types.getType(res.getInt("type1")),
                        Types.getType(res.getInt("type2")),
                        res.getInt("pv"),
                        res.getInt("attaque"),
                        res.getInt("defense"),
                        res.getInt("attaqueSpe"),
                        res.getInt("defenseSpe"),
                        res.getInt("vitesse")
                ) ;
                if (index < pokemons.length) {
                    pokemons[index] = temp;
                }
                index++;
            }
            return true ;

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean loadCapacite(Statement stm) {
        try{

            ResultSet res  = stm.executeQuery("select count(id) from capacite");
            res.next();
            capacites = new Capacite[res.getInt(1)];
            res = stm.executeQuery("SELECT * from capacite ;");
            int index = 0;
            while (res.next()) {

                Capacite temp = new Capacite(
                        res.getString("nom"),
                        res.getString("descrip"),
                        res.getInt("puissance"),
                        res.getInt("prec"),
                        res.getString("categorie").charAt(0),
                        Types.getType(res.getInt("elem"))
                ) ;
                if (index < capacites.length) {
                    capacites[index] = temp;
                }
                index++;
            }
            return true ;

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public String[] getCapacites() {
        String[] res = new String[capacites.length];
        for (int i = 0; i < capacites.length; i++) {
            res[i] = capacites[i].getNom();
        }
        return res;
    }


}
