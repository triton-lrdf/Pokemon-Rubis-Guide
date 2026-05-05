package Modeles;

import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;

public class Data {

    private Pokemon[] pokemons;

    public Data(Statement stm) {
        // On repure toutes les infos des pokemons de la generation
        try {
            ResultSet res = stm.executeQuery("SELECT p.id, p.nom,elem1.nom as type1 ,elem2.nom as type2, pv, attaque, defense, attaqueSpe, defenseSpe, vitesse from pokemon as p " +
                    " join element as elem1 on elem1.id = p.type1 left join element as elem2 on elem2.id = p.type2 ;");

            pokemons = new Pokemon[9] ;
            int index = 0;
            while (res.next()) {

                Pokemon temp = new Pokemon(
                        res.getInt("id"),
                        res.getString("nom"),
                        res.getString("type1"),
                        res.getString("type2"),
                        res.getInt("pv"),
                        res.getInt("attaque"),
                        res.getInt("defense"),
                        res.getInt("attaqueSpe"),
                        res.getInt("defenseSpe"),
                        res.getInt("vitesse")
                        ) ;
                pokemons[index] = temp;
                index++;
            }

        }catch(Exception e) {
            e.printStackTrace();
        }


    }

    public String[] getNames() {
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
            if (p.getNom().equals(nom)) {
                return p.getInformations();
            }
        }
        return null ;
    }

}
