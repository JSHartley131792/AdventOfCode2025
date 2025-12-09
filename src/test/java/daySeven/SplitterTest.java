package daySeven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.daySeven.Splitter;
import adventofcode.util.FileReader;

public class SplitterTest {
    Splitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new Splitter();
    }

    @Test
    public void canRecogniseBeamStart() {
        String input = "..S..";
        Set<Integer> expectedResponse = new HashSet<>();
        expectedResponse.add(2);
        splitter.findStartingIndex(input);
        assertEquals(expectedResponse, splitter.currentIndices);
    }

    @Test
    public void canRecogniseEmptySplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        Set<Integer> startingIndex = new HashSet<>();
        startingIndex.add(2);
        String nextLine = ".....";
        splitter.findSplit(nextLine);
        Set<Integer> result = splitter.currentIndices;
        assertEquals(startingIndex, result);
    }
    
    @Test
    public void canRecogniseSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        String nextLine = "..^..";
        Set<Integer> expectedIndex = new HashSet<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        splitter.findSplit(nextLine);
        Set<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex, result);
    }

    @Test
    public void canIgnoreFalseSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        String nextLine = ".^...";
        Set<Integer> expectedIndex = new HashSet<>();
        expectedIndex.add(2);
        splitter.findSplit(nextLine);
        Set<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex, result);
    }
    
    @Test
    public void canRecogniseMultipleSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..S..");
        String nextLine = "..^..^..";
        Set<Integer> expectedIndex = new HashSet<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        expectedIndex.add(4);
        expectedIndex.add(6);
        splitter.findSplit(nextLine);
        Set<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex, result);
    }

    @Test
    public void canSolveExampleForPartOne() {
        List<String> puzzleInput = FileReader.readFileIntoList("src/test/resources/daySeven/", "input");
        splitter.solveForPartOne(puzzleInput);
        int expectedResult = 21;
        assertEquals(expectedResult, splitter.splitCount);
    }
    
    @Test
    public void canRecogniseHalfSplit() {
        List<String> input = new ArrayList<>();
        input.add(".....S.....");
        input.add(".....^.....");
        input.add("......^....");
        input.add("....^..^...");
        splitter.solveForPartOne(input);
        int expectedResult = 4;
        assertEquals(expectedResult, splitter.splitCount);
    }
}
