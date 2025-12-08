package adventofcode.daySix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cephalopod {
    public Cephalopod() {

    }

    public String[] parseLine(String string) {
        return string.trim().split("\\s+");
    }

    public Long solveForPartOne(List<String> input) {
        long sum = 0L;
        String[][] numStrings = new String[input.size() - 1][];
        for (int i = 0; i < input.size() - 1; i++) {
            numStrings[i] = parseLine(input.get(i));
        }
        String[] operationsStrings = parseLine(input.get(input.size() - 1));
        for (int i = 0; i < operationsStrings.length; i++) {
            long line = 0;
            if (operationsStrings[i].equals("+")) {
                for (String[] number : numStrings) {
                    line += Integer.parseInt(number[i]);
                }
            } else {
                line = 1;
                for (String[] number : numStrings) {
                    line *= Integer.parseInt(number[i]);
                }
            }
            sum += line;
        }
        return sum;
    }

    public List<String> readInput(String folderPath, String fileName) {
        List<String> homework = new ArrayList<>();
        File ingredientsFile = new File("src/" + folderPath + "/resources/daySix/" + fileName + ".txt");
        try (Scanner myReader = new Scanner(ingredientsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                homework.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return homework;
    }

}
