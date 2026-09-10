package Modeles;

public class Rencontre {

    private final String espece;
    private final String lieu ;
    private final int niveau ;
    private final int taux ;
    private final String detail ;

    public Rencontre(String poke,String lieu, int niveau, int taux, String details) {
        espece = poke ; this.lieu = lieu ; this.taux = taux; this.detail = details; this.niveau = niveau;
    }

    public String getInfo() {
        return espece + " | " + lieu + " | niv " + niveau+" | " + taux + "% | " + detail;
    }

    public boolean especePoke(String poke) {return espece.equalsIgnoreCase(poke);}

    public String getEspece() {
        return espece ;
    }

    public boolean isIn(String l){return  lieu.equalsIgnoreCase(l);}

    public String getInfoRoute() {return espece + " | " + taux + "% "+ detail ;}

}
