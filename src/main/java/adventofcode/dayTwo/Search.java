package adventofcode.dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public void parseAndCalcRanges(String inputString) {
        String[] ranges = inputString.split(",");
        for (String string : ranges) {
            String[] rangeExtremes = string.split("-");
            invalidsInRange(
                    Integer.parseInt(rangeExtremes[0]),
                    Integer.parseInt(rangeExtremes[1]));
        }
    }

    public void readRanges(String env, String fileName) {
        File rotationsFile = new File("src/" + env + "/resources/dayTwo/" + fileName + ".txt");
        try (Scanner myReader = new Scanner(rotationsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                parseAndCalcRanges(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
