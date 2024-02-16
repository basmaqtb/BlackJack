import java.util.ArrayList;
import java.util.Random;

public class PaquetCards {
    private ArrayList<Card> listCartes;
    private int size;

    public PaquetCards(ArrayList<Card> listCartes, int size) {
        this.listCartes = listCartes;
        this.size = size;
    }

    public ArrayList<Card> getListCartes() {
        return listCartes;
    }

    public void setListCartes(ArrayList<Card> listCartes) {
        this.listCartes = listCartes;
    }

    public void addCard(Card card) {
        listCartes.add(card);
    }

    public  void shuffleCartes() {
        Random random = new Random();

        for (int i = 0; i < listCartes.size(); i++) {
            int j = random.nextInt(listCartes.size());
            Card currCard = listCartes.get(i);
            Card randomCard = listCartes.get(j);

            listCartes.set(i, randomCard);
            listCartes.set(j, currCard);
        }
        System.out.println(listCartes);
    }
}
