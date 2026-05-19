package Controleurs;

import Modeles.Data;

public class ControlleurRecherche {

    public String [] parNom (Data d, String nom ) {
        String[] result = new String[10] ;
        int index = 0 ;
        for (String pkm : d.getNoms()) {
            pkm = pkm.toLowerCase();
            if (pkm.startsWith(nom) &&  index < 10) {
                result[index] = pkm;
                index++ ;
            }
        }

        return result;
    }


}
