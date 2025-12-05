package adventofcode;

import java.math.BigInteger;

import adventofcode.dayFive.Ingredients;
import adventofcode.dayFour.Forklifts;
import adventofcode.dayOne.Rotations;
import adventofcode.dayThree.Joltage;
import adventofcode.dayTwo.Search;

public class Main {
    public static void main(String[] args) {
        // dayOne();
        // dayTwo();
        // dayThree();
        // dayFour();
        dayFive();
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
    
    public static void dayThree() {
        Joltage joltage = new Joltage(new BigInteger("0"));
        joltage.readJoltages("main", "input");
        System.out.println("The total ended up at: ");
        System.out.println(joltage.getTotalJoltage());
    }
    
    public static void dayFour() {
        Forklifts forklifts = new Forklifts();
        forklifts.readForklifts("main", "input");
        forklifts.reEvaluateGrid();
        System.out.println("The total ended up at: ");
        System.out.println(forklifts.getTotalAccess());
        System.out.println("The total removed ended up at: ");
        System.out.println(forklifts.removedPaper);
    }
    
    public static void dayFive() {
        Ingredients ingredients = new Ingredients();
        ingredients.readIngredients("main", "input");
        System.out.println("The total of fresh ingredients ended up at: ");
        System.out.println(ingredients.freshIngredientCount);
    }
}