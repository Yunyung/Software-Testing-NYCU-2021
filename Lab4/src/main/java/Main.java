import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Game.R_P_S p1;
        Game.R_P_S p2;
        Scanner scanner = new Scanner(System.in);

        // Player 1 input
        System.out.print("Enter Player 1(P1) choice [rock, paper or scissors] : ");
        String s1 = scanner.nextLine();
        try {
            game.isValidInput(s1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception in thread 'main' " + e + " : Bad Choice!");
            System.exit(0);
        }
        p1 = game.assignR_P_S(s1);

        // Player 2 input
        System.out.print("Enter Player 2(P2) choice [rock, paper or scissors] : ");
        String s2 = scanner.nextLine();
        try {
            game.isValidInput(s2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception in thread 'main' " + e + " : Bad Choice!");
            System.exit(0);
        }
        p2 = game.assignR_P_S(s2);

        // get Winner
        Game.WhoWinner winner = game.getWinnerOfGame(p1, p2);
        if (winner == Game.WhoWinner.DRAW) {
            System.out.println("Draw!");
        } else {
            System.out.println(winner.toString() + " win!");
        }
    }


}
