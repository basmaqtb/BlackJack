import java.util.ArrayList;
import java.util.Random;

class Deck implements PaquetCartesInterface{
    int size = 52;
    ArrayList<Card> listCartes;

            public Deck() {
                this.listCartes = new ArrayList<>();
                initializeDeck();
            }

    @Override
    public void initializeDeck() {
        String[] Card_Card_types = {"Coeur", "Carreau", "Trefle", "Pique"};
        String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String Card_type : Card_Card_types) {
            for (String valeur : valeurs) {
                listCartes.add(new Card(Card_type, valeur));
            }
        }
    }

    @Override
    public void shuffleCards() {
        Random random = new Random();

        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Card currCard = listCartes.get(i);
            Card randomCard = listCartes.get(j);

            listCartes.set(i, randomCard);
            listCartes.set(j, currCard);
        }
    }


    @Override
    public Card drawCard() {
        if (listCartes.isEmpty()) {
            System.out.println("No cards left in the deck!");
            return null;
        }
        return listCartes.remove(0);
    }
}
