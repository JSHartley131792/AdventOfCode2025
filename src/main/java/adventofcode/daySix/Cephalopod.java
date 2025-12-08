package adventofcode.daySix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    // Cephalopod math is written right-to-left in columns

    public Long solveForPartTwo(List<String> input) {
        long sum = 0L;
        List<Integer> operationIndexes = new ArrayList<>();
        for (int i = 0; i < input.get(input.size() - 1).length(); i++) {
            if(input.get(input.size()-1).charAt(i) != ' ') {
                operationIndexes.add(i);
            }
        }
        operationIndexes.add(input.get(0).length()+1);
        for (int i = 0; i < operationIndexes.size() - 1; i++) {
            int currentStringPos = operationIndexes.get(i);
            int endingStringPos = operationIndexes.get(i + 1) - 1;
            char operation = input.get(input.size() - 1).charAt(currentStringPos);
            long lineValue;
            if (operation == '+') {
                lineValue = 0;
            } else {
                lineValue = 1;
            }
            for (int j = currentStringPos; j < endingStringPos; j++) {
                String numberString = "";
                for (int k = 0; k < input.size()-1; k++) {
                    numberString += input.get(k).charAt(j);
                }
                long value = Integer.valueOf(numberString.toString().trim());
                if (operation == '+') {
                    lineValue += value;
                } else {
                    lineValue *= value;
                }
            }
            sum += lineValue;
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
