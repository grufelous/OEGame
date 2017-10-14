import static java.lang.System.out;

public class Bot implements Player {
    public boolean botStatus = true;
    public boolean isBatting = false;
    private static int playCount = 0;
    private int score = 0;
    //private int lastInput = 0;

    public void makeBatter() {
        isBatting = true;
    }
    public void makeBaller() {
        isBatting = false;
    }
    public String getName(){
        return "Bot";
    }
    public boolean isBot() {
        return botStatus;
    }

    public ScoreData selfScore = new ScoreData();
    public ScoreData enemyScore;

    public Bot() {
        out.printf("Initialized a bot\n");
        this.botStatus = true;
    }

    public int getInput() {
        int input, threshold = 0/*5*/;
        if(playCount >= threshold){
            out.printf("Finding the most likely input\n");
            input = enemyScore.mostLikely();
        } else {
            out.printf("Finding an unbiased input\n");
            input = getUnbiasedInput();
        }
        playCount++;
        updateUserData(input, this.isBatting);
        return input;
    }
    public void updateEnemyData(Player e) { //must be called every time before getInput
        this.enemyScore = e.getScoreData();
    }

    public ScoreData getScoreData() {
        return selfScore;
    }

    public int getUnbiasedInput() {
        return (int) (1 + Math.random()*10);
    }

    private void updateUserData(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }
    }
}
