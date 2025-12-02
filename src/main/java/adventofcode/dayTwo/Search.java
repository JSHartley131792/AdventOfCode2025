package adventofcode.dayTwo;

public class Search {

    public static boolean isInvalid(int i) {
        String numberString = Integer.toString(i);
        if (numberString.length() % 2 == 0) {
            String firstHalf = numberString.substring(0, (numberString.length() / 2));
            String secondHalf = numberString.substring((numberString.length() / 2), numberString.length());
            return firstHalf.equals(secondHalf);
        } else {
            return false;
        }
    }
}
