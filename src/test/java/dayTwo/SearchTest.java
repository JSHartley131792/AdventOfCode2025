package dayTwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayTwo.Search;

// you can find the invalid IDs by looking for any ID which is 
// made only of some sequence of digits repeated twice.

public class SearchTest {
    Search search;
    @BeforeEach
    public void setUpSearchState() {
        search = new Search();
    }

    @Test
    public void canRecogniseValidIds() {
        boolean result = search.isInvalid(1);
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void canRecogniseInvalidIds() {
        boolean result = search.isInvalid(11);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }

    @Test
    public void canCountInvalidsInRange() {
        search.invalidsInRange(11, 22);
        int expectedResult = 2;
        assertEquals(expectedResult, search.getCounter());
    }
    
    @Test
    public void canSumInvalidsInRange() {
        search.invalidsInRange(11, 22);
        int expectedResult = 33;
        assertEquals(expectedResult, search.getInvalidTotal());
    }

    @Test
    public void canParseMultipleRangesCommaSeparated() {
        search.parseAndCalcRanges("11-22,95-115");
        int expectedCounter = 3;
        int expectedTotal = 132;
        assertEquals(expectedCounter, search.getCounter());
        assertEquals(expectedTotal, search.getInvalidTotal());
    }
}
