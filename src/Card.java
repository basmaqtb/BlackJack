class Card {
    private String couleur;
    private String valeur;

    public Card(String couleur, String valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "[" + couleur + " | " + valeur + "]";
    }
}