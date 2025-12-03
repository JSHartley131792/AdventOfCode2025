package adventofcode.dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Joltage {
    BigInteger totalJoltage;

    public Joltage(BigInteger totalJoltage) {
        this.totalJoltage = totalJoltage;
    }

    public BigInteger getTotalJoltage() {
        return totalJoltage;
    }

    public class MaxDigit {
        int index;
        int value;

        public MaxDigit(int index,int value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<Integer> splitIntIntoDigits(String inputString, int sectionSize) {
        List<Integer> sections = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i += sectionSize) {
            String digit = inputString.substring(i, Math.min(i + sectionSize, inputString.length()));
            sections.add(Integer.parseInt(digit));
        }
        return sections;
    }

    public MaxDigit findMaxDigit(String joltageRatings, int index, int max) {
        int newIndex = 0;
        int largest = 0;
        for (int i = index; i < joltageRatings.length() - max; i++) {
            int num = Integer.parseInt(String.valueOf(joltageRatings.charAt(i)));
            if (num > largest) {
                largest = num;
                newIndex = i;
            }
        }
        return new MaxDigit(newIndex, largest);
    }

    public void findJoltage(String joltageRatings) {
        long result = 0;
        int index = 0;
        for (int i = 11; i >= 0; i--) {
            MaxDigit max = findMaxDigit(joltageRatings, index, i);
            index = max.index + 1;
            long holdingValue = (long) (max.value * Math.pow(10, i));
            result += holdingValue;
        }
        totalJoltage = totalJoltage.add(new BigInteger(String.valueOf(result)));
    }

    public BigInteger readJoltages(String env, String fileName) {
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
