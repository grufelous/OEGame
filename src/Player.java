public interface Player {
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
