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
    
    // @Test
    // public void canRecogniseInvalidIds() {
    //     boolean result = search.isInvalid(11);
    //     boolean expectedResult = true;
    //     assertEquals(expectedResult, result);
    // }

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

    // @Test
    // public void canParseMultipleRangesCommaSeparated() {
    //     search.parseAndCalcRanges("11-22,95-115");
    //     int expectedCounter = 3;
    //     int expectedTotal = 132;
    //     assertEquals(expectedCounter, search.getCounter());
    //     assertEquals(expectedTotal, search.getInvalidTotal());
    // }
    
    // @Test
    // public void canReadFileOfRanges() {
    //     search.readRanges("test", "input");
    //     int expectedCounter = 8;
    //     int expectedTotal = 1227775554;
    //     assertEquals(expectedCounter, search.getCounter());
    //     assertEquals(expectedTotal, search.getInvalidTotal());
    // }
    
    // Now, an ID is invalid if it is made only of some sequence 
    // of digits repeated at least twice. 
    // So, 12341234 (1234 two times), 
    // 123123123 (123 three times), 
    // 1212121212 (12 five times), 
    // and 1111111 (1 seven times) are all invalid IDs.
    
    @Test
    public void canRecogniseInvalidIds() {
        boolean result = search.isInvalid(11);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void canRecogniseInvalidIdsThreeRepeats() {
        boolean result = search.isInvalid(111);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void canRecogniseInvalidIdsFiveRepeats() {
        boolean result = search.isInvalid(1212121212);
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }

    @Test
    public void canReadFileOfRanges() {
        search.readRanges("test", "input");
        long expectedCounter = 13;
        long expectedTotal = Long.valueOf("4174379265");
        assertEquals(expectedCounter, search.getCounter());
        assertEquals(expectedTotal, search.getInvalidTotal());
    }
}
