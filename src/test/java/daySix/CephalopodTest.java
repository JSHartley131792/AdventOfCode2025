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
        List<String> input = new ArrayList<>();
        input.add("0");
        input.add("+");
        long expectedResult = 0L;
        assertEquals(expectedResult, cephalopod.solveForPartOne(input));
    }
    
    @Test
    public void canProduceSumFromLists() {
        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");
        input.add("3");
        input.add("+");
        long expectedResult = 6L;
        assertEquals(expectedResult, cephalopod.solveForPartOne(input));
    }
    
    @Test
    public void canProduceMultiplicationFromLists() {
        List<String> input = new ArrayList<>();
        input.add("1");
        input.add("2");
        input.add("4");
        input.add("*");
        long expectedResult = 8L;
        assertEquals(expectedResult, cephalopod.solveForPartOne(input));
    }
    
    @Test
    public void canSolveForPartOneExample() {
        List<String> partOneExample = cephalopod.readInput("test", "input");
        long expectedResult = 4277556;
        assertEquals(expectedResult, cephalopod.solveForPartOne(partOneExample));
    }
}
