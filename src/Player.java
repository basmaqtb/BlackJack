

class Player extends Person implements JoueurInterface {
    int solde = 1000;

    public Player(String nom, int solde) {
        super(nom);
        this.solde = solde;
    }

            public int getSolde() {
                return solde;
            }
            public void setSolde(int solde) {
                this.solde = solde;
            }



    @Override
    public void hit(Deck deck) {
        getHand().ajouterCarte(deck.drawCard().getCard_type(), deck.drawCard().getValeur());
        showHand(true);
    }

    
    @Override
    public void stand() {
        System.out.println(getNom() + " a choisi de rester.");
    }
}
