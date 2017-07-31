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
            out.printf("Player 2 (%s) is not a bot", player2.getName());
        } else if(player2.isBot){
            bot = player2;
            human = player1;
            out.printf("Player 1 (%s) is not a bot", player1.getName());
        }
        out.printf("The names are %s and %s", player1.getName(), player2.getName());
        //tosser();
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
            int sum = 0;
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
            /*if(canChose) {
                out.printf("You won the toss. Do you want to bat (1) or ball (2)?");
                int winnerChoice = s.nextInt();
                if(winnerChoice == 1) {
                    setRoles(human, bot);
                    play(human, bot);
                } else if (winnerChoice == 2) {
                    setRoles(bot, human);
                    play(bot, human);
                }

            }*/
        } while (repeat);
    }

    public /*private*/void play(Player batter, Player baller) {
        boolean out = false;
        int batterScore = 0, ballerScore = 0;
        int batterNum, ballerNum;
        while(!out) {
            batterNum = batter.getInput();
            ballerNum = baller.getInput();
            System.out.printf("Batter: %d\tBaller: %d\n", ballerNum, ballerNum);
            if(ballerNum == batterNum) {
                out = true;
                System.out.printf("Out with a score of %d\n", batterScore);
            } else {
                batterScore += batterNum;
                System.out.printf("Score of %d\n", batterScore);
            }
        }
        System.out.printf("\n\n");
        out = false;
        while(!out) {
            ballerNum = baller.getInput();
            batterNum = batter.getInput();
            System.out.printf("Batter: %d\tBaller: %d\n", ballerNum, ballerNum);
            if(ballerNum == batterNum) {
                out = true;
                System.out.printf("Out with a score of %d\n", ballerScore);
            } else {
                ballerScore += ballerNum;
                System.out.printf("Score of %d\n", ballerScore);
            }
        }
    }
    private void setRoles(Player batter, Player baller) {
        baller.makeBaller();
        batter.makeBatter();
    }
}
