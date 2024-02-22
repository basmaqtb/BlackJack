import java.util.Scanner;

public class Blackjack {
    private Player joueur;
    private Dealer croupier;
    private Deck paquet;

    public Player getPlayer() {
        return joueur;
    }

    public Blackjack(String username, int solde, int valeurTotalLimit) {
        joueur = new Player(username, solde);
        croupier = new Dealer(valeurTotalLimit);
        paquet = new Deck();
        paquet.shuffleCards();
    }

    public Blackjack() {}

    public void commencerPartie() {
        placerMise();
        distribuerCartesInitiales();
        jouerTourJoueur();
        jouerTourCroupier();
        determinerVainqueur();
    }

    public void placerMise() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Placez votre mise : ");
        int mise = scanner.nextInt();
        joueur.setSolde(joueur.getSolde() - mise);
        System.out.println("Mise placée : " + mise);
        scanner.close();
    }

    public void distribuerCartesInitiales() {
        croupier.distribuerCarte(paquet, croupier, true);
        croupier.distribuerCarte(paquet, croupier, false);

        croupier.distribuerCarte(paquet, joueur, true);
        croupier.distribuerCarte(paquet, joueur, true);
    }

    public void jouerTourJoueur() {

        joueur.showHand(true);
        System.out.println("Valeur totale de votre main : " + joueur.getHand().getValue());

        Scanner scanner = new Scanner(System.in);

            System.out.print("Choisissez une action (1: Tirer, 2: Rester): ");
            int choix = scanner.nextInt();
            if(choix == 1){
                croupier.distribuerCarte(paquet, joueur, true);
                if (joueur.getHand().getValue() > 21) {
                    System.out.println("Vous avez dépassé 21. Bust !");}
            }else if (choix == 2) {
                System.out.println("Vous avez choisi de rester.");
            } else {
                System.out.println("Choisissez entre 1 et 2");
            }
            
         }

    

    public void jouerTourCroupier() {
        System.out.println("\nTour du croupier :");
        while (croupier.getHand().getValue() < croupier.getValeurTotalLimit()) {
            croupier.distribuerCarte(paquet, croupier, true);
        }
        croupier.showHand(true);
    }


    public void determinerVainqueur() {
        int valeurMainJoueur = joueur.getHand().getValue();
        int valeurMainCroupier = croupier.getHand().getValue();

        System.out.println("\nRésultat de la partie :");

        if (valeurMainJoueur > 21 || (valeurMainCroupier <= 21 && valeurMainCroupier > valeurMainJoueur)) {
            System.out.println("Le croupier gagne !");
            joueur.showHand(true);

        } else if (valeurMainCroupier > 21 || (valeurMainJoueur <= 21 && valeurMainJoueur > valeurMainCroupier)) {
            int gain = 2 * (joueur.getHand().getValue() == 21 ? 3 : 2);
            joueur.setSolde(joueur.getSolde() + gain);
            System.out.println("Vous gagnez ! Gain : " + gain);
            joueur.showHand(true);
            
        } else {
            joueur.setSolde(joueur.getSolde() + joueur.getHand().getValue());
            System.out.println("Match nul. Vous récupérez votre mise.");
            joueur.showHand(true);
        }
        System.out.println("Solde actuel : " + joueur.getSolde());
    }
}
