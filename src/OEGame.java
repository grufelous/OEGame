import static java.lang.System.*;

public class OEGame {
    public static void main(String[] args) {
        out.printf("Welcome to OEGame\n\n");
        Bot b = new Bot();
        Human h = new Human("QwertyMan");
        /*for(int i = 0; i < 20; i++) {
            h.getInput();
        }
        h.getScoreData().viewData();
        Game g = new Game(h, b);*/

        //h.getInput();
        System.out.println(b.getUnbiasedInput());
    }
}
