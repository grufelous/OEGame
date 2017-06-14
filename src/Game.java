import java.util.Scanner;
import static java.lang.System.out;

public class Game {
    Player human, bot;
    private int numOfInputs = 0;
    private boolean humanOut, botOut;
    private Scanner s = new Scanner(System.in);
    public Game(Player player1, Player player2) {
        if(player1.isBot) {
            bot = player1;
            human = player2;
        } else {
            bot = player2;
            human = player1;
        }
        tosser();
    }

    /**
     * @TODO:
     * + The tosser - bat or ball chooser
     * + Inputs from the players and managers of the arrays
     * ? Streaks with special bonus likelihoods for special streaks (like 3 numbers, or frequent user patterns)
     * */

    private void tosser() {
        boolean repeat = false;
        String[] evenWords = {"e", "even"};
        String[] oddWords = {"o", "odd"};
        do {
            out.printf("\tTossing...\nOdd or even? (o/e)");
            String tossChoice = s.nextLine();
            int sum;
            boolean canChose = false;
            if(Plop.containsStr(tossChoice, evenWords)) {
                sum = bot.getInput() + human.getInput();
                if(sum%2 == 0) {
                    canChose = true;
                }
            } else if(Plop.containsStr(tossChoice, oddWords)) {
                sum = bot.getInput() + human.getInput();
                if(sum%2 != 0) {
                    canChose = true;
                }
            } else {
                out.printf("Either enter even or odd!\n");
                tosser();
            }
            if(canChose) {
                out.printf("Do you want to bat (1) or ball (2)?");

            }
        } while (repeat);
    }

}
