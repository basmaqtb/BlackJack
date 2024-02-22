import java.util.ArrayList;

class Hand implements MainInterface {
    int valeurTotal;
    String nom;
    int nbCartes;
    ArrayList<Card> listeCarte;

    public Hand(String nom) {
        this.nom = nom;
        this.valeurTotal = 0;
        this.nbCartes = 0;
        this.listeCarte = new ArrayList<>();
    }

    public int getValue() {
        valeurTotal = 0;
        int nbAs = 0;

        for (Card card : listeCarte) {
            String cardValue = card.getValeur();

            if ("AJQK".contains(cardValue)) {
                if ("A".equals(cardValue)) {
                    nbAs++;
                    valeurTotal += 11;
                } else {
                    valeurTotal += 10;
                }
            } else {
                valeurTotal += Integer.parseInt(cardValue);
            }
        }

      
        while (nbAs > 0 && valeurTotal > 21) {
            valeurTotal -= 10;
            nbAs--;
        }

        return valeurTotal;
    }

        @Override
    public void ajouterCarte(String couleur, String valeur) {
        Card card = new Card(couleur, valeur);
        listeCarte.add(card);
        nbCartes++;
    }

    public ArrayList<Card> getListeCarte() {
        return listeCarte;
    }

    @Override
    public String toString() {
        return nom + "'s Hand: " + listeCarte + " (Total Value: " + getValue() + ")";
    }
}