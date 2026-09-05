package Modeles;

import java.sql.ResultSet;
import java.sql.Statement;

public class Data {

    private Pokemon[] pokemons;
    private Capacite[] capacites;
    private Lieu[] lieux ;
    private Rencontre[] rencontres;

    // temporaire pour faire des tests
    private Dresseur[] dresseurs;

    public Data(Statement stm) {
        // On repure toutes les infos des pokemons de la generation
        if (! loadPokemons(stm)) {
            System.out.println("Erreur de lecture des pokemons");
        }
        if (!loadCapacite(stm)) {
            System.out.println("Erreur de lecture des capacites");
        }
        if (!loadRencontres(stm)) {
            System.out.println("Erreur de lecture des rencontres");
        }
        if (!loadDresseurs(stm)) {
            System.out.println("Erreur de lecture des dresseurs");
        }

    }

    // LES CHARGEMENTS

    public Boolean loadDresseurs( Statement stm) {
        try{

            ResultSet res = stm.executeQuery("select count(id) from dresseur ;");
            res.next();
            dresseurs = new Dresseur[res.getInt(1)] ;
            res.close();

            // l'idée ca va etre de prendre la liste des noms des dresseurs
            // puis de chercher pour chacun d'entre eux ses pokemons


            int index = 0;
            while (index < dresseurs.length) {
                ResultSet dress = stm.executeQuery("select nom,position from dresseur where id = " + (index+1) + " ;");
                dress.next();
                String nom = dress.getString("nom");
                String position = dress.getString("position");

                PokeDresseur[] equipe = new PokeDresseur[6];

                ResultSet poke = stm.executeQuery("select p.nom as nom, niveau,(select nom from capacite where id = capacite1 ) as capacite1,(select nom from capacite where id = capacite2 ) as capacite2,(select nom from capacite where id = capacite3 ) as capacite3,(select nom from capacite where id = capacite4 ) as capacite4 from pokedresseur as pdr join pokemon as p on poke = p.id left join dresseur as d on d.poke1 = pdr.id or d.poke2 = pdr.id or d.poke3 = pdr.id or d.poke4 = pdr.id or d.poke5 = pdr.id or d.poke6 = pdr.id where d.nom = '" +nom+"' ;" );
                for (int i = 0; i < 6; i++) {
                    if (poke.next()) {
                        System.out.println(poke.getRow());
                        equipe[i] = new PokeDresseur(
                                getPokemon(poke.getString("nom")),
                                poke.getInt("niveau"),
                                getCapacite(poke.getString("capacite1")) ,
                                getCapacite(poke.getString("capacite2")) ,
                                getCapacite(poke.getString("capacite3")) ,
                                getCapacite(poke.getString("capacite4"))
                                ) ;
                    }
                }
                poke.close();
                Dresseur temp = new Dresseur(
                        nom,
                        position,
                        equipe
                ) ;

                if (index < dresseurs.length) {
                    dresseurs[index] = temp;
                }
                index++;

            }
            return true ;

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
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

    private boolean loadLieux(Statement stm) {
        return true ;
    }

    private boolean loadRencontres (Statement stm) {
        try{

            ResultSet res  = stm.executeQuery("select count(*) from tauxroutes");
            res.next();
            rencontres = new Rencontre[res.getInt(1)];
            res = stm.executeQuery("select p.nom, l.nom as lieu, t.niveau, t.taux, t.details from tauxroutes as t join Pokemon as p on idPoke = id join lieu as l on l.id = t.idLieu  order by 2;");
            int index = 0;
            while (res.next()) {

                Rencontre temp = new Rencontre(
                        res.getString("nom"),
                        res.getString("lieu"),
                        res.getInt("niveau"),
                        res.getInt("taux"),
                        res.getString("details")
                ) ;
                if (index < rencontres.length) {
                    rencontres[index] = temp;
                }
                index++;
            }
            return true ;

        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // LES RETOURS

    public String[] getCapacites() {
        String[] res = new String[capacites.length];
        for (int i = 0; i < capacites.length; i++) {
            res[i] = capacites[i].getNom();
        }
        return res;
    }

    public String getListeRoute() {
        StringBuilder res = new StringBuilder();
        for (Lieu l : lieux) {
            res.append(l.toString()).append("\n");
        }
        return  res.toString();
    }

    public String getDresseur(String nom) {
        Dresseur resultat ;
        for (Lieu l : lieux) {

            resultat = l.getDresseurs(nom) ;
            if (resultat != null) {
                return resultat.getNom();
            }

        }
        // a voir
        return null ;

    }

    public String getAllCapacites() {
        StringBuilder res = new StringBuilder();
        for (Capacite c : capacites) {
            res.append(c.inline()).append("\n");
        }
        return  res.toString();
    }

    public String[] getNomsPoke() {
        String[] names = new String[pokemons.length];
        for (int i = 0; i < pokemons.length; i++) {
            names[i] = pokemons[i].getNom();
        }
        return names;
    }

    public String getAllPokemons() {
        StringBuilder res = new StringBuilder();
        for (Pokemon p : pokemons) {
            res.append(p.getInformations()).append("\n");
        }
        return res.toString();
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

    public String getAllRencontres() {
        StringBuilder res = new StringBuilder();
        for (Rencontre r : rencontres) {
            res.append(r.getInfo()).append("\n");
        }
        return  res.toString();
    }

    public String[] getNomCapacites() {
        String[] res = new String[capacites.length];
        for (int i = 0; i < capacites.length; i++) {
            res[i] = capacites[i].getNom();
        }
        return res;
    }

    private Pokemon getPokemon(String nom) {
        if (nom == null || nom.equalsIgnoreCase("null")) {return null;}
        for (Pokemon p : pokemons) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null ;
    }

    private Capacite getCapacite(String nom) {
        if (nom == null || nom.equalsIgnoreCase("null")) {return null;}
        for (Capacite c : capacites) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                return c;
            }
        }
        return null ;
    }
    public String getInfoDresseur() {
        StringBuilder res = new StringBuilder();
        for (Dresseur d : dresseurs) {
            res.append(d.toString()).append("\n");
        }
        return  res.toString();
    }

}
