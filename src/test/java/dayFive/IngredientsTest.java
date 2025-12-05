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
    public void canSeeIfIngredientInRange() {
        Range range = ingredients.new Range(1,2);
        boolean expectedResponse = false;
        assertEquals(expectedResponse, ingredients.isInRange(3, range));
    }
}
