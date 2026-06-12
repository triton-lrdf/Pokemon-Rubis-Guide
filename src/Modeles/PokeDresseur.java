package Modeles;

public class PokeDresseur {

    private final Pokemon pokemon ;
    private final int niveau ;
    private final Capacite[] capacites ;

    public PokeDresseur (Pokemon poke, int niv,Capacite[] capacites) {
        pokemon = poke ;
        niveau = niv ;
        this.capacites = capacites ;
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
                    result.append(" ");
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
