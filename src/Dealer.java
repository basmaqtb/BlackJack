class Dealer extends Person implements CroupierInterface {
    private int valeurTotalLimit = 21;

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

            

     @Override

    public void distribuerCarte(Deck deck, Person person, boolean faceVisible) {
        Card card = deck.drawCard();
        person.getHand().ajouterCarte(card.getCard_type(), card.getValeur());
        if (faceVisible) {
            System.out.println(person.getNom() + "  : " + card);
        } else {
            System.out.println(person.getNom() + " [Hidden Card].");
        }
    }
}