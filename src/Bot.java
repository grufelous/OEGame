import static java.lang.System.out;


public class Bot {
    String level;
    String[] levels = {"easy", "medium", "difficult"};
    public Bot(String level) {
        out.println(level);
        if (Plop.containsStr(level, levels)) {
            this.level = level;
        }
        out.printf("Level: %s\n", this.level);
    }
}
