class Card {
    private String Card_type;
    private String valeur;

    public Card(String Card_type, String valeur) {
        this.Card_type = Card_type;
        this.valeur = valeur;
    }

            public String getCard_type() {
                return Card_type;
            }

            public String getValeur() {
                return valeur;
            }

    @Override
    public String toString() {
        return "[" + Card_type + " | " + valeur + "]";
    }
}