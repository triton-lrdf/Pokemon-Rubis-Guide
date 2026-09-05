package Modeles;

public class PokeDresseur {

    private final Pokemon pokemon ;
    private final int niveau ;
    private final Capacite[] capacites = new Capacite[4] ;

    public PokeDresseur (Pokemon poke, int niv,Capacite capacite1, Capacite capacite2, Capacite capacite3, Capacite capacite4) {
        pokemon = poke ;
        niveau = niv ;
        capacites[0] = capacite1 ;
        capacites[1] = capacite2 ;
        capacites[2] = capacite3 ;
        capacites[3] = capacite4 ;

    }
    public String toString () {
        StringBuilder result = new StringBuilder(pokemon.getInformations(niveau) + "\n");
        boolean pair = false ;
        for (Capacite c : capacites) {
            if (c != null) {
                result.append(c.inline());
                if (pair) {
                    result.append("\n");
                }else {
                    result.append(" - ");
                }
                pair = !pair ;

            }
        }

        return result.toString();
    }


    public int getNiveau() {
        return niveau ;
    }
}
