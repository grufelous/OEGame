import static java.lang.System.*;

public class OEGame {
    public static void main(String[] args) {
        out.printf("Welcome to OEGame\n\n");
        Bot b = new Bot();
        Human h = new Human("QwertyMan");

        h.getInput();
        h.selfScore.viewData();
        h.makeBatter();
        h.getInput();
        h.selfScore.viewData();
        /*for(int i = 0; i < 20; i++) {
            h.getInput();
        }
        h.getScoreData().viewData();*/
        //Game g = new Game(h, b);

        //h.getInput();

        /*for(int i = 0; i < 20; i++) {
            System.out.println(b.getUnbiasedInput());
        }*/
        //b.getScoreData().viewData();
    }
}
