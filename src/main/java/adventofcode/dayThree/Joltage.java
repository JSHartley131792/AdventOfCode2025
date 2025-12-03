package adventofcode.dayThree;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Joltage {
    BigInteger totalJoltage;

    public Joltage(BigInteger totalJoltage) {
        this.totalJoltage = totalJoltage;
    }

    public BigInteger getTotalJoltage() {
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

    public void recursivelyFindMaxDigit(String joltageRatings, int index, int max, List<Integer> digits) {
        if (max <= 0) return;
        int newIndex = 0;
        int largest = 0;
        for (int i = index; i < joltageRatings.length()-max; i++) {
            int num = Integer.parseInt(String.valueOf(joltageRatings.charAt(i)));
            if (num > largest) {
                largest = num;
                newIndex = i;
            }
        }
        digits.add(largest);
        recursivelyFindMaxDigit(joltageRatings, newIndex+1, max-1, digits);
    }

    public void findJoltage(String joltageRatings) {
        List<Integer> digits = new ArrayList<>();
        recursivelyFindMaxDigit(joltageRatings, 0, 12, digits);
        String numberString = digits.stream().map(x -> x.toString()).collect(Collectors.joining());
        totalJoltage = totalJoltage.add(new BigInteger(numberString));
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
