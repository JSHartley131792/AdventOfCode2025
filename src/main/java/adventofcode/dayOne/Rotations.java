package adventofcode.dayOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rotations {
    int position;
    int zeroCounter = 0;
    int dialMax = 100;

    public Rotations(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    
    public int getZeroCounter() {
        return zeroCounter;
    }

    public void rotate(int i) {
        position = (position + i) % dialMax;
        while (position < 0) {
            position += dialMax;
        }
        if (position == 0) {
            zeroCounter += 1;
        }
    }

    public void input(String inputString) {
        String orientation = inputString.substring(0, 1);
        String rotationString = inputString.substring(1, inputString.length());
        int rotation;
        switch (orientation) {
            case "L":
                rotation = -Integer.parseInt(rotationString);
                break;
            default:
                rotation = Integer.parseInt(rotationString);
                break;
        }
        rotate(rotation);
    }

    public void readRotations(String env, String fileName) {
        List<String> rotations = new ArrayList<>();
        File rotationsFile = new File("src/" + env + "/resources/dayOne/"+ fileName + ".txt");
        try (Scanner myReader = new Scanner(rotationsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                rotations.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        rotations.forEach(rotation -> input(rotation));
    }
}
