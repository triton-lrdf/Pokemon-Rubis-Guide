import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nuzlockerrubis",
                    "client",
                    "JePrefereLa3G"
            );

            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT p.id, p.nom,elem1.nom as type1 ,elem2.nom as type2 from pokemon as p " +
                    " join element as elem1 on elem1.id = p.type1 left join element as elem2 on elem2.id = p.type2 ;");

            while (res.next()) {
                System.out.println(res.getString("nom"));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}