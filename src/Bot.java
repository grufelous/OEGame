import static java.lang.System.out;

public class Bot implements Player {
    public boolean isBot = true;
    private int[] frequency = {0,0,0,0,0,0,0,0,0,0};
    private int[] recency = {1,1,1,1,1,1,1,1,1,1};
    public boolean isBatting = false;
    private int score = 0;
    private int lastInput = 0;
    public Bot() {
        out.printf("Initialized a bot\n");
    }

    public int getInput() {
        int input = 0;              //if input is 0, it means that it has not been computed yet
        input = (int) (1 + Math.random() * 10);
        updateUserData(input, isBatting);
        lastInput = input;
        return input;
    }

    public int[] getFrequency() {
        return frequency;
    }
    public int[] getRecency() {
        return recency;
    }

    private void updateUserData(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }
        frequency[userInput-1] += 1;
        if(lastInput == userInput) {
            //Increase the recency of user input, decrement of all - a method needed!
        }
    }
}
