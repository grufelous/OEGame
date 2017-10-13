import java.util.ArrayList;

import static java.lang.System.out;

public class ScoreData {
    /**
     * Frequency and Recency
     * Frequency:
     * 10 ints in the array hold the count of the (i+1)th number's frequency in the game (i denotes index)
     * Recency:
     * Recency has a minimum value of 1
     * Whenever an (i+1) number is obtained as an input, the ith input is incremented by its streak amount
     * Otherwise it is degenerated by 1, applying the minimum value condition
     * Relative probability is calculated as each i's (frequency * recency)
     * */
    private int[] frequency = {0,0,0,0,0,0,0,0,0,0};
    private double[] recency = {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0};
    private double[] likelihood = {1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0};
    private ArrayList<Integer> streakList = new ArrayList<Integer>();
    private int currentStreak = 1;
    private int lastInput = 0;
    private int multiplier = 1;

    public ScoreData() {
        streakList.add(3);
        streakList.add(5);
    }
    private void increaseFrequency(int number) {
        frequency[number-1]++;
    }

    public int[] getFrequency() {
        return frequency;
    }

    private void updateRecency(int number) {
        for(int i = 0; i < 10; i++) {
            recency[i]--;
            if(i+1 == number) {
                recency[i] += (sumStreakList() / currentStreak)*multiplier;
            } else {
                if(recency[i] < 1) {
                    recency[i] = 1;
                }
            }
        }
    }
    private double averageLikelihood() {
        double sum = 0;
        for(double i : likelihood) {
            sum += i;
        }
        return sum / likelihood.length;
    }
    public double[] getRecency() {
        return recency;
    }

    private void updateLikelihood() {
        //at present recency and likelihood are same. This will change as I study more.
        likelihood = recency;
    }

    private float sumStreakList() {
        float sumStreak = 0;
        for(int i : streakList) {
            sumStreak += i;
        }
        return sumStreak;
    }

    /**
     * @JAVADOC
     *  Called to update the player's score data
     *  @param number The number input by the player
     **/
    public void update(int number) {
        increaseFrequency(number);
        if(number == lastInput) {
            currentStreak++;
            if(streakList.contains(currentStreak)) {
                multiplier = 3;
            } else {
                multiplier = 2;
            }
        } else {
            lastInput = number;
            currentStreak =+ 1;
            multiplier = 1;
        }
        updateRecency(number);
    }

    public int mostLikely() {
        int i = -1;
        //highest likelihood is the most probable
        int bigg = (int) likelihood[0];
        for(int j = 0; j < 10; j++) {
            if(bigg < (int) likelihood[j]) {
                bigg = (int) likelihood[j];
                i = j;
            } else if (bigg == (int) likelihood[j]) {
                //create an arraylist? Choose randomly from the most likely ones?
            }
        }
        if(i == -1) {
            i = (int) (Math.random() * 9);
        }
        return i+1;
    }

    public void viewData() {
        out.printf("#\tfreq\trec\n");
        for(int i = 0; i < 10; i++) {
            out.printf("%d\t%d\t%d\n", i+1, frequency[i], (int) recency[i]);
        }
    }
}