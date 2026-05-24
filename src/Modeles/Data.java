package Modeles;

import java.sql.ResultSet;
import java.sql.Statement;

public class Data {

    private Pokemon[] pokemons;

    public Data(Statement stm) {
        // On repure toutes les infos des pokemons de la generation
        try {
            ResultSet res = stm.executeQuery("SELECT p.id, p.nom, type1, type2, pv, attaque, defense, attaqueSpe, defenseSpe, vitesse from pokemon as p ");

            pokemons = new Pokemon[28] ;
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

        }catch(Exception e) {
            e.printStackTrace();
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

}
