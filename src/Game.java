import java.util.Scanner;
import static java.lang.System.*;

public class Game {
    Player human, bot;
    private int numOfInputs = 0;
    private boolean humanOut, botOut;
    private Scanner s = new Scanner(System.in);
    public Game(Player player1, Player player2) {
        if(player1.isBot()) {
            bot = player1;
            human = player2;
            out.printf("Player 2 (%s) is not a bot", player2.getName());
        } else if(player2.isBot()){
            bot = player2;
            human = player1;
            out.printf("Player 1 (%s) is not a bot", player1.getName());
        }
        tosser();
    }

    private void tosser() {
        boolean repeat = false;
        String[] evenWords = {"e", "even"};
        String[] oddWords = {"o", "odd"};
        String[] affirmations = {"y", "yes", "yep"};
        do {
            out.printf("\tTossing...\nOdd or even? (o/e) ");
            String tossChoice = s.nextLine();
            int sum = 0;
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
                out.printf("You won the toss. Do you want to bat (1) or ball (2)? \n");
                int winnerChoice = s.nextInt();
                if(winnerChoice == 1) {
                    setRoles(human, bot);
                    play(human, bot);
                } else if (winnerChoice == 2) {
                    out.printf("You lost the toss. \n");
                    setRoles(bot, human);
                    play(bot, human);
                }
            } else {
                out.printf("You lost the toss.");
                int x = (int) Math.random()*2;
                if(x % 2 == 0) {
                    setRoles(human, bot);
                    play(human, bot);
                } else {
                    setRoles(bot, human);
                    play(bot, human);
                }
            }
            out.printf("\nPlay again (Y/N)? ");
            s.next();
            String rep = s.nextLine();
            if(Plop.containsStr(rep, affirmations)) {
                repeat = true;
            }
        } while (repeat);
    }

    private void play(Player batter, Player baller) {
        boolean playerOut = false;
        int batterScore = 0, ballerScore = 0;
        int batterNum, ballerNum;
        while (!playerOut) {
            batterNum = batter.getInput("bat");
            ballerNum = baller.getInput("ball");
            out.printf("Inputs: \tBatter: %d; Baller: %d\n", batterNum, ballerNum);
            if (batter.isBot()) {
                batter.updateEnemyData(baller);
            } else {
                baller.updateEnemyData(batter);
            }
            out.printf("Batter: %d\tBaller: %d\n", batterNum, ballerNum);
            if (ballerNum == batterNum) {
                playerOut = true;
                out.printf("Out, score of %d\n", batterScore);
            } else {
                batterScore += batterNum;
                out.printf("Not out, score of %d\n", batterScore);
            }
        }
        System.out.printf("\nScores:\n%s:\t%d\n%s:\t%d\n", batter.getName(), batterScore, baller.getName(), ballerScore);
        out.printf("\n\nNow %s is balling\n", batter.getName());
        playerOut = false;
        while (!playerOut) {
            ballerNum = baller.getInput("bat");
            batterNum = batter.getInput("ball");
            out.printf("Inputs: \tBatter: %d; Baller: %d\n", batterNum, ballerNum);
            if (!batter.isBot()) {
                baller.updateEnemyData(batter);
            } else {
                batter.updateEnemyData(baller);
            }
            System.out.printf("Batter: %d\tBaller: %d\n", ballerNum, batterNum);
            if (ballerNum == batterNum) {
                playerOut = true;
                System.out.printf("Out with a score of %d\n", ballerScore);
            } else {
                ballerScore += ballerNum;
                System.out.printf("Score of %d\n", ballerScore);
            }
        }
        System.out.printf("\nScores:\n%s:\t%d\n%s:\t%d\n", batter.getName(), batterScore, baller.getName(), ballerScore);
        if (batterScore != ballerScore) {
            String winnerName = "", loserName = "";
            int lead = 0;
            if (batterScore > ballerScore) {
                winnerName = batter.getName();
                loserName = baller.getName();
                lead = batterScore - ballerScore;
            } else {
                winnerName = baller.getName();
                loserName = batter.getName();
                lead = ballerScore - batterScore;
            }
            out.printf("%s won with a lead of %d over %s\n", winnerName, lead, loserName);
        } else {
            out.printf("Darn. A tie\n");
        }
    }
    /**
     * @JAVADOC
     * Sets the roles for the two players, in the order (batter, baller)
     * @param batter The first Player object is set to the batter role
     * @param baller The second Player object is set to the baller role
     * */
    private void setRoles(Player batter, Player baller) {
        baller.makeBaller();
        batter.makeBatter();
        out.printf("\n%s is %s;\t%s is %s\n", batter.getName(), batter.getRole(), baller.getName(), baller.getRole());
    }
}
