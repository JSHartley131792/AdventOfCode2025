package daySix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.daySix.Cephalopod;

public class CephalopodTest {
    Cephalopod cephalopod;

    @BeforeEach
    void setUp() {
        cephalopod = new Cephalopod(); 
    }

    @Test
    public void canParseStringOfNumbers() {
        String[] expectedArray = {"1", "2"};
        assertArrayEquals(expectedArray, cephalopod.parseLine("1 2"));
    }
    
    @Test
    public void canParseStringOfNumbersWithRandomSpaces() {
        String[] expectedArray = {"1", "2"};
        assertArrayEquals(expectedArray, cephalopod.parseLine("1   2"));
    }

    @Test
    public void canProduceEmptySumFromLists() {
        List<String[]> input = new ArrayList<>();
        String[] zeroArray = {"0"};
        String[] plusArray = {"+"};
        input.add(zeroArray);
        input.add(plusArray);
        long expectedResult = 0L;
        assertEquals(expectedResult, cephalopod.solve());
    }
}
