package adventofcode.dayTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    long invalidCounter;
    long invalidTotal;

    public Search() {

    }

    public long getCounter() {
        return invalidCounter;
    }

    public long getInvalidTotal() {
        return invalidTotal;
    }

    public static List<String> splitStringIntoSections(String inputString, int sectionSize) {
        List<String> sections = new ArrayList<>();
        for (int i = 0; i < inputString.length(); i += sectionSize) {
            sections.add(inputString.substring(i, Math.min(i + sectionSize, inputString.length())));
        }
        return sections;
    }

    public boolean isInvalid(long i) {
        String numberString = String.valueOf(i);
        int length = numberString.length();
        for (int j = 1; j < length; j++) {
            List<String> splitStrings = splitStringIntoSections(numberString, j);
            boolean isInvalid = splitStrings.stream().distinct().count() == 1;
            if (isInvalid == true)
                return isInvalid;
        }
        return false;
    }

    public void invalidsInRange(long rangeStart, long rangeEnd) {
        for (long i = rangeStart; i <= rangeEnd; i++) {
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
                    Long.valueOf(rangeExtremes[0]),
                    Long.valueOf(rangeExtremes[1]));
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
