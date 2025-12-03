package adventofcode;

import adventofcode.dayOne.Rotations;
import adventofcode.dayTwo.Search;

public class Main {
    public static void main(String[] args) {
        // dayOne();
        dayTwo();
    }

    public static void dayOne() {
        Rotations rotations = new Rotations(50);
        rotations.readRotations("main", "input");
        System.out.println("The position ended up in: ");
        System.out.println(rotations.getPosition());
        System.out.println("The zero counter went to: ");
        System.out.println(rotations.getZeroCounter());
    }
    
    public static void dayTwo() {
        Search search = new Search();
        search.readRanges("main", "input");
        System.out.println("The counter ended up at: ");
        System.out.println(search.getCounter());
        System.out.println("The total ended up at: ");
        System.out.println(search.getInvalidTotal());
    }
}