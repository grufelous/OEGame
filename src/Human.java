import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Human implements Player {
    public boolean botStatus = false;
    private int lastInput = 0;
    private String name;
    private Scanner s = new Scanner(System.in);
    private int score = 0;
    public boolean isBatting = false;
    public Human(String name) {
        System.out.println("Initialized human " + name);
        this.name = name;
    }
    public boolean isBot() {
        return botStatus;
    }
    public ScoreData selfScore = new ScoreData();
    public void makeBatter() {
        isBatting = true;
    }
    public void makeBaller() {
        isBatting = false;
    }
    public String getName(){
        return this.name;
    }
    /**
     * @JAVADOC
     * Takes in user inputs and performs necessary checks on it.
     * @return Accepted user inputs are returned.
     * */
    public int getInput() {
        out.printf("Input:\t");
        int input = 0;
        try{
            input = s.nextInt();
            if(Plop.rangeCheck(input, 1, 10)) {
                out.printf("%s's input is %d\n", name, input);
            } else {
                out.printf("Try again, %d is not within the range of 1-10, inclusive!\n", input);
                input = getInput();
            }
            updateUserData(input, isBatting);
            lastInput = input;
        } catch (InputMismatchException e) {
            out.printf("Enter just a number!\n");
            s.nextLine();
            getInput();
        }
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
    }
    public ScoreData getScoreData() {
        return selfScore;
    }
    public void updateEnemyData(Player e) {
        //User doesn't need access to bot's data
    }
}