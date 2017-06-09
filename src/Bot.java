import static java.lang.System.out;

public class Bot {
    String level;
    String[] levels = {"easy", "medium", "difficult"};
    public Bot(String level) {
        out.print(level);
        for(int i = 0; i < 3; i++) {
            if(level.equalsIgnoreCase(levels[i])) {
                this.level = levels[i];
                break;
            }
        }
        out.printf("Level: %s\n", this.level);
    }
}
