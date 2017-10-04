public interface Player {
    /*@TODO:
    * Convert to abstract class with Human and Bot extending it
    * */

    public ScoreData selfScore = new ScoreData();
    public ScoreData getScoreData();
    public void makeBatter();
    public void makeBaller();
    public String getName();
    public boolean isBot();
    public int getInput();
    public boolean isBatting = false;
    //public int[] getFrequency();
    //public int[] getRecency();
    public int getUnbiasedInput();

}
