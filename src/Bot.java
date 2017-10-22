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
    public String getRole() {
        if(isBatting) {
            return "batter";
        } else {
            return "baller";
        }
    }

    public ScoreData selfScore = new ScoreData();
    public ScoreData enemyScore;

    public Bot() {
        out.printf("Initialized a bot\n");
        this.botStatus = true;
    }

    public int getInput() {
        return (int) (1 + Math.random()*10);
    }
    public int getInput(String s) {
        int input, threshold = 5, calc = 1;
        if((s.equalsIgnoreCase("bat")) && (playCount >= threshold)) {           //if batting, will output the number with the minimum likelihood
            input = enemyScore.leastLikely();
        } else if((s.equalsIgnoreCase("ball")) && (playCount >= threshold)) {   //if balling, will output the number with the maximum likelihood
            input = enemyScore.mostLikely();
        } else {
            calc = 0;
            input = getInput();
        }
        out.printf("The projected input is %d for %s role; guessed? %d; Enemy data: /n", input, s, calc);
        playCount++;
        try{
            enemyScore.viewData();
        } catch (NullPointerException e) {
            out.printf("No data yet\n");
        }

        updateUserData(input, this.isBatting);
        return input;
    }
    public void updateEnemyData(Player e) { //must be called every time before getInput
        this.enemyScore = e.getScoreData();
    }

    public ScoreData getScoreData() {
        return selfScore;
    }

    private void updateUserData(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }
    }
}
