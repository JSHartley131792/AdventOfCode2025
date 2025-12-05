package adventofcode.dayFive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ingredients {
    public class Range {
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

    public List<Range> ranges = new ArrayList<>();

    public List<Long> ingredients = new ArrayList<>();
    public long freshIngredientCount = 0;

    public boolean isInRange(long i, Range range) {
        return i >= range.lowerRange && i <= range.upperRange;
    }

    public Range parseRange(String input) {
        String[] bounds = input.split("-");
        long lower = Long.parseLong(bounds[0]);
        long upper = Long.parseLong(bounds[1]);
        return new Range(lower, upper);
    }

    public boolean isFresh(long i) {
        for (Range range : ranges) {
            if (isInRange(i, range)) {
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
    }
}
