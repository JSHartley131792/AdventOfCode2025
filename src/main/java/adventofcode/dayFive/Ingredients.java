package adventofcode.dayFive;

public class Ingredients {
    public class Range{
        long lowerRange;
        long upperRange;

        public Range(long lower, long upper) {
            this.lowerRange = lower;
            this.upperRange = upper;
        }

        public long getLower() {
            return this.lowerRange;
        }
        
        public long getUpper() {
            return this.upperRange;
        }
    }

    public Ingredients() {

    }

    public boolean isInRange(long i, Range range) {
        return i > range.lowerRange && i < range.upperRange;
    }

    public Range parseRange(String input) {
        return new Range(1, 2);
    }
}
