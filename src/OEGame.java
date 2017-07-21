import static java.lang.System.*;

public class OEGame {
    public static void main(String[] args) {
        out.printf("Welcome to OEGame\n\n");
        Bot b = new Bot();
        Human h = new Human("QwertyMan");
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getInput();
        h.getScoreData().viewData();

        //h.getInput();

    }
}
