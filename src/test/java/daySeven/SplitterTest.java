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
        splitter.findStartingIndex(input);
        assertEquals(expectedResponse, splitter.currentIndices);
    }

    @Test
    public void canRecogniseEmptySplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        List<Integer> startingIndex = new ArrayList<>();
        startingIndex.add(2);
        String nextLine = ".....";
        splitter.findSplit(nextLine);
        List<Integer> result = splitter.currentIndices;
        assertEquals(startingIndex.get(0), result.get(0));
        assertEquals(startingIndex.size(), result.size());
    }

    @Test
    public void canRecogniseSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        String nextLine = "..^..";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        splitter.findSplit(nextLine);
        List<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.get(1), result.get(1));
        assertEquals(expectedIndex.size(), result.size());
    }

    @Test
    public void canIgnoreFalseSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..");
        String nextLine = ".^...";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(2);
        splitter.findSplit(nextLine);
        List<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.size(), result.size());
    }

    @Test
    public void canRecogniseMultipleSplitAndUpdateIndex() {
        splitter.findStartingIndex("..S..S..");
        String nextLine = "..^..^..";
        List<Integer> expectedIndex = new ArrayList<>();
        expectedIndex.add(1);
        expectedIndex.add(3);
        expectedIndex.add(4);
        expectedIndex.add(6);
        splitter.findSplit(nextLine);
        List<Integer> result = splitter.currentIndices;
        assertEquals(expectedIndex.get(0), result.get(0));
        assertEquals(expectedIndex.get(1), result.get(1));
        assertEquals(expectedIndex.get(2), result.get(2));
        assertEquals(expectedIndex.get(3), result.get(3));
        assertEquals(expectedIndex.size(), result.size());
    }
}
