package dayFive;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayFive.Ingredients;
import adventofcode.dayFive.Ingredients.Range;

public class IngredientsTest {
    Ingredients ingredients;

    @BeforeEach
    void setUp() {
        ingredients = new Ingredients();
    }

    @Test
    public void canSeeIfIngredientIsNotInRange() {
        Range range = ingredients.new Range(1,2);
        boolean expectedResponse = false;
        assertEquals(expectedResponse, range.isInRange(3));
    }
    
    @Test
    public void canSeeIfIngredientInRange() {
        Range range = ingredients.new Range(1,3);
        boolean expectedResponse = true;
        assertEquals(expectedResponse, range.isInRange(2));
    }

    @Test
    public void canInterpolateStringToRange() {
        String input = "1-2";
        Range expectedRange = ingredients.new Range(1,2);
        assertEquals(expectedRange.getLower(), ingredients.parseRange(input).getLower());
        assertEquals(expectedRange.getUpper(), ingredients.parseRange(input).getUpper());
    }
    
    @Test
    public void canInterpolateStringToRangeLarger() {
        String input = "1-10";
        Range expectedRange = ingredients.new Range(1,10);
        assertEquals(expectedRange.getLower(), ingredients.parseRange(input).getLower());
        assertEquals(expectedRange.getUpper(), ingredients.parseRange(input).getUpper());
    }

    @Test
    public void canSeeIfIngredientIsSpoiled() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(5,7);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        boolean expectedResponse = false;
        assertEquals(expectedResponse, ingredients.isFresh(4));
    }
    
    @Test
    public void canSeeIfIngredientIsFresh() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(5,7);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        boolean expectedResponse = true;
        assertEquals(expectedResponse, ingredients.isFresh(3));
    }
    
    @Test
    public void canCheckAddedIngredients() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(5,7);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        ingredients.ingredients.add(4L);
        long expectedResponse = 0;
        ingredients.checkIngredients();
        assertEquals(expectedResponse, ingredients.freshIngredientCount);
    }
    
    @Test
    public void canCheckMultipleIngredients() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(5,7);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        ingredients.ingredients.add(2L);
        ingredients.ingredients.add(3L);
        ingredients.ingredients.add(4L);
        ingredients.ingredients.add(5L);
        long expectedResponse = 3;
        ingredients.checkIngredients();
        assertEquals(expectedResponse, ingredients.freshIngredientCount);
    }

    @Test
    public void canMatchRangeString() {
        boolean expected = true;
        assertEquals(expected, ingredients.isRangeString("123-456"));
    }
    
    @Test
    public void canMatchRangeStringWhenNot() {
        boolean expected = false;
        assertEquals(expected, ingredients.isRangeString("123"));
    }

    @Test
    public void canReadFileIn() {
        ingredients.readIngredients("test", "input");
        long expectedResult = 3;
        assertEquals(expectedResult, ingredients.freshIngredientCount);
    }
    
    @Test
    public void canAssessMaxFreshIngredients() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(5,7);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        long expectedResponse = 6;
        ingredients.checkMaxFreshIngredients();
        assertEquals(expectedResponse, ingredients.maxFreshUniqueIngredientCount);
    }
    
    @Test
    public void canAssessMaxFreshUniqueIngredients() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(3,5);
        ingredients.ranges.add(rangeOne);
        ingredients.ranges.add(rangeTwo);
        long expectedResponse = 5;
        ingredients.checkMaxFreshIngredients();
        assertEquals(expectedResponse, ingredients.maxFreshUniqueIngredientCount);
    }
    
    @Test
    public void canAssessMaxIngredientsInExample() {
        ingredients.readIngredients("test", "input");
        long expectedResult = 14;
        assertEquals(expectedResult, ingredients.maxFreshUniqueIngredientCount);
    }
    
    @Test
    public void canSeeIfRangesOverLap() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(3,5);
        boolean expectedResult = true;
        assertEquals(expectedResult, rangeOne.isOverlap(rangeTwo));
    }
    
    @Test
    public void canReduceOverlappingRanges() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(3,5);
        List<Range> ranges = new ArrayList<>();
        ranges.add(rangeOne);
        ranges.add(rangeTwo);
        long expectedSize = 1;
        assertEquals(expectedSize, ingredients.reduce(ranges).size());
    }
    
    @Test
    public void canReduceMixOfOverlappingRanges() {
        Range rangeOne = ingredients.new Range(1,3);
        Range rangeTwo = ingredients.new Range(3,5);
        Range rangeThree = ingredients.new Range(6,7);
        Range rangeFour = ingredients.new Range(12,15);
        Range rangeFive = ingredients.new Range(13,19);
        List<Range> ranges = new ArrayList<>();
        ranges.add(rangeOne);
        ranges.add(rangeTwo);
        ranges.add(rangeThree);
        ranges.add(rangeFour);
        ranges.add(rangeFive);
        long expectedSize = 3;
        assertEquals(expectedSize, ingredients.reduce(ranges).size());
    }
}
