package adventofcode.dayTwo;

public class Search {
    int invalidCounter = 0;
    int invalidTotal = 0;

    public Search() {
        
    }

    public int getCounter() {
        return invalidCounter;
    }
    
    public int getInvalidTotal() {
        return invalidTotal;
    }

    public boolean isInvalid(int i) {
        String numberString = Integer.toString(i);
        if (numberString.length() % 2 == 0) {
            String firstHalf = numberString.substring(0, (numberString.length() / 2));
            String secondHalf = numberString.substring((numberString.length() / 2), numberString.length());
            return firstHalf.equals(secondHalf);
        } else {
            return false;
        }
    }

    public void invalidsInRange(int rangeStart, int rangeEnd) {
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (isInvalid(i) == true) {
                invalidCounter += 1;
                invalidTotal += i;
            }
        }
    }
}
