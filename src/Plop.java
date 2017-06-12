import static java.lang.System.out;

public abstract class Plop {
    public static boolean containsStr(String toFind, String[] whereToFind) {
        boolean isThere = false;
        for(int i = 0; i < whereToFind.length; i++) {
            //out.printf("Comparing %s with %s\n", toFind, whereToFind[i]);
            if(toFind.equalsIgnoreCase(whereToFind[i])) {
                isThere = true;
                break;
            }
        }
        return isThere;
    }

    public static boolean rangeCheck(int i, int min, int max) {
        /**
         * @JAVADOC
         * Inclusive range check method
         * */
        boolean inRange = false;
        if((min <= i) && (i <= max)) {
            inRange = true;
        }
        return inRange;
    }
}
