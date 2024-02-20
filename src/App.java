import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Blackjack blackjack = new Blackjack("joueur", 1000, 30000);

        System.out.println("Que voulez-vous faire ?");
        System.out.println("1- Commencer une partie");
        System.out.println("2- Consulter votre solde");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                blackjack.commencerPartie();
                break;
            case 2:
                System.out.println("Solde actuel : " + blackjack.getPlayer().getSolde());
                break;
            default:
                System.out.println("Veuillez entrer l'un de ces choix!");
                break;
        }
        scanner.close();
    }
}
