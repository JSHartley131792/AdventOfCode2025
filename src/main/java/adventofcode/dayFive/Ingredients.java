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

    public boolean isInRange(long i, Range range) {
        return i > range.lowerRange && i < range.upperRange;
    }
}
