package adventofcode.dayFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ingredients {
    public class Range implements Comparable<Range> {
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

        public long length() {
            return upperRange - lowerRange + 1L;
        }

        public boolean isInRange(long i) {
            return i >= lowerRange && i <= upperRange;
        }

        public boolean isOverlap(Range r) {
            return (r.lowerRange >= lowerRange && r.lowerRange <= upperRange)
                    || (r.upperRange >= lowerRange && r.upperRange <= upperRange);
        }

        @Override
        public int compareTo(Range r) {
            if (lowerRange == r.lowerRange) {
                return Long.compare(upperRange, r.upperRange);
            }
            return lowerRange < r.lowerRange ? -1 : 1;
        }
    }

    public Ingredients() {
    }

    public List<Range> ranges = new ArrayList<>();

    public List<Long> ingredients = new ArrayList<>();
    public long freshIngredientCount = 0;
    public long maxFreshUniqueIngredientCount = 0;
    public Set<Long> possibleFreshIngredients = new HashSet<>();

    public Range parseRange(String input) {
        String[] bounds = input.split("-");
        long lower = Long.parseLong(bounds[0]);
        long upper = Long.parseLong(bounds[1]);
        return new Range(lower, upper);
    }

    public boolean isFresh(long i) {
        for (Range range : ranges) {
            if (range.isInRange(i)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public void checkIngredients() {
        for (Long ingredient : ingredients) {
            if (isFresh(ingredient)) {
                freshIngredientCount++;
            } else {
                continue;
            }
        }
    }

    public void checkMaxFreshIngredients() {
        List<Range> reduced = reduce(ranges);
        for (Range range : reduced) {
            maxFreshUniqueIngredientCount += range.length();
        }
    }

    public boolean isRangeString(String string) {
        return string.matches("[0-9]+-[0-9]+");
    }

    public void readIngredients(String env, String fileName) {
        File ingredientsFile = new File("src/" + env + "/resources/dayFive/" + fileName + ".txt");
        try (Scanner myReader = new Scanner(ingredientsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (isRangeString(data)) {
                    ranges.add(parseRange(data));
                } else if (data.equals("")) {
                    continue;
                } else {
                    ingredients.add(Long.valueOf(data));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        checkIngredients();
        checkMaxFreshIngredients();
    }

    public List<Range> reduce(List<Range> ranges) {
        Collections.sort(ranges);
        List<Range> reduced = new ArrayList<>();
        reduced.add(ranges.remove(0));
        for (Range range : ranges) {
            boolean merged = false;
            for (int i = 0; i < reduced.size(); i++) {
                Range comparing = reduced.get(i);
                if (comparing.isOverlap(range)) {
                    Range newRange = new Range(comparing.getLower(), Math.max(comparing.upperRange, range.upperRange));
                    reduced.set(i, newRange);
                    merged = true;
                    break;
                }
            }
            if (!merged) {
                reduced.add(range);
            }
        }
        return reduced;
    }
}
