import java.util.ArrayList;

public class Card {
    private String type;
    private String valeur;

    public Card(String type, String valeur) {
        this.type = type;
        this.valeur = valeur;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getValeur(){
        return valeur;
    }
    public void setValeur(String valeur){
        this.valeur = valeur;
    }




    public String toString() {
        return "[" + valeur + "|" + type + "]";
    }

    public static void buildDeck() {
        String[] types = {" carreau", " cœur", " pique", " trèfle"};
        String[] valeurs = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < valeurs.length; i++) {
            for (int j = 0; j < types.length; j++) {
                Card card = new Card(types[j], valeurs[i]);
                deck.add(card);
            }
        }

        PaquetCards paquetCards = new PaquetCards(deck, deck.size()); 
    
    }
}
