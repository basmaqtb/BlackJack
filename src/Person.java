import java.util.ArrayList;

class Person {
    String nom;
    Hand hand;

    public Person(String nom) {
        this.nom = nom;
        this.hand = new Hand(nom + "'s Hand");
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    

    public Hand getHand() {
        return hand;
    }

    public void showHand(boolean showFirstCard) {
        ArrayList<Card> personHand = hand.getListeCarte();

        System.out.print(nom + "'s Hand: ");
        if (showFirstCard) {
            System.out.println(personHand);
        } else {
            System.out.println("[Hidden Card, " + personHand.get(1) + "]");
        }
    }
}