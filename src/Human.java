import java.util.Scanner;
import static java.lang.System.out;

public class Human implements Player {
    public boolean isBot = false;
    /*private int[] frequency = {0,0,0,0,0,0,0,0,0,0};
    private int[] recency = {1,1,1,1,1,1,1,1,1,1};
    private int[] currentStreak = {0,0};        //first element is the number, second is its longest streak*/
    private int lastInput = 0;
    private String name;
    private Scanner s = new Scanner(System.in);
    private int score = 0;
    public boolean isBatting = false;
    public Human(String name) {
        this.name = name;
    }
    public ScoreData selfScore = new ScoreData();
    /**
     * @JAVADOC
     * Takes in user inputs and performs necessary checks on it.
     * @return Accepted user inputs are returned.
     * */
    public int getInput() {
        out.printf("Input:\t");
        int input = s.nextInt();
        if(Plop.rangeCheck(input, 1, 10)) {
            out.printf("%s's input is %d\n", name, input);
        } else {
            out.printf("Try again, %d is not within the range of 1-10, inclusive!\n", input);
            input = getInput();
        }
        updateUserData(input, isBatting);
        lastInput = input;
        return input;
    }

    public int getUnbiasedInput() {
        return getInput();
    }

    /**
     * @JAVADOC
     * Updates the Player's fields and increments score if they are batting
     * @param isBatting If it is true, then the player's score will be incremented
     * @param userInput The user's input is used to update data arrays and find streaks
     * */
    private void updateUserData(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }
        selfScore.update(userInput);
        /*frequency[userInput-1] += 1;
        if(lastInput == userInput) {
            currentStreak[0] = userInput;
            currentStreak[1]++;
        } else {
            currentStreak[0] = userInput;
            currentStreak[1] = 1;
        }
        for(int i = 0; i < userInput-1; i++) {
            if(recency[i] > 1) {
                recency[i]--;
            } else {
                recency[i] = 1;
            }
        }
        recency[userInput-1] += currentStreak[1];
        for(int i = userInput; i < 10; i++) {
            if(recency[i] > 1) {
                recency[i]--;
            } else {
                recency[i] = 1;
            }
        }*/
    }
    public ScoreData getScoreData() {
        return selfScore;
    }
}