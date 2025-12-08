package daySix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        assertArrayEquals(expectedArray, cephalopod.parseNumbers("1 2"));
    }
    
    @Test
    public void canParseStringOfNumbersWithRandomSpaces() {
        String[] expectedArray = {"1", "2"};
        assertArrayEquals(expectedArray, cephalopod.parseNumbers("1   2"));
    }
}
