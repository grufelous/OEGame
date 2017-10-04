import static java.lang.System.out;

public class Bot implements Player {
    public boolean botStatus = true;
    public boolean isBatting = false;
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
        int input = enemyScore.mostProbable();
        /*int highestLikelihood = 0, index = -1; //taking highestLikelihood as 0 as in all likelihood, some value will be non zero after the first run
        //finds the greatest enemy likelihood

        for(int i = 0; i < 10; i++) {
            enemyLikelihood[i] = enemyFrequency[i]*enemyRecency[i];
            if(enemyLikelihood[i] > highestLikelihood) {
                highestLikelihood = enemyLikelihood[i];
                index = i;
            }
        }
        if(highestLikelihood == 0) {
            input = getUnbiasedInput();
        } else {
            input = index+1;
        }
        input = index+1;
        updateUserData(input, isBatting);
        lastInput = input;*/
        return input;
    }
    public void updateEnemyData(Player e) { //must be called every time before getInput
        this.enemyScore = e.getScoreData();
    }

    public ScoreData getScoreData() {
        return selfScore;
    }

    /*public int[] getFrequency() {
        return frequency;
    }*/
    /*public int[] getRecency() {
        return recency;
    }*/
    public int getUnbiasedInput() {
        return (int) (1 + Math.random()*10);
    }

    private void updateUserData(int userInput, boolean isBatting) {
        if(isBatting) {
            score += userInput;
        }


        /*frequency[userInput-1] += 1;
        if(lastInput == userInput) {
            currentStreak[0] = userInput;
            if((currentStreak[1] == 2) || ((currentStreak[1] == 4))) {      //third and fifth time lucky
                currentStreak[1] *= 2;
            } else if ((currentStreak[1] == 3) || (currentStreak[1] == 5)) {
                currentStreak[1] /= 2;
            }
            currentStreak[1]++;

        } else {
            currentStreak[0] = userInput;
            currentStreak[1] = 1;
        }
        for(int i = 0; i < userInput-1; i++) {
            recencyCycle(recency[i]);
        }
        recency[userInput-1] += currentStreak[1];
        for(int i = userInput; i < 10; i++) {
            recencyCycle(recency[i]);
        }*/
    }

    private void recencyCycle(int rec) {
        if(rec > 1) {
            rec--;
        } else {
            rec = 1;
        }
    }
}
