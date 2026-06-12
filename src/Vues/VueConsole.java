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
        while (console.hasNextLine()) {

            String cmd = console.nextLine().toLowerCase().trim();
            if (cmd.contains("pokemon")) {
                System.out.println(cmdPokemon(gc,cmd)) ;

            }else if (cmd.contains("pokedex")) {
                System.out.println(gc.getAllPokemon());

            }if (cmd.contains("capacité")) {
                System.out.println(cmdCapacite(gc,cmd)) ;

            }else if (cmd.contains("capacités")) {
                System.out.println(gc.getCapacites()) ;

            }if (cmd.contains("dresseur")) {
                System.out.println(cmdDresseur(gc,cmd)) ;

            }else if (cmd.contains("dresseurs")) {
                System.out.println(gc.getDresseurs());

            }if (cmd.contains("lieu")) {
                System.out.println(cmdLieu(gc,cmd)) ;

            }else if (cmd.contains("lieux")) {
                System.out.println(gc.getLieux());

            } else if (cmd.contains("ls")) {
                System.out.println("voici les commandes disponibles, merci de respecter les écarts entre les elements");
                System.out.println("help -nom de la classe-");
                System.out.println("la commande sans nom de classe permet d'afficher la liste des classes disponibles");
                System.out.println("l'option syntax de la classe donne la syntaxe de creation avec les méthodes ") ;
                System.out.println("et vous montre un exemple");
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
        return "" ;
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

}
