public class App {
    public static void main(String[] args) {
        
        Card.buildDeck();
        System.out.println("after shuffle");
        PaquetCards deck = new PaquetCards(null, 0);  
        deck.shuffleCartes(); 
    }
}
