package Modeles;

public class Pokemon {

    private final int id ;
    private final String nom ;
    private final Types type1 ;
    private final Types type2 ;
    private final int pv ;
    private final int attaque ;
    private final int defense ;
    private final int attaque_spe ;
    private final int defense_spe ;
    private final int vitesse ;

    public Pokemon(int id, String nom, Types type1, Types type2, int pv, int attaque, int defense, int attaque_spe, int defense_spe, int vitesse) {
        this.id = id;
        this.nom = nom;
        this.type1 = type1;
        this.type2 = type2;
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.attaque_spe = attaque_spe;
        this.defense_spe = defense_spe;
        this.vitesse = vitesse;
    }

    public String getInformations () {
        String result = "" ;
        result += nom +"\n";
        result += "type : " +type1 ;
        if (type2 != null) result += " "+type2 ;
        result += '\n';
        result += "pv : "+pv +'\n';
        result += "attaque : "+attaque +'\n';
        result += "deffense : "+defense +'\n';
        result += "attaque spe : "+attaque_spe +'\n';
        result += "deffense spe : "+defense_spe +'\n';
        result += "vitesse : "+vitesse +'\n';

        return result;
    }


    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
