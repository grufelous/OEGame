import static java.lang.System.*;

public class OEGame {
    public static void main(String[] args) {
        out.printf("Welcome to OEGame\n\n");
        Bot b = new Bot();
        Human h = new Human("QwertyMan");
        Game g = new Game(h, b);
        /*for(int i = 0; i < 15; i++) {
            h.getInput();
        }
        h.selfScore.viewData();
        b.updateEnemyData(h);

        for(int i = 0; i < 15; i++) {
            out.println(b.getInput());
        }*/

        //out.println(b.getInput());

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
