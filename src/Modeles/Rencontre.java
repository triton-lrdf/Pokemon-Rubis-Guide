package Modeles;

public class Rencontre {

    private final String espece;
    private final String lieu ;
    private final int niveau ;
    private final int taux ;
    private final String detail ;

    Rencontre(String poke,String lieu, int niveau, int taux, String details) {
        espece = poke ; this.lieu = lieu ; this.taux = taux; this.detail = details; this.niveau = niveau;
    }

    String getInfo() {
        return espece + " | " + lieu + " | niv " + niveau+" | " + taux + "% | " + detail;
    }

    Boolean especePoke(String poke) {
        return espece == poke;
    }

    String getEspece() {
        return espece ;
    }


}
