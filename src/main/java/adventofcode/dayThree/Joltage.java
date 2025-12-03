package adventofcode.dayThree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joltage {

    public static List<Integer> splitIntIntoDigits(String inputString, int sectionSize) {
        List<Integer> sections = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i += sectionSize) {
            String digit = inputString.substring(i, Math.min(i + sectionSize, inputString.length()));
            sections.add(Integer.parseInt(digit));
        }
        return sections;
    }

    public static int findJoltage(String joltageRatings) {
        List<Integer> joltageDigits = splitIntIntoDigits(joltageRatings, 1);
        int max = joltageDigits.stream().mapToInt(x -> x).max().getAsInt();
        // protecting against max being the last digit
        int countOfMax = Collections.frequency(joltageDigits, max);
        if (countOfMax == 1) {
            int indexOfMax = joltageDigits.indexOf(max);
            if (indexOfMax + 1 == joltageDigits.size()) {
                List<Integer> afterMax = joltageDigits.subList(0, joltageDigits.size() - 1);
                int nextMax = afterMax.stream().mapToInt(x -> x).max().getAsInt();
                return (nextMax * 10) + max;
            } else {
                List<Integer> afterMax = joltageDigits.subList(indexOfMax + 1, joltageDigits.size());
                int nextMax = afterMax.stream().mapToInt(x -> x).max().getAsInt();
                return (max * 10) + nextMax;
            }
        } else {
            return (max * 10) + max;
        }
    }
}
