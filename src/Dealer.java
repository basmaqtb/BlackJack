class Dealer extends Person {
    private int valeurTotalLimit;

    public Dealer(int valeurTotalLimit) {
        super("Dealer");
        this.valeurTotalLimit = valeurTotalLimit;
    }

    public int getValeurTotalLimit() {
        return valeurTotalLimit;
    }

    public void setValeurTotalLimit(int valeurTotalLimit) {
        this.valeurTotalLimit = valeurTotalLimit;
    }

    public void distribuerCarte(Deck deck, Person person, boolean faceVisible) {
        Card card = deck.drawCard();
        person.getHand().ajouterCarte(card.getCouleur(), card.getValeur());
        if (faceVisible) {
            System.out.println(person.getNom() + " a reçu : " + card);
        } else {
            System.out.println(person.getNom() + " [Hidden Card].");
        }
    }
}