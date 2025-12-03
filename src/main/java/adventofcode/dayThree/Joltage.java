package adventofcode.dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Joltage {
    int totalJoltage;

    public Joltage() {}

    public int getTotalJoltage() {
        return totalJoltage;
    }

    public List<Integer> splitIntIntoDigits(String inputString, int sectionSize) {
        List<Integer> sections = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i += sectionSize) {
            String digit = inputString.substring(i, Math.min(i + sectionSize, inputString.length()));
            sections.add(Integer.parseInt(digit));
        }
        return sections;
    }

    public void findJoltage(String joltageRatings) {
        List<Integer> joltageDigits = splitIntIntoDigits(joltageRatings, 1);
        int max = joltageDigits.stream().mapToInt(x -> x).max().getAsInt();
        // protecting against max being the last digit
        int countOfMax = Collections.frequency(joltageDigits, max);
        if (countOfMax == 1) {
            int indexOfMax = joltageDigits.indexOf(max);
            if (indexOfMax + 1 == joltageDigits.size()) {
                List<Integer> afterMax = joltageDigits.subList(0, joltageDigits.size() - 1);
                int nextMax = afterMax.stream().mapToInt(x -> x).max().getAsInt();
                totalJoltage += ((nextMax * 10) + max);
            } else {
                List<Integer> afterMax = joltageDigits.subList(indexOfMax + 1, joltageDigits.size());
                int nextMax = afterMax.stream().mapToInt(x -> x).max().getAsInt();
                totalJoltage += ((max * 10) + nextMax);
            }
        } else {
            totalJoltage += ((max * 10) + max);
        }
    }

    public int readJoltages(String env, String fileName) {
        File rotationsFile = new File("src/" + env + "/resources/dayThree/" + fileName + ".txt");
        try (Scanner myReader = new Scanner(rotationsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                findJoltage(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return totalJoltage;
    }
}
