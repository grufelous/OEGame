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
        } else if(player2.isBot){
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
                sum = bot.getUnbiasedInput() + human.getUnbiasedInput();
                if(sum%2 == 0) {
                    canChose = true;
                }
            } else if(Plop.containsStr(tossChoice, oddWords)) {
                sum = bot.getUnbiasedInput() + human.getUnbiasedInput();
                if(sum%2 != 0) {
                    canChose = true;
                }
            } else {
                out.printf("Either enter even or odd!\n");
                tosser();
            }
            if(canChose) {
                out.printf("You won the toss. Do you want to bat (1) or ball (2)?");
                int winnerChoice = s.nextInt();
                if(winnerChoice == 1) {
                    setRoles(human, bot);
                    play(human, bot);
                } else if (winnerChoice == 2) {
                    setRoles(bot, human);
                    play(bot, human);
                }

            }
        } while (repeat);
    }

    private void play(Player batter, Player baller) {
        boolean out = false;
        int batterScore, ballerScore;
        int batterNum, ballerNum;
        while(!out) {
            batterNum = batter.getInput();
            ballerNum = baller.getInput();
            if(ballerNum == batterNum) {
                out = true;
            } else {

            }
        }
    }
    private void setRoles(Player batter, Player baller) {
        baller.makeBaller();
        batter.makeBatter();
    }
}
