public interface Player {


    public ScoreData selfScore = new ScoreData();
    public boolean isBot = false;
    public int getInput();
    public boolean isBatting = false;
    //public int[] getFrequency();
    //public int[] getRecency();
    public int getUnbiasedInput();

}
