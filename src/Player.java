public interface Player {
    /*@TODO:
    * Convert to abstract class with Human and Bot extending it
    * */

    public ScoreData selfScore = new ScoreData();
    public ScoreData getScoreData();
    public void makeBatter();
    public void makeBaller();
    public String getName();
    public String getRole();
    public boolean isBot();
    public int getInput();
    public int getInput(String s);
    public boolean isBatting = false;
    public void updateEnemyData(Player e);
    //public int[] getFrequency();
    //public int[] getRecency();
    public int getUnbiasedInput();

}
