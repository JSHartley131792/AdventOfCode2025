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

    public String[] switchWithinColumns(String[] numbers) {
        List<String> numberList = Arrays.asList(numbers);
        int maxLength = numberList.stream().max(Comparator.comparingInt(String::length)).get().length();
        String[] columns = new String[maxLength];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers[i].length() - 1; j >=0; j--) {
                int reversedNumber = numbers[i].length() - 1 - j;
                if(columns[reversedNumber] == null) {
                    columns[reversedNumber] = String.valueOf(numbers[i].charAt(j));
                } else {
                    columns[reversedNumber] += numbers[i].charAt(j);
                }
                reversedNumber++;
            }
        }
        return columns;
    }
    
    public String[][] switchRowsToColumns(String[][] numbers) {
        String[][] columns = new String[numbers[0].length][numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                columns[j][i] = numbers[i][j];
            }
        }
        return columns;
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
