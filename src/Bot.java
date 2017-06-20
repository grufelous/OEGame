import static java.lang.System.out;

public class Bot implements Player {
    public boolean isBot = true;
    private int[] frequency = {0,0,0,0,0,0,0,0,0,0};
    private int[] recency = {1,1,1,1,1,1,1,1,1,1};
    private int[] enemyFrequency = {0,0,0,0,0,0,0,0,0,0};
    private int[] enemyRecency = {1,1,1,1,1,1,1,1,1,1};
    private int[] enemyLikelihood = {0,0,0,0,0,0,0,0,0,0};
    private int[] currentStreak = {0,0};        //first element is the number, second is its longest streak
    public boolean isBatting = false;
    private int score = 0;
    private int lastInput = 0;

    public Bot() {
        out.printf("Initialized a bot\n");
    }

    public int getInput() {
        int input = 0;              //if input is 0, it means that it has not been computed yet
        int highestLikelihood = 0, index = -1; //taking highestLikelihood as 0 as in all likelihood, some value will be non zero after the first run
        //finds the greatest enemy likelihood
        for(int i = 0; i < 10; i++) {
            enemyLikelihood[i] = enemyFrequency[i]*enemyRecency[i];
            if(enemyLikelihood[i] > highestLikelihood) {
                highestLikelihood = enemyLikelihood[i];
                index = i;
            }
        }
        if(highestLikelihood == 0) {
            input = (int) (1 + Math.random() * 10);
        } else {
            input = index+1;
        }
        input = index+1;
        updateUserData(input, isBatting);
        lastInput = input;
        return input;
    }

    public void updateEnemyData(Player e) {
        enemyFrequency = e.getFrequency();
        enemyRecency = e.getRecency();
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
            currentStreak[0] = userInput;
            currentStreak[1]++;
        } else {
            currentStreak[0] = userInput;
            currentStreak[1] = 1;
        }
        for(int i = 0; i < userInput-1; i++) {
            if(recency[i] > 1) {
                recency[i]--;
            } else {
                recency[i] = 1;
            }
        }
        recency[userInput-1] += currentStreak[1];
        for(int i = userInput; i < 10; i++) {
            if(recency[i] > 1) {
                recency[i]--;
            } else {
                recency[i] = 1;
            }
        }
    }
}
