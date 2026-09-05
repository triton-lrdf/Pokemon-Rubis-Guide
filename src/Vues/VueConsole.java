package Vues;

import Controleurs.GestionnaireControlleurs;
import java.util.Scanner;


public class VueConsole {

    public VueConsole() {
        cmdConsole();
    }

    private void cmdConsole() {
        GestionnaireControlleurs gc = new GestionnaireControlleurs();
        Scanner console = new Scanner(System.in);
        System.out.println("\n" + "Commandes consoles :");
        System.out.println("saisir 'q'ou 'quit' pour quitter 'ls' pour la liste des commandes disponibles");
        System.out.println(gc.getInfoDresseurs());
        while (console.hasNextLine()) {

            String cmd = console.nextLine().toLowerCase().trim();
            if (cmd.contains("pokemon")) {
                System.out.println(cmdPokemon(gc,cmd)) ;

            }else if (cmd.contains("pokedex")) {
                System.out.println(gc.getAllPokemon());

            }else if (cmd.contains("capacites")) {
                System.out.println(gc.getAllCapacites()) ;

            }else if (cmd.contains("capacite")) {
                System.out.println(cmdCapacite(gc,cmd)) ;

            }else if (cmd.contains("dresseurs")) {
                System.out.println(gc.getDresseurs());

            }else if (cmd.contains("dresseur")) {
                System.out.println(cmdDresseur(gc,cmd)) ;

            }else if (cmd.contains("lieux")) {
                System.out.println(gc.getLieux());

            }else if (cmd.contains("lieu")) {
                System.out.println(cmdLieu(gc,cmd)) ;

            }else if (cmd.contains("rencontres")) {
                System.out.println(gc.getAllRencontres()) ;

            }else if (cmd.contains("rencontre")) {
                System.out.println(cmdRencontres(gc,cmd)) ;


            } else if (cmd.contains("ls")) {
                System.out.println("voici les commandes disponibles, merci de respecter les écarts entre les elements");
                System.out.println("pokemon -nom du pokemon-");
                System.out.println("la commande sans nom de classe permet d'afficher la liste des pokemons disponibles");
                System.out.println("pokedex ") ;
                System.out.println("Liste l'entiereté des pokemons avec les informations de base");
                System.out.println("capacite -nom de la capacite ") ;
                System.out.println("capacites ") ;
                System.out.println("renvoie la liste des capacites avec les informations de base") ;
                System.out.println("cela fontionne de la meme facon pour 'dresseur(s)' et 'lieu(x)' ") ;
            } else if (cmd.contains("quit") || cmd.contains("q")) {
                console.close();
                return;
            } else {
                System.out.println("commande invalide ");
            }

            System.out.println();
            System.out.println("saisir 'q'ou 'quit' pour quitter 'ls' pour la liste des commandes disponibles");
        }
    }

    private String cmdDresseur(GestionnaireControlleurs gc, String cmd) {
        return "" ;
    }

    private String cmdCapacite(GestionnaireControlleurs gc, String cmd) {
        if (cmd.length() >= 10 ) {
            String capapcite = cmd.split(" ")[1];

                for (Character c : capapcite.toCharArray()) {
                    if (Character.isDigit(c)) {
                        return "erreur, vous avez inséré un chiffre dans votre recherche" ;
                    }
                }

                return (gc.getCapacite(capapcite) );

        }else {
            return gc.getAllCapacites() ;
        }

    }


    private String cmdLieu(GestionnaireControlleurs gc, String cmd) {
        return "" ;
    }

    private String cmdPokemon (GestionnaireControlleurs gc, String nom) {
        if (nom.length() > 8 ) {
            String poke = nom.split(" ")[1];
            boolean chiffre = false ;
            boolean lettre = false ;
            // on va faire une boucle et chercher chiffres comme lettres si on trouve les deux on refuses
            // si on en trouve 1 des deux on utilise le type qu'on a trouvé pour la recherche
            for (int i =0 ; i < poke.length() ; i++) {
                if (Character.isDigit(poke.charAt(i))) {
                    chiffre = true ;
                }else if (Character.isAlphabetic(poke.charAt(i))) {
                    lettre = true ;
                }
                if (lettre && chiffre) {
                    System.out.println("Erreur dans la saisie veuillez ne pas melanger chiffres et lettres");
                    return "" ;
                }
            }

            if (chiffre) {
               return (gc.getPokemon(Integer.parseInt(poke)) );
            }else if (lettre) {
                return (gc.getPokemon(poke) );
            }else {
                return "erreur numero pokedex ou nom de pokemon incorrect" ;
            }
        }else {
            return (gc.getNoms()) ;
        }

    }

    public String cmdRencontres (GestionnaireControlleurs gc, String cmd) {
        return "" ;
    }

}
