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
        int expectedResponse = 2;
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
}
