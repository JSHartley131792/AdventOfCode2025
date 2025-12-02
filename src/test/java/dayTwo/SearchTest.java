package dayTwo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import adventofcode.dayTwo.Search;

// you can find the invalid IDs by looking for any ID which is 
// made only of some sequence of digits repeated twice.

public class SearchTest {
    @Test
    public void canRecogniseValidIds() {
        boolean result = Search.isInvalid(1);
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
}
