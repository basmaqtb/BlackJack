
import java.util.Scanner;

 class Blackjack {
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
public Blackjack(){}
    public void commencerPartie() {
        
        placerMise();

        
        distribuerCartesInitiales();

        
        jouerTourJoueur();

        
        jouerTourCroupier();

        // winner
        determinerVainqueur();

        // Start a new game
        nouvellePartie();
    }

    private void placerMise() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Placez votre mise : ");
        int mise = scanner.nextInt();

        joueur.setSolde(joueur.getSolde() - mise);
        System.out.println("Mise placée : " + mise);
        scanner.close();
    }

    private void distribuerCartesInitiales() {
        croupier.distribuerCarte(paquet, croupier, true);
        croupier.distribuerCarte(paquet, croupier, false);

        croupier.distribuerCarte(paquet, joueur, true);
        croupier.distribuerCarte(paquet, joueur, true);
        

        // joueur.showHand(true);
        // croupier.showHand(false);
    }

    private void jouerTourJoueur() {
        Scanner scanner = new Scanner(System.in);

            joueur.showHand(true);
            System.out.println("Valeur totale de votre main : " + joueur.getHand().getValue());

            System.out.print("Choisissez une action (1: Tirer, 2: Rester): ");
            String choix = scanner.nextLine();
            scanner.nextLine();
            switch (choix) {
                case "1":
                    croupier.distribuerCarte(paquet, joueur, true);
                    if (joueur.getHand().getValue() > 21) {
                        System.out.println("Vous avez dépassé 21. Bust !");
                    }
                    break;

                case "2":
                System.out.println("Vous avez choisi de rester.");
                    break;
                default:
                System.out.println("choisir entre 1 et 2");
                    break;
            }
            
    }

    private void jouerTourCroupier() {
        System.out.println("\nTour du croupier :");

        while (croupier.getHand().getValue() < croupier.getValeurTotalLimit()) {
            croupier.distribuerCarte(paquet, croupier, true);
        }

        croupier.showHand(true);
    }

    private void determinerVainqueur() {
        int valeurMainJoueur = joueur.getHand().getValue();
        int valeurMainCroupier = croupier.getHand().getValue();

        System.out.println("\nRésultat de la partie :");

        if (valeurMainJoueur > 21 || (valeurMainCroupier <= 21 && valeurMainCroupier > valeurMainJoueur)) {
            System.out.println("Le croupier gagne !");
            joueur.showHand(true);
        } else if (valeurMainCroupier > 21 || (valeurMainJoueur <= 21 && valeurMainJoueur > valeurMainCroupier)) {
            int gain = 2 * (joueur.getHand().getValue() == 21 ? 3 : 2); // Blackjack pays 3:2
            joueur.setSolde(joueur.getSolde() + gain);
            System.out.println("Vous gagnez ! Gain : " + gain);
            joueur.showHand(true);
        } else {
            joueur.setSolde(joueur.getSolde() + joueur.getHand().getValue()); // Push, joueur récupère sa mise
            System.out.println("Match nul. Vous récupérez votre mise.");
            joueur.showHand(true);
        }

        System.out.println("Solde actuel : " + joueur.getSolde());
    }

    private void nouvellePartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nVoulez-vous démarrer une nouvelle partie ? (1: Oui, 2: Non): ");
        int choix = scanner.nextInt();

        if (choix == 1) {
            // Reset hands and start a new game
            joueur.getHand().getListeCarte().clear();
            croupier.getHand().getListeCarte().clear();
            paquet = new Deck();
            paquet.shuffleCards();
            commencerPartie();
        } else {
            System.out.println("Merci d'avoir joué au Blackjack !");
        }
        scanner.close();
    }
}
