package daySeven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.daySeven.Splitter;

public class SplitterTest {
    Splitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new Splitter();
    }

    @Test
    public void canRecogniseBeamStart() {
        String input = "..S..";
        List<Integer> expectedResponse = new ArrayList<>();
        expectedResponse.add(2);
        assertEquals(expectedResponse, splitter.findStartingIndex(input));
    }

    @Test
    public void canRecogniseEmptySplitAndUpdateIndex() {
        List<Integer> currentIndex = new ArrayList<>();
        currentIndex.add(2);
        String nextLine = ".....";
        List<Integer> result = splitter.findSplit(nextLine, currentIndex);
        assertEquals(currentIndex.get(0), result.get(0));
        assertEquals(currentIndex.size(), result.size());
    }
    
    @Test
    public void canRecogniseSplitAndUpdateIndex() {
        List<Integer> currentIndex = new ArrayList<>();
        currentIndex.add(2);
        String nextLine = "..^..";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        List<Integer> result = splitter.findSplit(nextLine, currentIndex);
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.get(1), result.get(1));
        assertEquals(expectedIndex.size(), result.size());
    }
    
    @Test
    public void canIgnoreFalseSplitAndUpdateIndex() {
        List<Integer> currentIndex = new ArrayList<>();
        currentIndex.add(2);
        String nextLine = ".^...";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(2);
        List<Integer> result = splitter.findSplit(nextLine, currentIndex);
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.size(), result.size());
    }

    @Test
    public void canRecogniseMultipleSplitAndUpdateIndex() {
        List<Integer> currentIndex = new ArrayList<>();
        currentIndex.add(2);
        currentIndex.add(5);
        String nextLine = "..^..^..";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        expectedIndex.add(4);
        expectedIndex.add(6);
        List<Integer> result = splitter.findSplit(nextLine, currentIndex);
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.get(1), result.get(1));
        assertEquals(expectedIndex.get(2), result.get(2));
        assertEquals(expectedIndex.get(3), result.get(3));
        assertEquals(expectedIndex.size(), result.size());
    }
}
