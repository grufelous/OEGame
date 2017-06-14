import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Human {
    public boolean isBot = false;
    private int[] frequency = {0,0,0,0,0,0,0,0,0,0};
    private int[] recency = {1,1,1,1,1,1,1,1,1,1};
    private int lastInput;
    private String name;
    private Scanner s = new Scanner(System.in);
    private int score = 0;
    public boolean isBatting = false;
    public Human(String name) {
        this.name = name;
    }

    public int getInput() {
        out.printf("Input:\t");
        int input = s.nextInt();
        if(Plop.rangeCheck(input, 1, 10)) {
            out.printf("%s's input is %d\n", name, input);
        } else {
            out.printf("Try again, %d is not within the range of 1-10, inclusive!\n", input);
            input = getInput();
        }
        incrementScore(input, isBatting);
        lastInput = input;
        return input;
    }

    private void incrementScore(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }
        frequency[userInput-1] += 1;
        if(lastInput == userInput) {
            //Increase the recency of user input, decrement of all - a method needed!
        }
    }


}
