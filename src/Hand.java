import java.util.ArrayList;

import java.util.ArrayList;

public class Hand {
    private int valeurTotal;
    private String nom;
    private int nbCartes;
    private ArrayList<Card> listeCarte;

    public Hand(String nom) {
        this.nom = nom;
        this.valeurTotal = 0;
        this.nbCartes = 0;
        this.listeCarte = new ArrayList<>();
    }

    public int getValue() {

        for (Card card : listeCarte) {
            String cardValue = card.getValeur();

            if ("AJQK".contains(cardValue)) {

                if("A".equals(cardValue)){
                    return 11;
                }else{
                    return 10;
                }
            
            } else {
                
                valeurTotal += Integer.parseInt(cardValue);
            }
        }
        return valeurTotal;

    }



    public void ajouterCarte(String type, String value) {
        Card card = new Card(type, value);
        listeCarte.add(card);
        nbCartes++;
    }
   
}
