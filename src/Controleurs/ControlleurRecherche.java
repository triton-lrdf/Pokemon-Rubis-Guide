package Controleurs;


public class ControlleurRecherche {

    public String [] parNom (String[] noms, String chaine ) {
        String[] result = new String[10] ;
        int index = 0 ;
        for (String pkm : noms) {
            pkm = pkm.toLowerCase();
            if (pkm.startsWith(chaine) &&  index < 10) {
                result[index] = pkm;
                index++ ;
            }else if (index >= 10) {
                break ;
            }
        }

        return result;
    }



}
