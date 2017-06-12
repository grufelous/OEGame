import java.util.Scanner;
import static java.lang.System.out;

public class Human {
    public boolean isBot = false;
    String name;
    Scanner s = new Scanner(System.in);
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
        return input;
    }


}
