package adventofcode.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFileIntoList(String folderStructure, String fileName) {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(folderStructure + fileName + ".txt");
        try (Scanner myReader = new Scanner(inputFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }
}
