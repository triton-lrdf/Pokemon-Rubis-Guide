import Controleurs.GestionnaireControlleurs;
import Modeles.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        GestionnaireControlleurs g = new GestionnaireControlleurs();
        System.out.println(g.getNoms()) ;
        System.out.println(g.getCapacites());



    }
}