package adventofcode.dayFive;

public class Ingredients {
    public class Range{
        long lowerRange;
        long upperRange;

        public Range(long lower, long upper) {
            this.lowerRange = lower;
            this.upperRange = upper;
        }
    }

    public Ingredients() {

    }

    public boolean isInRange(int i, Range range) {
        return false;
    }
}
