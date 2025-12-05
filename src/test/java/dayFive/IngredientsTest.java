package dayFive;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(expectedResponse, ingredients.isInRange(3, range));
    }
    
    @Test
    public void canSeeIfIngredientInRange() {
        Range range = ingredients.new Range(1,3);
        boolean expectedResponse = true;
        assertEquals(expectedResponse, ingredients.isInRange(2, range));
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
}
