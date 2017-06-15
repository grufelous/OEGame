import static java.lang.System.out;

public abstract class Plop {
    /**
     * @JAVADOC
     * Checks for the first argument in the second, which is an array.
     * Not case sensitive
     * @param   toFind The string to look for
     * @param   whereToFind The string array where toFind is looked in
     * @return  true if the string is present in the array
     * */
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

    /**
     * @JAVADOC
     * Checks whether the given number is within the range specified by the two limits, inclusive
     * @param i The number to check
     * @param min   The minimum number over which i must exist
     * @param max   The maximum number under which i must exist
     * @return  true if i is between min and max, inclusive
     * */
    public static boolean rangeCheck(int i, int min, int max) {
        boolean inRange = false;
        if((min <= i) && (i <= max)) {
            inRange = true;
        }
        return inRange;
    }
}
