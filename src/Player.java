

class Player extends Person {
    private int solde = 1000;

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

    public void hit(Deck deck) {
        getHand().ajouterCarte(deck.drawCard().getCouleur(), deck.drawCard().getValeur());
        showHand(true);
    }

    public void stand() {
        System.out.println(getNom() + " a choisi de rester.");
    }
}
